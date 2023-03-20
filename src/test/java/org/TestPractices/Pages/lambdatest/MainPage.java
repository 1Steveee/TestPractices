package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Type;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement findElementByLinkText(String text) {
        return driver.findElement(By.linkText(text));
    }

    public DropDownPage clickDrownDownLink() {
        findElementByLinkText("Select Dropdown List").click();
        return new DropDownPage(driver);
    }

    public CheckboxPage clickCheckboxLink() {
        findElementByLinkText("Checkbox Demo").click();
        return new CheckboxPage(driver);
    }

    public RadioButtonPage clickRadioButtonLink() {
        findElementByLinkText("Radio Buttons Demo").click();
        return new RadioButtonPage(driver);
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        findElementByLinkText("Javascript Alerts").click();
        return new JavaScriptAlertsPage(driver);
    }

    public TablePage clickTablePaginationLink() {
        findElementByLinkText("Table Pagination").click();
        return new TablePage(driver);
    }

    public InputFormPage clickInputFormLink() {
        findElementByLinkText("Input Form Submit").click();
        return new InputFormPage(driver);
    }

    public DatePickerPage clickDatePickerLink() {
        findElementByLinkText("Bootstrap Date Picker").click();
        return new DatePickerPage(driver);
    }
}
