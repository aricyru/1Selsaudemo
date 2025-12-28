// src/test/java/com/saucedemo/pages/LoginPage.java
package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
// Ya no necesitarías este import si eliminas la anotación @DefaultUrl
// import net.serenitybdd.annotations.DefaultUrl;

// Elimina esta línea:
//@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    // 1. Localizadores
    @FindBy(id = "user-name")
    private WebElementFacade inputUsername;

    @FindBy(id = "password")
    private WebElementFacade inputPassword;

    @FindBy(id = "login-button")
    private WebElementFacade btnLogin;

    @FindBy(className = "title")
    private WebElementFacade labelTitle;

    // Localizador actualizado para el mensaje de error
    @FindBy(css = "h3[data-test='error']")
    private WebElementFacade errorMessage;

    // 2. Acciones
    public void escribirUsuario(String usuario) {
        inputUsername.type(usuario);
    }

    public void escribirPassword(String password) {
        inputPassword.type(password);
    }

    public void clickEnLogin() {
        btnLogin.click();
    }

    public String obtenerTitulo() {
        return labelTitle.getText();
    }

    // Nuevo método para obtener el mensaje de error
    public String obtenerMensajeDeError() {
        return errorMessage.getText();
    }
}