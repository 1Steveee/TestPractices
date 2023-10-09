package org.TestPractices.test.ecommerce;

import org.TestPractices.Pages.ecommerce.MainPage;
import org.TestPractices.Pages.ecommerce.RegistrationPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest extends BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setupTest() {
        driver = driverManager.getDriver();
        driver.get("https://ecommerce-playground.lambdatest.io");
    }

    @Test
    public void testSignUp() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillField();

    }
}
