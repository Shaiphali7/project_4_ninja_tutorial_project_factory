package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class UserRegisterAccountSuccessfully extends BaseTest  {
    MyAccountPage accountPage;
    @BeforeMethod(groups = {"sanity","smoke","regression","regression1"})
    public void inIt()
    {
        accountPage=new MyAccountPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        MyAccountPage accountPage=new MyAccountPage();
        //4.1 Click on My Account Link.
        accountPage.clickOnMyAccountLink();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login”
        accountPage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        accountPage.enterEmail("prime1233@gmail.com");
        //4.4 Enter Password
        accountPage.sendTextToPassword("test1234");
        Thread.sleep(3000);
        //4.5 Click on Login button
        accountPage.clickOnSubmitButton();
        //4.8 Click on My Account Link.
        Thread.sleep(3000);

        accountPage.clickOnMyAccountLink();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountPage.selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = accountPage.accountLogOutMessage();
        Assert.assertEquals(expectedMessage, actualMessage,"Not logged out");
        //4.11 Click on Continue button
        accountPage.clickOnContinue2();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        accountPage.clickOnMyAccountLink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        accountPage.selectMyAccountOptions("Register");
        Thread.sleep(2000);
        //3.3 Enter First Name
        accountPage.sendTextToFirstName("CoCo");
        //3.4 Enter Last Name
        accountPage.sendTextToLastName("Miachal");
        //3.5 Enter Email
        accountPage.sendTextToEmail("Abcd12360@gmail.com");
        //3.6 Enter Telephone
        accountPage.sendTextToPhone("07988112233");
        //3.7 Enter Password
        accountPage.sendTextToPassword("test123");
        //3.8 Enter Password Confirm
        accountPage.sendTextToConfirmPassword("test123");
        //3.9 Select Subscribe Yes radio button
        accountPage.setSubscribeButton();
        //3.10 Click on Privacy Policy check box
        accountPage.clickOnPrivacyPolicy();
        //3.11 Click on Continue button
       accountPage.clickOnContinue();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals("Your Account Has Been Created!",accountPage.successMessage());
        //3.13 Click on Continue button
        accountPage.clickOnContinue2();
        //3.14 Click on My Account Link.
        accountPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = accountPage.accountLogOutMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        //3.17 Click on Continue button
       accountPage.clickOnContinue2();
    }


}
