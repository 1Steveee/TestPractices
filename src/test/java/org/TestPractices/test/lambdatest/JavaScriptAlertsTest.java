package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.JavaScriptAlertsPage;
import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class JavaScriptAlertsTest extends BaseTest {

    private WebDriver driver;
    private JavaScriptAlertsPage javaScriptAlertsPage;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        MainPage mainPage = new MainPage(driver);
        javaScriptAlertsPage = mainPage.clickJavaScriptAlertsLink();
    }

    @Test
    public void testJavaScriptAlertMessage() {
        assertEquals(javaScriptAlertsPage.getJavaScriptAlertMessage(), "I am an alert box!");
    }

    @Test
    public void testAlertConfirmMessage() {
        javaScriptAlertsPage.confirmAlert();
        assertEquals(javaScriptAlertsPage.getConfirmAlertMessage(), "You pressed OK!");
    }

    @Test
    public void testAlertCancelMessage() {
        javaScriptAlertsPage.cancelAlert();
        assertEquals(javaScriptAlertsPage.getConfirmAlertMessage(), "You pressed Cancel!");
    }

    @Test
    public void testPromptAcceptAlertMessage() {
        javaScriptAlertsPage.acceptPromptMessage("steven");
        assertEquals(javaScriptAlertsPage.getPromptMessage(), "You have entered 'steven' !");
    }

    @Test
    public void testPromptDismissAlertMessage() {
        javaScriptAlertsPage.cancelPromptMessage("steven");
        assertEquals(javaScriptAlertsPage.getPromptMessage(), "");
    }


}
