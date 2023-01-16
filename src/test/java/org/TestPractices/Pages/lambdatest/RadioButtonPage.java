package org.TestPractices.Pages.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RadioButtonPage {

    private WebDriver driver;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement femaleRadioBtn() {
        return singleSelectRadioBtn().get(1);
    }

    public List<WebElement> singleSelectRadioBtn() {
        return driver.findElements(By.name("optradio"));
    }

    public WebElement maleRadioButton() {
        return singleSelectRadioBtn().get(0);
    }

    public WebElement maleGenderRadioBtn() {
        return driver.findElements(By.name("gender")).get(0);
    }

    public WebElement adultAgeGroupBtn() {
        return driver.findElements(By.name("ageGroup")).get(2);
    }

    public WebElement buttonCheck() {
        return driver.findElement(By.id("buttoncheck"));
    }

    public WebElement buttonMultipleValueCheck() {
        return driver.findElement(By.cssSelector(".input-body > div > div > button"));
    }

    public String getCheckedValue() {
        buttonCheck().click();
        return driver.findElement(By.className("radiobutton")).getText();
    }

    public void selectSingleRadioBtn(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            maleRadioButton().click();
        } else {
            femaleRadioBtn().click();
        }

    }

    public void selectMultipleRadioBtn() {
        maleGenderRadioBtn().click();
        adultAgeGroupBtn().click();
        buttonMultipleValueCheck().click();
    }

    public String getGenderValue() {
        return driver.findElement(By.className("genderbutton")).getText();
    }

    public String getAgeValue() {
        return driver.findElement(By.className("groupradiobutton")).getText();
    }
}
