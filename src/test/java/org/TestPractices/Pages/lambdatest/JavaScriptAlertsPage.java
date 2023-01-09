package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.TestPractices.utilities.Helper.refreshPage;

public class JavaScriptAlertsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Alert alert;

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public WebElement alertBtn() {
        return driver.findElement(By.cssSelector(".btn.btn-dark.my-30"));
    }

    public WebElement confirmAlertBtn() {
        return driver.findElements(By.cssSelector(".btn.btn-dark.mx-10")).get(1);
    }

    public WebElement promptAlertBtn() {
        return driver.findElements(By.cssSelector(".btn.btn-dark.mx-10")).get(2);
    }

    public WebElement confirmMessage() {
        return driver.findElement(By.id("confirm-demo"));
    }

    public WebElement promptMessage() {
        return driver.findElement(By.id("prompt-demo"));
    }

    public String getJavaScriptAlertMessage() {
        alertBtn().click();
        this.alert = switchToAlert();
        String alertMessage = this.alert.getText();
        this.alert.accept();
        return alertMessage;
    }


    public void confirmAlert() {
        confirmAlertBtn().click();
        this.alert = switchToAlert();
        this.alert.accept();
    }

    public void cancelAlert() {
        confirmAlertBtn().click();
        this.alert = switchToAlert();
        this.alert.dismiss();
    }

    public Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    public String getConfirmAlertMessage() {
        return confirmMessage().getText();
    }

    public void acceptPromptMessage(String name) {
        setPromptMessage(name);
        this.alert.accept();
    }

    public void cancelPromptMessage(String name) {
        refreshPage(driver);
        setPromptMessage(name);
        this.alert.dismiss();
    }

    public String getPromptMessage() {
        return promptMessage().getText();
    }

    public void setPromptMessage(String name) {
        promptAlertBtn().click();
        this.alert = switchToAlert();
        this.alert.sendKeys(name);
    }
}
