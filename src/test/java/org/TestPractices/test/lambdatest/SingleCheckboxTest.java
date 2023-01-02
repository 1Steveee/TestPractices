package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.CheckboxPage;
import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class SingleCheckboxTest extends BaseTest {

    private WebDriver driver;
    private CheckboxPage checkboxPage;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        MainPage mainPage = new MainPage(driver);
        this.checkboxPage = mainPage.clickSingleCheckboxLink();
    }

    @Test
    public void testSingleCheckbox() {
        this.checkboxPage.clickSingleCheckbox();
        assertEquals(this.checkboxPage.getSuccessMessage(),"Success - Check box is checked");
        this.checkboxPage.clickSingleCheckbox();
        assertFalse(this.checkboxPage.isSuccessMessagePresent());
    }

}
