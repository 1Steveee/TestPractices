package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.Pages.lambdatest.RadioButtonPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class RadioButtonTest extends BaseTest {

    private WebDriver driver;
    private RadioButtonPage radioButtonPage;

    @BeforeClass
    public void setUpTest() {
        this.driver = driverManager.getDriver();
        this.driver.get("https://www.lambdatest.com/selenium-playground/");
        MainPage mainPage = new MainPage(driver);
        this.radioButtonPage = mainPage.clickRadioButtonLink();
    }

    @Test
    public void testSingleRadioBtn() {
        this.radioButtonPage.selectSingleRadioBtn();
        assertEquals(this.radioButtonPage.getCheckedValue(), "Radio button 'Female' is checked");
    }

    @Test
    public void testGroupRadioBtn() {
        this.radioButtonPage.selectMultipleRadioBtn();
        assertEquals(this.radioButtonPage.getGenderValue(), "Male");
        assertEquals(this.radioButtonPage.getAgeValue(), "15 - 50");
    }
}
