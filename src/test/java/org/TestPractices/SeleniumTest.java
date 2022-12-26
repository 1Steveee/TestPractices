package org.TestPractices;

import org.TestPractices.Pages.TheInternet.MainPage;
import org.TestPractices.Pages.TheInternet.NestedFrames;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class SeleniumTest extends BaseTest{

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
        String actualMessage = "LEFT";
        assertEquals(nestedFrames.frameBody().getText(), actualMessage);
    }

    @Test
    public void testRightFrame() {
        NestedFrames nestedFrames = this.mainPage.clickNestedFramesLink();
        nestedFrames.switchToFrame(nestedFrames.topFrameSet());
        nestedFrames.switchToFrame(nestedFrames.frameRight());
        String actualMessage = "RIGHT";
        assertEquals(nestedFrames.frameBody().getText(), actualMessage);
    }


}
