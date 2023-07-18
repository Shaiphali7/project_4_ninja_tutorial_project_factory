package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends Utility {
    By myAccount = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = webElementList(myAccount);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = webElementList(myAccount);
        }
    }

   // @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    //@FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]")
    WebElement myAccountLink;

    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
        CustomListeners.test.log(Status.PASS, "Click on Account link");
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")

    WebElement verifyRegisterAcc;

    public String getTextFromRegisterPage() {
        return getTextFromElement(verifyRegisterAcc);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")

    WebElement verifyReturnCustomer;

    public String getTextFromLoginPage() {
        return getTextFromElement(verifyReturnCustomer);

    }
    @CacheLookup
    @FindBy(xpath= "//input[@id='input-firstname']")

    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement phone;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;
    By subscribeButton = By.xpath("//fieldset[3]//input");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement ContinueButton2;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogOut;

    public void sendTextToFirstName(String firstname) {
        sendTextToElement(firstName, firstname);
        CustomListeners.test.log(Status.PASS, "Enter firstname" + firstname);
    }

    public void sendTextToLastName(String lastname) {
        sendTextToElement(lastName, lastname);
        CustomListeners.test.log(Status.PASS, "Enter lastname " + lastname);
    }

    public void sendTextToEmail(String email1) {
        sendTextToElement(email, email1);
        CustomListeners.test.log(Status.PASS, "Enter email " + email1);
    }

    public void sendTextToPhone(String phoneno) {
        sendTextToElement(phone, phoneno);
        CustomListeners.test.log(Status.PASS, "Enter phoneno " + phoneno);
    }

    public void sendTextToPassword(String password1) {
        sendTextToElement(password, password1);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password1);
    }

    public void sendTextToConfirmPassword(String confirmPass) {
        sendTextToElement(confirmPassword, confirmPass);
        CustomListeners.test.log(Status.PASS, "Enter confirm Password " + confirmPass);
    }

    public void setSubscribeButton() {
        selectByContainsTextFromListOfElements(subscribeButton, "Yes");
    }

    public void clickOnPrivacyPolicy() {
        clickOnElement(privacyPolicy);
        CustomListeners.test.log(Status.PASS, "Click on privacy policy");
    }

    public String successMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public String accountLogOutMessage() {
        return getTextFromElement(accountLogOut);
    }

    public void clickOnContinue2() {
        clickOnElement(ContinueButton2);
        CustomListeners.test.log(Status.PASS, "Click on next continue button");
    }

    //User login
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement enterEmail;

    public void enterEmail(String email) {
        sendTextToElement(enterEmail, email);
        CustomListeners.test.log(Status.PASS, "Enter email" +email);
    }

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")

    WebElement loginButton;

    public void clickOnSubmitButton() {
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }


}


