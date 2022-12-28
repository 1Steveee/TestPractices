package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {

    private WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public Select singleDropDown() {
        WebElement singleSelectDropDown = driver.findElement(By.id("select-demo"));
        return new Select(singleSelectDropDown);
    }

    public void selectByText(String text) {
        singleDropDown().selectByVisibleText(text);
    }

    public WebElement getSelectedOption() {
        return driver.findElement(By.cssSelector("p.selected-value"));
    }

    public String getSelectedOptionText() {
        return getSelectedOption().getText();
    }

}
