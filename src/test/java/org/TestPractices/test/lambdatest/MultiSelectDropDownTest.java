package org.TestPractices.test.lambdatest;

import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class MultiSelectDropDownTest extends BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
    }
}
