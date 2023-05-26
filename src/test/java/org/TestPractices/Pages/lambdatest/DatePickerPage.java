package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class DatePickerPage {

    private WebDriver driver;

    public DatePickerPage(WebDriver driver){
        this.driver = driver;
    }


    private WebElement singleDateInput() {
        return driver.findElement(By.id("birthday"));
    }

    private WebElement startDate() {
        return driver.findElement(By.cssSelector("#datepicker > input:nth-child(1)"));
    }

    private WebElement endDate() {
        return driver.findElement(By.cssSelector("#datepicker > input:nth-child(3)"));
    }

    public String getStartDateText() {
        return startDate().getAttribute("value");
    }

    public String getEndDateText() {
        return endDate().getAttribute("value");
    }
    public void selectSingleDate(String date) {
        singleDateInput().sendKeys(date);
    }

    public String getSingleDateInput() {
        return singleDateInput().getAttribute("value");
    }

    public void selectMultiDates(String startDate, String endDate) {
        startDate().sendKeys(startDate);
        endDate().sendKeys(endDate);
    }

}
