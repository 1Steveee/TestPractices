package org.TestPractices.test.ecommerce;

import org.TestPractices.DriverManager;
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
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driverManager.stopDriver();
    }
}
