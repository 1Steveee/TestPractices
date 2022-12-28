package org.TestPractices.test.theinternet;

import org.TestPractices.Pages.TheInternet.MainPage;
import org.TestPractices.Pages.TheInternet.NestedFrames;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class SeleniumTest extends BaseTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    public void testLeftFrame() {
        NestedFrames nestedFrames = this.mainPage.clickNestedFramesLink();
        nestedFrames.switchToFrame(nestedFrames.topFrameSet());
        nestedFrames.switchToFrame(nestedFrames.frameLeft());
        assertEquals(nestedFrames.frameBody().getText(), "LEFT");

        nestedFrames.switchToParentFrame();
        nestedFrames.switchToFrame(nestedFrames.frameRight());
        assertEquals(nestedFrames.frameBody().getText(), "RIGHT");

        nestedFrames.switchToParentFrame();
        nestedFrames.switchToFrame(nestedFrames.frameMiddle());
        assertEquals(nestedFrames.frameBody().getText(), "MIDDLE");
    }
}
