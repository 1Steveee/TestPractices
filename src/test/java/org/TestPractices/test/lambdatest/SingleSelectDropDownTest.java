package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.DropDownPage;
import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.TestPractices.utilities.Helper.takeScreenShot;
import static org.testng.AssertJUnit.assertEquals;

public class SingleSelectDropDownTest extends BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickDrownDownLink();
    }

    @Test
    public void testSelectByText() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.selectByText("Friday");
        takeScreenShot(driver);
        assertEquals(dropDownPage.getSelectedOptionText(), "Day selected :- Friday");
    }
}
