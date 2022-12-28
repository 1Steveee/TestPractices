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

    public DropDownPage clickDrownDownLink() {
        dropDownListLink().click();
        return new DropDownPage(driver);
    }
}
