package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.DropDownPage;
import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Arrays;
import static org.testng.AssertJUnit.assertTrue;

public class MultiSelectDropDownTest extends BaseTest {

    private WebDriver driver;
    private DropDownPage dropDownPage;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        MainPage mainPage = new MainPage(driver);
        this.dropDownPage = mainPage.clickDrownDownLink();
    }

    @Test
    public void testSelectMultipleValues() {
        String[] textToBeSelected = new String[] {"Florida", "Ohio", "Texas"};
        this.dropDownPage.selectMultipleByVisibleText(textToBeSelected);
        assertTrue(Arrays.equals(this.dropDownPage.getMultiSelectedOptions(), textToBeSelected));
    }

    @Test
    public void testDeselectMultipleValues() {
        String[] textToBeSelected = new String[] {"California","Florida","New Jersey","New York",
                "Ohio","Texas","Pennsylvania","Washington"};
        String[] testValues = new String[] {"California", "Florida"};

        this.dropDownPage.selectMultipleByVisibleText(textToBeSelected);
        this.dropDownPage.deselectAllValues();
        this.dropDownPage.selectMultipleByVisibleText(testValues);
        assertTrue(Arrays.equals(this.dropDownPage.getMultiSelectedOptions(), testValues));

    }


}
