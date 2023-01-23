package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.InputFormPage;
import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InputFormTest extends BaseTest {

    private WebDriver driver;
    private InputFormPage inputFormPage;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        MainPage mainPage = new MainPage(driver);
        this.inputFormPage = mainPage.clickInputFormLink();
    }

    @Test
    public void testAlert() {
        inputFormPage.getAlert();
    }


}
