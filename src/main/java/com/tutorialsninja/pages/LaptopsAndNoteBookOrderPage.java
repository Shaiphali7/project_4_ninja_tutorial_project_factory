package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LaptopsAndNoteBookOrderPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement poundCurrency;

    public void clickOnCurrencyOption() {
        clickOnElement(poundCurrency);
        CustomListeners.test.log(Status.PASS, "Click on Currency");
    }
    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    WebElement dropDown;
    public void selectFromDropDown(String option)
    {
        selectByVisibleTextFromDropDown(dropDown,option);
        CustomListeners.test.log(Status.PASS, "Select from dropdownmenu");
    }
    @CacheLookup
    @FindBy(linkText ="MacBook" )
    WebElement macBook;

    public void clickOnMackbook() {
        clickOnElement(macBook);
        CustomListeners.test.log(Status.PASS, "Click on macBook product");
    }
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")

    WebElement clickOnAddButton;

    public void ClickOnAddButton() {
        clickOnElement(clickOnAddButton); CustomListeners.test.log(Status.PASS, "Click on Add Button");
    }

   // WebElement successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");

  /*  public String getSuccessMessage() {
        return gettextFromElement(successMessage);
    }*/
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")

    WebElement shoppingCart;

    public void ClickOnShoppingCart() {
        clickOnElement(shoppingCart);
        CustomListeners.test.log(Status.PASS, "Click on shopping cart");
    }
    @CacheLookup
    @FindBy(xpath ="//div[@id='content']//h1")

    WebElement shoppingCartText;

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")

    WebElement productName;

    public String productName() {
        return getTextFromElement(productName);
    }
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")

    WebElement changeQuantity;

    public void changeQuantity() {
        sendTextToElement(changeQuantity, "2");
    }
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")

    WebElement clickOnUpdate;

    public void setClickOnUpdate() {
    clickOnElement(clickOnUpdate);
        CustomListeners.test.log(Status.PASS, "Click on update button");
    }
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successMessage2;
    public String getSuccessMessage2()
    {
        return getTextFromElement(successMessage2);

    }
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement productPrice;

    public String getProductPrice()
    {
        return getTextFromElement(productPrice);

    }
}
