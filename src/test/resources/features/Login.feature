Feature: Login en SauceDemo

  Scenario: Inicio de sesión exitoso
    Given que estoy en la página de login de SauceDemo
    When ingreso el usuario "standard_user" y la contraseña "secret_sauce"
    And hago clic en el botón de login
    Then debería ver el título de la página "Products"

    # ... (tu escenario existente de login exitoso, si lo tienes) ...

Scenario: Inicio de sesión fallido con credenciales inválidas
  Given que estoy en la página de login de SauceDemo
  When ingreso el usuario "invalid_user" y la contraseña "wrong_password"
  And hago clic en el botón de login
  Then debería ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"