package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputFormPage {

    private WebDriver driver;

    public InputFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getAlert() {
        driver.findElement(By.cssSelector("#seleniumform button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
    }


}
