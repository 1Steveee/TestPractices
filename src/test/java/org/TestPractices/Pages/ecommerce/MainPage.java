package org.TestPractices.Pages.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement myAccountLink() {
        return driver.findElement(By.cssSelector("#widget-navbar-217834 > ul > li:nth-child(6) > a"));
    }

    private WebElement categoryItem(String category) {
        return driver.findElement(By.linkText(category));
    }

    private WebElement productSearchField() {
        return driver.findElement(By.name("search"));
    }

    private WebElement categoryDropdown() {
        return driver.findElement(By.cssSelector(".search-category > button"));
    }

    private WebElement searchButton() {
        return driver.findElement(By.cssSelector(".search-button > button.type-text"));
    }

    private WebElement registerLink() {
        return driver.findElement(By.cssSelector(".mz-sub-menu-96 > li:nth-child(2) > a"));
    }


    public void clickRegisterAccount() {
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountLink()).pause(Duration.ofSeconds(2))
                .click(registerLink()).build().perform();

    }

    private void selectCategory(String category) {
        categoryDropdown().click();
        categoryItem(category).click();
    }

//    public SearchPage searchForCategoryAndProduct(String category,String productName) {
//        selectCategory(category);
//        productSearchField().sendKeys(productName);
//        searchButton().click();
//        return new SearchPage(driver);
 //   }
}
