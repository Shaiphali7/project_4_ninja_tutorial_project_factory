package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DesktopAddToCart extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    //By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement clickOnShoppingCart;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement verifyShoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement verifyProductName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement verifyDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement verifyModel;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement verifyTotal;

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

   /* public String getSuccessMessage() {
        return gettextFromElement(successMessage);
    }*/

    public void clickOnShoppingCart() {
        clickOnElement(clickOnShoppingCart);
        CustomListeners.test.log(Status.PASS, "Click on shopping cart");
    }

    public String getShoppingCartText() {
        return getTextFromElement(verifyShoppingCartText);
    }

    public String getHpProductName() {
        return getTextFromElement(verifyProductName);
    }

    public String getDate() {
        return getTextFromElement(verifyDate);
    }

    public String getModel() {
        return getTextFromElement(verifyModel);
    }

    public String getTotal() {
        return getTextFromElement(verifyTotal);
    }


}
