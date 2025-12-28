package com.saucedemo.steps;

import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.ProductDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import static org.junit.Assert.assertEquals;

public class InventoryStepsDefinitions {

    @Steps
    InventoryPage inventoryPage;

    @Steps
    ProductDetailsPage productDetailsPage;

    @When("el usuario selecciona el producto {string}")
    public void elUsuarioSeleccionaElProducto(String productName) {
        inventoryPage.selectProduct(productName);
    }

    @Then("el usuario debería estar en la página de detalles del producto {string}")
    public void elUsuarioDeberiaEstarEnLaPaginaDeDetallesDelProducto(String expectedProductName) {
        // BORRÉ LA LÍNEA QUE BUSCABA "Products" AQUÍ PORQUE YA CAMBIAMOS DE PÁGINA

        // Solo verificamos el título del producto nuevo
        String actualProductName = productDetailsPage.getProductDetailsTitle();
        assertEquals(expectedProductName, actualProductName);
    }
    @io.cucumber.java.en.And("agrega el producto al carrito")
    public void agregaElProductoAlCarrito() {
        productDetailsPage.clickBotonAgregarAlCarrito();
    }

    @io.cucumber.java.en.Then("el ícono del carrito debería mostrar {string}")
    public void elIconoDelCarritoDeberiaMostrar(String cantidadEsperada) {
        String cantidadActual = productDetailsPage.obtenerNumeroDelCarrito();
        org.junit.Assert.assertEquals(cantidadEsperada, cantidadActual);

    }

    @And("el usuario hace clic en el ícono del carrito")
    public void elUsuarioHaceClicEnElIconoDelCarrito() {
        productDetailsPage.clickIconoDelCarrito();
    }
}