package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductDetailsPage extends PageObject {

    // --- Selectors (Apodos) ---
    @FindBy(css = ".inventory_details_name")
    private WebElementFacade productDetailsTitle;

    // --- Methods (Acciones) ---

    // Este es el que ya tenías para leer el título
    public String getProductDetailsTitle() {
        return productDetailsTitle.getText();
    }

    // 1. Hacé clic en el botón "Add to cart"
    // Nota: El selector "#add-to-cart" busca por ID
    public void clickBotonAgregarAlCarrito() {
        $("#add-to-cart").click();
    }

    // 2. Leé el numerito rojo del carrito
    // Nota: El selector ".shopping_cart_badge" busca por Clase CSS
    public String obtenerNumeroDelCarrito() {
        return $(".shopping_cart_badge").getText();
    }

    // 3. Hacé clic en el ícono del carrito para ir al Checkout
    public void clickIconoDelCarrito() {
        $(".shopping_cart_link").click();
    }

} // <--- ¡OJO! Esta llave cierra la clase. Todo debe estar ARRIBA de ella.