Feature: Operaciones del catalogo de libros

  @ConsultarLibroNoExiste
  Scenario: Consultar Libro que no existe
    Given que el cliente quiere realizar el CRUD sobre los libros
    When consulta el libro con id 900
    Then vera que el libro no existe

  @CrearLibro
  Scenario: Agregar un libro al catalogo
    Given que el cliente quiere realizar el CRUD sobre los libros
    When crea un libro con la siguiente informacion
      | titulo_libro    | isbn_libro       | fechapub_libro | valoracion_libro | stock_libro | visible_libro | idcategoria_libro | idautor_libro | precio_libro |
      | Juego de tronos | 454354-55545-555 | 2008-06-17     | 4                | 40          | true          | 1                 | 12345678             | 76           |
    Then vera que el libro fue creado de manera exitosa

