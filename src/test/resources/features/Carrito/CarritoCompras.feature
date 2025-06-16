Feature: Shopping Cart
  As Cliente
  I comprar varios libros
  For leer mucho

  @AddBook
  Scenario: Agregar libro al carrito de compras
    Given que el cliente se encuentra en el home de la aplicacion
    When agrega un libro al carrito de compras
    Then podra ver el libro agregado en el carrito de compras