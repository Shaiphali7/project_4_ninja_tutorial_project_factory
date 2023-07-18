package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DeskTopPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement showAlldesktop;
    By allProducts = By.xpath("//h4/a");
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement dropDown;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement poundCurrency;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")

    WebElement productHp;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyTextHp;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement clickOnElementforDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement getStringForDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement clickOnNextDate;
    By lastDateElement = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");

    public void clickOnShowAllDesktop() {
        clickOnElement(showAlldesktop);
        CustomListeners.test.log(Status.PASS, "Click on show all desktop");
    }

    public ArrayList<String> getDesktopProduct() {
        List<WebElement> products = driver.findElements(allProducts);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }

    public void selectFromDropDown() {
        selectByVisibleTextFromDropDown(dropDown, "Name (Z - A)");
        CustomListeners.test.log(Status.PASS, "Select from filter dropdown");

    }

    public void clickOnCurrency() {
        clickOnElement(poundCurrency);
        CustomListeners.test.log(Status.PASS, "Click on currency");
    }

    public void selectByA_ZDropDown() {
        selectByVisibleTextFromDropDown(dropDown, "Name (A - Z)");
        CustomListeners.test.log(Status.PASS, "Select from filter dropdown A-Z");
    }

    public void selectHpProduct() {
        clickOnElement(productHp);
        CustomListeners.test.log(Status.PASS, "Select hp product");
    }

    public String getTextForHpProduct() {
        return getTextFromElement(verifyTextHp);
    }

    public void clickOnDateElement() {
        clickOnElement(clickOnElementforDate);
        CustomListeners.test.log(Status.PASS, "Click on date");
    }

    public String getDate() {
        return getTextFromElement(getStringForDate);

    }

    public void clickOnNextDateElement() {
        clickOnElement(clickOnNextDate);
        CustomListeners.test.log(Status.PASS, "Click on next date");
    }

    public List<WebElement> getDateElements() {
        return driver.findElements(lastDateElement);
    }
}
