package org.TestPractices.test.lambdatest;

import org.TestPractices.Pages.lambdatest.MainPage;
import org.TestPractices.Pages.lambdatest.TablePage;
import org.TestPractices.test.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

public class TablePageTest extends BaseTest {

    private WebDriver driver;
    private TablePage tablePage;

    @BeforeClass
    public void setUpTest() {
        driver = driverManager.getDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        MainPage mainPage = new MainPage(driver);
        this.tablePage = mainPage.clickTablePaginationLink();
    }

    @Test
    public void testSetMaximumRows() {
        tablePage.setDropdownMaxRowDisplay("10");
        assertEquals(tablePage.getTotalNumberOfRows(), 10);
    }

    @Test
    public void testValidateRowData() {
        tablePage.setDropdownMaxRowDisplay("10");
        ArrayList<String> rowData = tablePage.getRowData(2);
        assertEquals(rowData, tablePage.expectedValues(new String[]{"2",
                "Kuame Parsons","non.sapien@in.com", "1-962-122-8834", "Aug 2, 2015"}));
    }
}
