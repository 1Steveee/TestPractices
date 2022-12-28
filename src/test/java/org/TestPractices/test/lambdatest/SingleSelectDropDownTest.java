package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.DropDownPage;
import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class SingleSelectDropDownTest extends BaseTest {

    private WebDriver driver;
    private DropDownPage dropDownPage;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        MainPage mainPage = new MainPage(driver);
        this.dropDownPage = mainPage.clickDrownDownLink();
    }

    @Test
    public void testSelectByText() {
        this.dropDownPage.selectByText("Friday");
        assertEquals(dropDownPage.getSelectedOptionText(), "Day selected :- Friday");
    }

    @Test
    public void testSelectByIndex() {
        this.dropDownPage.selectByIndex(1);
        assertEquals(dropDownPage.getSelectedOptionText(), "Day selected :- Sunday");
    }

    @Test
    public void testSelectByValue() {
        this.dropDownPage.selectByValue("Tuesday");
        assertEquals(dropDownPage.getSelectedOptionText(), "Day selected :- Tuesday");
    }

    @Test
    public void testDisplayAllOptions() {
        dropDownPage.getAllDropDownOptions();
    }

}
