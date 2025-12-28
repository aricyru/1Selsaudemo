package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;

public class CheckoutPage extends PageObject {

    // 1. Método para llenar el formulario y darle a Continuar
    public void completarFormulario(String nombre, String apellido, String cp) {
        $("#first-name").sendKeys(nombre);
        $("#last-name").sendKeys(apellido);
        $("#postal-code").sendKeys(cp);
        $("#continue").click();
    }

    // 2. Método para el botón final de Finish
    public void clickBotonFinish() {
        $("#finish").click();
    }

    // 3. Método para validar el mensaje final de éxito
    public String obtenerMensajeConfirmacion() {
        return $(".complete-header").getText();
    }
}