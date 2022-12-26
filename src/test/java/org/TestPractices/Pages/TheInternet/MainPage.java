package org.TestPractices.Pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement nestedFramesLink() {
        return driver.findElement(By.xpath("//a[text() = 'Nested Frames']"));
    }

    public NestedFrames clickNestedFramesLink() {
        nestedFramesLink().click();
        return new NestedFrames(driver);
    }
}
