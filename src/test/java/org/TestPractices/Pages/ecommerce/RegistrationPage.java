package org.TestPractices.Pages.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement firstNameField() {
        return driver.findElement(By.id("input-firstname"));
    }

    private WebElement lastNameField() {
        return driver.findElement(By.id("input-lastname"));
    }

    private WebElement passwordField() {
        return driver.findElement(By.id("input-password"));
    }

    private WebElement telephoneField() {
        return driver.findElement(By.id("input-telephone"));
    }

    private WebElement emailField() {
        return driver.findElement(By.id("input-email"));
    }

    public void fillField() {

        firstNameField().sendKeys("hello");
        lastNameField().sendKeys("hello");
        passwordField().sendKeys("hello");
        telephoneField().sendKeys("hello");
        emailField().sendKeys("hello");
    }

    public void signUp(String firstName, String lastName, String email, String telephone, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickRegisterAccount();


        fillField();
    }
}
