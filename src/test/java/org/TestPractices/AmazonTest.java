package org.TestPractices;

import org.TestPractices.Pages.Amazon.MainPage;
import org.TestPractices.Pages.Amazon.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class AmazonTest extends BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
    }

    @Test
    public void testSearchResultTitle() {
        MainPage mainPage = new MainPage(driver);
        mainPage.searchTerm("piano");
        String firstResultTitle = mainPage.getFirstResultText();
        ProductPage productPage = mainPage.clickLink(mainPage.firstResult());
        assertTrue(firstResultTitle.equalsIgnoreCase(productPage.getTitleText()));
    }
}
