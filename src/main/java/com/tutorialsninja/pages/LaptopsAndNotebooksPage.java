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

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement clickOnLaptopAndNotebook;
    By productPrice = By.xpath("//p[@class ='price']");
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectdropDown;

    public void clickOnLaptopAndNoteBook() {
        clickOnElement(clickOnLaptopAndNotebook);
        CustomListeners.test.log(Status.PASS, "Click on Laptop and note book");
    }


    public List<Double> getPriceOfAllProduct() {
        List<WebElement> products = driver.findElements(productPrice);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public void selectFromDropDown(String option) {
        selectByVisibleTextFromDropDown(selectdropDown, option);
        CustomListeners.test.log(Status.PASS, "Select from dropdown");
    }

}
