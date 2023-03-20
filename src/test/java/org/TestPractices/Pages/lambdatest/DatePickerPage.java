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

    private WebElement startDateField() {
        return driver.findElement(By.cssSelector("#datepicker > input:nth-child(1)"));
    }

    private WebElement bodyRoot() {
        return driver.findElement(By.cssSelector("#__next > section.mt-50 > div > div > div.w-8\\/12.smtablet\\:w-full > div:nth-child(3) > div.bg-yellow-500.text-size-18.font-semibold.px-10.py-10.text-black"));
    }
    private WebElement calendarMonthAndYear() {
        return driver.findElement(By.cssSelector(".datepicker-days > table > thead > tr:nth-child(2) > th.datepicker-switch"));
    }

    private WebElement calendarDate(String date) {
        return driver.findElement(By.xpath("//td[text()='" + date + "']"));
    }

    private String[] getCurrentMonthAndYearText() {
        String[] monthAndYearList = new String[2];
        String currentMonthAndYear = calendarMonthAndYear().getText();
        monthAndYearList[0] = currentMonthAndYear.split(" ")[0].trim();
        monthAndYearList[1] = currentMonthAndYear.split(" ")[1].trim();
        return monthAndYearList;
    }

    private WebElement nextMonth() {
        return driver.findElement(By.cssSelector(".datepicker-days > table > thead > tr:nth-child(2) > th.next"));
    }
    public void selectFromDate(String month, String date, String year) {
        startDateField().click();
        String[] monthAndYear = getCurrentMonthAndYearText();

        while (((!monthAndYear[0].equals(month)) && !(monthAndYear[1].equals(year))) || ((!monthAndYear[0].equals(month)) && (monthAndYear[1].equals(year)))) {
            monthAndYear = getCurrentMonthAndYearText();
            nextMonth().click();
        }

        calendarDate(date).click();
    }

    public String getStartDateFieldText() throws InterruptedException {
        bodyRoot().click();
        Thread.sleep(5000);
        return startDateField().getText();
    }
}
