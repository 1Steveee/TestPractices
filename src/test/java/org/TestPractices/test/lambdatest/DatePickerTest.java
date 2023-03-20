package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.DatePickerPage;
import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DatePickerTest extends BaseTest {

    private WebDriver driver;
    private DatePickerPage datePickerPage;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-date-picker-demo");
        MainPage mainPage = new MainPage(driver);
        this.datePickerPage = mainPage.clickDatePickerLink();
    }

    @Test
    public void testDateRangePicker() throws InterruptedException {
        this.datePickerPage.selectFromDate("December", "20", "2024");
        assertEquals(this.datePickerPage.getStartDateFieldText(), "12/20/2024");
    }
}
