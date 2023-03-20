package org.TestPractices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager {

    private static final String HUB_URL = "http://localhost:4444";
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
        } else if (browser.equalsIgnoreCase("remote_chrome")) {
            createRemoteChromeDriver();
        } else if (browser.equalsIgnoreCase("remote_edge")) {
            createRemoteEdgeDriver();
        }

        else {
            System.out.println("Browser should either be chrome, edge, or firefox.");
        }
    }

    private void createRemoteEdgeDriver() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("MicrosoftEdge");
        try {
            driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createRemoteChromeDriver() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFireFoxDriver() {
        driver = new FirefoxDriver();
    }

    private void createEdgeDriver() {
        driver = new EdgeDriver();
    }

    private void createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public void stopDriver() {
        driver.close();
    }
}
