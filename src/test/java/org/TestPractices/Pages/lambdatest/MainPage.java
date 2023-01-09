package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement dropDownListLink() {
        return driver.findElement(By.xpath("//a[text()=\"Select Dropdown List\"]"));
    }

    public WebElement checkboxLink() {
        return driver.findElement(By.xpath("//a[text()=\"Checkbox Demo\"]"));
    }

    public WebElement radioButtonLink() {
        return driver.findElement(By.linkText("Radio Buttons Demo"));
    }

    public WebElement javaScriptAlertsLink() {
        return driver.findElement(By.linkText("Javascript Alerts"));
    }

    public DropDownPage clickDrownDownLink() {
        dropDownListLink().click();
        return new DropDownPage(driver);
    }

    public CheckboxPage clickCheckboxLink() {
        checkboxLink().click();
        return new CheckboxPage(driver);
    }

    public RadioButtonPage clickRadioButtonLink() {
        radioButtonLink().click();
        return new RadioButtonPage(driver);
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        javaScriptAlertsLink().click();
        return new JavaScriptAlertsPage(driver);
    }
}
