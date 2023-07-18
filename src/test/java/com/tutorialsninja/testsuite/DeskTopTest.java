package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.DeskTopPage;
import com.tutorialsninja.pages.DesktopAddToCart;
import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Listeners(CustomListeners.class)
public class DeskTopTest extends BaseTest {

    TopMenuPage menu;
    DeskTopPage deskTop;
    DesktopAddToCart addToCart;

    @BeforeMethod(groups = {"sanity","smoke","regression","regression1"})
    public void inIt() {
        menu = new TopMenuPage();
         deskTop = new DeskTopPage();
       addToCart = new DesktopAddToCart();
    }




     @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        menu.mouseHoverMenuDesktop();
        //1.2 Click on “Show All Desktops”
        deskTop.clickOnShowAllDesktop();

        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = deskTop.getDesktopProduct();

        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        //1.3 Select Sort By position "Name: Z to A"
        deskTop.selectFromDropDown();
        // After filter Z -A Get all the products name and stored into array list
        ArrayList<String> products = deskTop.getDesktopProduct();
        System.out.println(products);
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(originalProductsName, products, "Product not sorted into Z to A order");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Select currency as £ Pound Sterling
        deskTop.clickOnCurrency();
        //2.1 Mouse hover on Desktops Tab. and click
        menu.mouseHoverMenuDesktop();
        //2.2 Click on “Show All Desktops”
        deskTop.clickOnShowAllDesktop();
        //2.3 Select Sort By position "Name: A to Z"
        deskTop.selectByA_ZDropDown();
        //2.4 Select product “HP LP3065”
        deskTop.selectHpProduct();
        //2.5 Verify the Text "HP LP3065"
        String actualHpProduct = deskTop.getTextForHpProduct();
        Assert.assertEquals(actualHpProduct, "HP LP3065", "HP LP3065 Product not display");
        //2.6 Select Delivery Date "2023-11-30"
        String year = "2023";
        String month = "November";
        String date = "30";
        deskTop.clickOnDateElement();
        while (true) {
            String monthAndYear = deskTop.getDate();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                deskTop.clickOnNextDateElement();
            }
        }
        List<WebElement> allDates = deskTop.getDateElements();
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
        //2.8 Click on “Add to Cart” button
        addToCart.clickOnAddToCart();
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
//        Assert.assertTrue(addToCart.getSuccessMessage()
//                        .contains("Success: You have added HP LP3065 to your shopping cart!"));
        Thread.sleep(1000);
        //2.10 Click on link “shopping cart” display into success message
        addToCart.clickOnShoppingCart();
        //2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(addToCart.getShoppingCartText().contains("Shopping Cart"));
        //2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals("HP LP3065", addToCart.getHpProductName(), "Product name not matched");
        //2.13 Verify the Delivery Date "2022-11-30"
        Assert.assertTrue(addToCart.getDate().contains("2023-11-30"), "Delivery date not matched");
        //2.14 Verify the Model "Product21"
        Assert.assertEquals("Product 21", addToCart.getModel(), "Model not matched");
        //2.15 Verify the Todat "£74.73"
        Assert.assertEquals("$122.00", addToCart.getTotal(), "Total not matched");

    }


}
