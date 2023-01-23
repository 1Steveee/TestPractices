package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TablePage {

    private WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    private Select maxRowDropDown() {
        WebElement dropDown = driver.findElement(By.id("maxRows"));
        return new Select(dropDown);
    }

    private WebElement table() {
        return driver.findElement(By.id("table-id"));
    }

    private WebElement tableBody() {
        return table().findElement(By.tagName("tbody"));
    }

    private List<WebElement> getRows() {
        return tableBody().findElements(By.tagName("tr"));
    }

    public void setDropdownMaxRowDisplay(String maxRows) {
        maxRowDropDown().selectByValue(maxRows);
    }

    public int getTotalNumberOfRows() {
        List<WebElement> rows = getRows();
        int numOfRowsDisplayed = 0;
        for (WebElement row : rows) {
            if (row.isDisplayed()) {
                numOfRowsDisplayed++;
            }
        }

        return numOfRowsDisplayed;
    }

    public ArrayList<String> getRowData(int rowNumber) {
        List<WebElement> rows = getRows();
        List<WebElement> cells = rows.get(rowNumber - 1).findElements(By.tagName("td"));

        ArrayList<String> rowData = new ArrayList<>();

        cells.forEach(cell -> {
            rowData.add(cell.getText());
        });

        return rowData;
    }

    public ArrayList<String> expectedValues(String[] strings) {
        ArrayList<String> expectedValuesArray = new ArrayList<>();
        int listSize = strings.length;

        for (int i = 0; i < listSize; i++) {
            expectedValuesArray.add(strings[i]);
        }

        return expectedValuesArray;
    }
}
