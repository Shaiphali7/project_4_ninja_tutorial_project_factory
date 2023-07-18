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

public class TopMenuPage extends Utility {
    By topMenuId = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    @CacheLookup
    @FindBy(xpath = "//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]")
    WebElement desktop;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebook;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement getLaptopsAndNotebookText;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentText;

    public void selectMenu(String menu) {
        List<WebElement> topMenuList =getListOfElements(topMenuId);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getListOfElements(topMenuId);
        }


    }

    public void mouseHoverMenuDesktop() {
        mouseHoverToElementAndClick(desktop);
        CustomListeners.test.log(Status.PASS, "MouseHover on desktop");
    }

    public void mouseHoverMenuOnLaptopAndNotebook() {
        mouseHoverToElementAndClick(laptopsAndNotebook);
        CustomListeners.test.log(Status.PASS, "MouseHover on Laptop and notebook");
    }

    public void mouseHoverMenuComponent() {
        mouseHoverToElementAndClick(components);
        CustomListeners.test.log(Status.PASS, "MouseHover on component");
    }

    public String getTextFromMenu(String text) {
        return getTextFromElement(By.xpath("//h2[contains(text()," + "'" + text + "'" + ")]"));
    }
}


