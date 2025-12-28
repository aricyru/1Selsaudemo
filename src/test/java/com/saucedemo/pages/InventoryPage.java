package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class InventoryPage extends PageObject {

    @FindBy(className = "title")
    private WebElementFacade productsPageTitle;

    public WebElementFacade productItem(String productName) {
        // Genera el data-test dinámicamente: "inventory-item-sauce-labs-onesie-img"
        String dataTestAttribute = "inventory-item-" + productName.toLowerCase().replace(" ", "-") + "-img";
        return find(By.cssSelector("img[data-test='" + dataTestAttribute + "']"));
    }

    public String getProductsPageTitle() {
        return productsPageTitle.getText();
    }

    public void selectProduct(String productName) {
        WebElementFacade product = productItem(productName);
        // Hacer scroll hasta el elemento
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", product);
        product.click();
    }
}