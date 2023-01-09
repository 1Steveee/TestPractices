package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage {

    private WebDriver driver;

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement singleCheckbox() {
        return driver.findElement(By.id("isAgeSelected"));
    }

    private WebElement successMessage() {
        return driver.findElement(By.id("txtAge"));
    }

    public WebElement checkAllBtn() {
        return driver.findElement(By.cssSelector("input[value=\"check all\"]"));
    }

    public WebElement uncheckAllBtn() {
        return driver.findElement(By.cssSelector("input[value=\"uncheck all\"]"));
    }


    public void clickSingleCheckbox() {
        singleCheckbox().click();
    }

    public String getSuccessMessage() {
        return successMessage().getText();
    }

    public boolean isSuccessMessagePresent() {
        return successMessage().isDisplayed();
    }

    public void clickBtn(WebElement checkbox) {
        checkbox.click();
    }

    public String getCheckboxAttribute(WebElement checkbox) {
        return checkbox.getAttribute("value");
    }

    public List<WebElement> inputBtnList() {
        return driver.findElements(By.cssSelector(".cb-element"));
    }

    public boolean checkAllBtns() {
        checkAllBtn().click();
        return checkIfBtnAreChecked();
    }

    public boolean uncheckAllBtns() {
        uncheckAllBtn().click();
        return checkIfBtnAreChecked();
    }

    public String getUncheckAllBtnAttribute() {
        return uncheckAllBtn().getAttribute("value");
    }

    public String getCheckAllBtnAttribute() {
        return checkAllBtn().getAttribute("value");
    }

    public boolean checkIfBtnAreChecked() {
        List<WebElement> inputBtnList = inputBtnList();
        int numbOfBtn = inputBtnList.size();
        int numOfSelectedBtn = 0;

        for (int i = 0; i < inputBtnList.size(); i++) {
            if (inputBtnList.get(i).isSelected()) {
                numOfSelectedBtn++;
            }
        }

        if (numOfSelectedBtn == numbOfBtn) {
            return true;
        } else {
            return false;
        }
    }
}
