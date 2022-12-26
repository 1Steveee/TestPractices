package org.TestPractices.Pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrames {

    private WebDriver driver;

    public NestedFrames(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement topFrameSet() {
        return driver.findElement(By.name("frame-top"));
    }

    public WebElement frameBody() {
        return driver.findElement(By.tagName("body"));
    }

    public WebElement frameLeft() {
        return driver.findElement(By.name("frame-left"));
    }

    public WebElement frameRight() {
        return driver.findElement(By.name("frame-right"));
    }

    public void switchToFrame(WebElement frame) {
        driver.switchTo().frame(frame);
    }

    public String getText() {
        return frameBody().getText();
    }

}
