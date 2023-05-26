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
    public void testSingleDatePicker()  {
        this.datePickerPage.selectSingleDate("04/03/2025");
        assertEquals("2025-04-03", this.datePickerPage.getSingleDateInput());
    }

    @Test
    public void testMultiDateRange() {
        this.datePickerPage.selectMultiDates("04/03/2025", "05/05/2025");
        assertEquals("04/03/2025", this.datePickerPage.getStartDateText());
        assertEquals("05/05/2025", this.datePickerPage.getEndDateText());
    }
}
