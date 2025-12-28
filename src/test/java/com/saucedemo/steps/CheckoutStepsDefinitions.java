package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutStepsDefinitions {

    CartPage cartPage;
    CheckoutPage checkoutPage;

    @And("hace clic en el botón de checkout")
    public void haceClicEnElBotonDeCheckout() {
        cartPage.clickBotonCheckout();
    }

    @And("completa el formulario con nombre {string}, apellido {string} y código postal {string}")
    public void completaElFormulario(String nombre, String apellido, String cp) {
        checkoutPage.completarFormulario(nombre, apellido, cp);
    }

    @And("finaliza la compra")
    public void finalizaLaCompra() {
        checkoutPage.clickBotonFinish();
    }

    @Then("debería ver el mensaje de confirmación {string}")
    public void deberiaVerElMensajeDeConfirmacion(String mensajeEsperado) {
        String mensajeActual = checkoutPage.obtenerMensajeConfirmacion();
        Assert.assertEquals(mensajeEsperado, mensajeActual);
    }
}