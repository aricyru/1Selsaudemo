package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import static org.junit.Assert.assertEquals;

public class LoginStepsDefinitions {

    @Steps
    LoginPage loginPage; // Serenity inicializa automáticamente tus Page Objects

    @Given("que estoy en la página de login de SauceDemo")
    public void queEstoyEnLaPaginaDeLogin() {
        loginPage.open(); // Abre la URL base configurada en serenity.conf
    }

    // Paso reutilizable para iniciar sesión
    @Given("que un usuario ha iniciado sesión en SauceDemo")
    public void queUnUsuarioHaIniciadoSesionEnSauceDemo() {
        queEstoyEnLaPaginaDeLogin(); // Navega a la página de login
        ingresoElUsuarioYLaContrasena("standard_user", "secret_sauce"); // Usa credenciales válidas del serenity.conf
        hagoClicEnElBotonDeLogin();
        // Opcional: Podríamos agregar una verificación aquí si la página de productos se carga
    }

    @When("ingreso el usuario {string} y la contraseña {string}")
    public void ingresoElUsuarioYLaContrasena(String usuario, String contrasena) {
        loginPage.escribirUsuario(usuario);
        loginPage.escribirPassword(contrasena);
    }

    @And("hago clic en el botón de login")
    public void hagoClicEnElBotonDeLogin() {
        loginPage.clickEnLogin();
    }

    @Then("debería ver el título de la página {string}")
    public void deberiaVerElTituloDeLaPagina(String tituloEsperado) {
        // Comparamos el texto real del navegador contra lo que escribimos en el Gherkin
        String tituloActual = loginPage.obtenerTitulo();
        assertEquals(tituloEsperado, tituloActual);
    }

    @Then("debería ver el mensaje de error {string}")
    public void deberiaVerElMensajeDeError(String mensajeEsperado) {
        String mensajeActual = loginPage.obtenerMensajeDeError();
        assertEquals(mensajeEsperado, mensajeActual);
    }
}