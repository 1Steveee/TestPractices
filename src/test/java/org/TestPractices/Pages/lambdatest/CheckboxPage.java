package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage {

    private WebDriver driver;

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement singleCheckbox() {
        return driver.findElement(By.id("isAgeSelected"));
    }

    public WebElement successMessage() {
        return driver.findElement(By.id("txtAge"));
    }

    public WebElement checkAllBtn() {
        return driver.findElement(By.cssSelector("input[value=\"check all\"]"));
    }

    public WebElement uncheckAllBtn() {
        return driver.findElement(By.cssSelector("input[value=\"uncheck all\"]"));
    }

    public List<WebElement> getAllInputBtn() {
        return driver.findElements(By.cssSelector(".cb-element"));
    }

    public void clickSingleCheckbox() {
        singleCheckbox().click();
    }

    public String getSuccessMessage() {
        return successMessage().getText();
    }

    public boolean isSuccessMessagePresent() {
        return successMessage().isDisplayed();
    }

    public void clickBtn(WebElement checkbox) {
        checkbox.click();
    }

    public String getCheckboxAttribute(WebElement checkbox) {
        return checkbox.getAttribute("value");
    }

}
