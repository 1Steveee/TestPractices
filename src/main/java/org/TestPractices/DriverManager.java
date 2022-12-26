package org.TestPractices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void startBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            createChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            createEdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            createFireFoxDriver();
        } else {
            System.out.println("Browser should either be chrome, edge, or firefox.");
        }
    }

    public void createFireFoxDriver() {
        driver = new FirefoxDriver();
    }

    public void createEdgeDriver() {
        driver = new EdgeDriver();
    }

    public void createChromeDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver();
    }

    public void stopDriver() {
        driver.close();
    }
}
