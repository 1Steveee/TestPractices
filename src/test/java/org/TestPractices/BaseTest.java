package org.TestPractices;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected DriverManager driverManager;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUpTest(String browser) {
        driverManager = new DriverManager();
        driverManager.startBrowser(browser);
        driverManager.getDriver().get("https://www.amazon.in/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driverManager.stopDriver();
    }
}
