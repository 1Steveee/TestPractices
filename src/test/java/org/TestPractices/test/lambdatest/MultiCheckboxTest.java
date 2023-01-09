package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.CheckboxPage;
import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class MultiCheckboxTest extends BaseTest {

    private WebDriver driver;
    private CheckboxPage checkboxPage;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        MainPage mainPage = new MainPage(driver);
        this.checkboxPage = mainPage.clickCheckboxLink();
    }

    @Test
    public void testCheckAllBtn() {
        assertTrue(this.checkboxPage.checkAllBtns());
        assertEquals(this.checkboxPage.getUncheckAllBtnAttribute(), "uncheck all");
        assertFalse(this.checkboxPage.uncheckAllBtns());
        assertEquals(this.checkboxPage.getCheckAllBtnAttribute(), "check all");
    }

}
