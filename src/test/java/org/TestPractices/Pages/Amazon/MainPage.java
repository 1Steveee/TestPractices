package org.TestPractices.Pages.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class MainPage {

    private WebDriver driver;
    private ProductPage productPage;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement searchBox() {
        return driver.findElement(By.id("twotabsearchtextbox"));
    }

    public WebElement submitBtn() {
        return driver.findElement(By.id("nav-search-submit-button"));
    }

    public WebElement firstResult() {
        return driver.findElement(By.cssSelector("h2 > a"));
    }

    public void searchTerm(String wordSearch) {
        searchBox().sendKeys(wordSearch);
        submitBtn().click();
    }

    public ProductPage clickLink(WebElement webElement) {
        final String originalWindow = driver.getWindowHandle ();
        webElement.click();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds (10));
        wait.until(numberOfWindowsToBe(2));
        for (final String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals (windowHandle)) {
                productPage = new ProductPage(driver.switchTo().window(windowHandle));
                break;
            }
        }
        return productPage;
    }

    public String getFirstResultText() {
        return firstResult().getText();
    }

}
