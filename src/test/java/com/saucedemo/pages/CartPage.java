package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {

    // Hace clic en el botón "Checkout" usando su ID
    public void clickBotonCheckout() {
        $("#checkout").click();
    }
}