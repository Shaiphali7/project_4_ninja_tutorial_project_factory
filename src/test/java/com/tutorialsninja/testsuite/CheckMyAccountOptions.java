package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class CheckMyAccountOptions extends BaseTest {
    MyAccountPage myAccount;
    @BeforeMethod(groups = {"sanity","smoke","regression","regression1"})
            public void inIt()
    {
        myAccount=new MyAccountPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully()throws InterruptedException {
        //1.1 Click on My Account Link.
        myAccount.clickOnMyAccountLink();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter "Register”
        myAccount.selectMyAccountOptions("Register");
        Thread.sleep(1000);
        //1.3 Verify the text “Register Account”.
        String expectedMessage = "Register Account";
        String actualMessage = myAccount.getTextFromRegisterPage();
        Assert.assertEquals(expectedMessage, actualMessage,"Register page not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //2.1 Click on My Account Link.
        myAccount.clickOnMyAccountLink();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccount.selectMyAccountOptions("Login");
        Thread.sleep(1000);
        //2.3 Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = myAccount.getTextFromLoginPage();
        Assert.assertEquals( expectedMessage, actualMessage,"Login page not displayed");
    }

}
