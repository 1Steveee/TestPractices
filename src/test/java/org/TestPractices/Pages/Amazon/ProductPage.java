package org.TestPractices.Pages.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement title() {
        return driver.findElement(By.id("title"));
    }

    public String getTitleText() {
        return title().getText();
    }
}
