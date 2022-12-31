package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;


public class DropDownPage {

    private WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public Select singleDropDown() {
        WebElement singleSelectDropDown = driver.findElement(By.id("select-demo"));
        return new Select(singleSelectDropDown);
    }

    public Select multiDropDown() {
        WebElement multiSelectDropDown = driver.findElement(By.id("multi-select"));
        return new Select(multiSelectDropDown);
    }

    public void selectByText(String text) {
        singleDropDown().selectByVisibleText(text);
    }

    public WebElement getSelectedOption() {
        return driver.findElement(By.cssSelector("p.selected-value"));
    }

    public String getSelectedOptionText() {
        return getSelectedOption().getText();
    }

    public void selectByIndex(int index) {
        singleDropDown().selectByIndex(index);
    }

    public void selectByValue(String value) {
        singleDropDown().selectByValue(value);
    }

    public void getAllDropDownOptions() {
        List<WebElement> options = singleDropDown().getOptions();
        options.forEach(option -> {
            System.out.println(option.getText());
        });
    }

    public void selectMultipleByVisibleText(String[] textToBeSelected) {


        for (int i = 0; i < textToBeSelected.length; i++) {
            multiDropDown().selectByVisibleText(textToBeSelected[i]);
        }
    }

    public String[] getMultiSelectedOptions() {

        List<WebElement> selectedOptions = multiDropDown().getAllSelectedOptions();
        int numOfSelectedValues = selectedOptions.size();
        String[] selectedValues = new String[numOfSelectedValues];

        for (int i = 0; i < numOfSelectedValues; i++) {
            selectedValues[i] = selectedOptions.get(i).getText();
        }

        return selectedValues;
    }

    public void deselectMultipleValues(String[] textToBeDeselected) {
        for (int i = 0; i < textToBeDeselected.length; i++) {
            multiDropDown().deselectByVisibleText(textToBeDeselected[i]);
        }
    }
}
