Feature: Selección de productos

  Background:
    Given que un usuario ha iniciado sesión en SauceDemo

  Scenario: Seleccionar el producto Sauce Labs Onesie
    When el usuario selecciona el producto "Sauce Labs Onesie"
    Then el usuario debería estar en la página de detalles del producto "Sauce Labs Onesie"

  Scenario: Agregar un producto al carrito
    When el usuario selecciona el producto "Sauce Labs Onesie"
    And agrega el producto al carrito
    Then el ícono del carrito debería mostrar "1"

  Scenario: Compra exitosa de un producto (End-to-End)
    # 1. Parte de Selección (Reutilizamos pasos que ya tenías)
    When el usuario selecciona el producto "Sauce Labs Onesie"
    And agrega el producto al carrito
    And el usuario hace clic en el ícono del carrito

    # 2. Parte de Checkout (Estos son los pasos nuevos que acabamos de crear)
    And hace clic en el botón de checkout
    And completa el formulario con nombre "Ariel", apellido "QA" y código postal "1234"
    And finaliza la compra

    # 3. Validación Final
    Then debería ver el mensaje de confirmación "Thank you for your order!"