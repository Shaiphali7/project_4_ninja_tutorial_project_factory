package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.LaptopsAndNoteBookOrderPage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
@Listeners(CustomListeners.class)
public class LaptopAndNoteBooksProductTest extends BaseTest {
    LaptopsAndNoteBookOrderPage orderPage;
    TopMenuPage menu;
    LaptopsAndNotebooksPage laptopAndNote;

    LaptopsAndNotebooksPage notebooksPage;
    @BeforeMethod(groups = {"sanity","smoke","regression","regression1"})
    public void inIt()
    {
        orderPage=new LaptopsAndNoteBookOrderPage();
        menu=new TopMenuPage();
        laptopAndNote=new LaptopsAndNotebooksPage();
        notebooksPage=new LaptopsAndNotebooksPage();

    }
    @Test(groups = {"sanity","regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {
        // Select currency as £ Pound Sterling
        orderPage.clickOnCurrencyOption();
        //orderPage.selectFromDropDown("£Pound Sterling");
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        menu.mouseHoverMenuOnLaptopAndNotebook();
        //2.2 Click on “Show All Laptops & Notebooks”
        notebooksPage.clickOnLaptopAndNoteBook();
        //2.3 Select Sort By "Price (High > Low)"
        notebooksPage.selectFromDropDown("Price (High > Low)");
        //2.4 Select Product “MacBook”
        orderPage.clickOnMackbook();
//        //2.5 Verify the text “MacBook”
//        Assert.assertEquals("MacBook",orderPage.productName(),"MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
        orderPage.ClickOnAddButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        //Assert.assertTrue(orderPage.getSuccessMessage().contains("Success: You have added MacBook to your shopping cart!"),"Product not added to cart");
        //2.8 Click on link “shopping cart” display into success message
        orderPage.ClickOnShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(orderPage.getShoppingCartText().contains("Shopping Cart"));
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals("MacBook", orderPage.productName(),"Product name not matched");
        //2.11 Change Quantity "2"
        orderPage.changeQuantity();
        //2.12 Click on “Update” Tab
        orderPage.setClickOnUpdate();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(orderPage.getSuccessMessage2().contains("Success: You have modified your shopping cart!"),"Cart not modified");
        //2.14 Verify the Total £737.45
        Assert.assertEquals("$1,204.00", orderPage.getProductPrice(),"Total not matched");


    }
    @Test(groups = {"smoke","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        menu.mouseHoverMenuOnLaptopAndNotebook();
        //1.2 Click on “Show AllLaptops & Notebooks”
        laptopAndNote.clickOnLaptopAndNoteBook();
        // Get all the products price and stored into array list

        List<Double> originalProductsPrice = laptopAndNote.getPriceOfAllProduct();
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        //1.3 Select Sort By "Price (High > Low)"
        laptopAndNote.selectFromDropDown("Price (High > Low)");

        // After filter Price (High > Low) Get all the products price and stored into array list

        List<Double> afterSortByPrice = laptopAndNote.getPriceOfAllProduct();

        System.out.println(afterSortByPrice);
        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(originalProductsPrice, afterSortByPrice,"Product not sorted by price High to Low");

    }



}
