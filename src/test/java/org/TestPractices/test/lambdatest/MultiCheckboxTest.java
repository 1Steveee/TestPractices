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
        this.checkboxPage.clickBtn(this.checkboxPage.checkAllBtn());
        this.checkboxPage.checkIfAllBtnChecked();
        assertTrue(this.checkboxPage.checkIfAllBtnChecked());
        assertEquals
                (this.checkboxPage.getCheckboxAttribute(checkboxPage.uncheckAllBtn()), "uncheck all");
        this.checkboxPage.clickBtn(this.checkboxPage.uncheckAllBtn());
        assertFalse(this.checkboxPage.checkIfAllBtnChecked());
        assertEquals
                (this.checkboxPage.getCheckboxAttribute(checkboxPage.checkAllBtn()), "check all");
    }

}
