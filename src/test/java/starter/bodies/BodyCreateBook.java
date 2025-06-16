package starter.bodies;

public class BodyCreateBook {

    public BodyCreateBook(String titulo_libro, String isbn_libro, String fechapub_libro, String valoracion_libro, Integer stock_libro, Boolean visible_libro, Integer idcategoria_libro, Integer idautor_libro, Integer precio_libro) {
        this.titulo_libro = titulo_libro;
        this.isbn_libro = isbn_libro;
        this.fechapub_libro = fechapub_libro;
        this.valoracion_libro = valoracion_libro;
        this.stock_libro = stock_libro;
        this.visible_libro = visible_libro;
        this.idcategoria_libro = idcategoria_libro;
        this.idautor_libro = idautor_libro;
        this.precio_libro = precio_libro;
    }

    private String titulo_libro;
    private String isbn_libro;
    private String fechapub_libro;
    private String valoracion_libro;
    private Integer stock_libro;
    private Boolean visible_libro;
    private Integer idcategoria_libro;
    private Integer idautor_libro;
    private Integer precio_libro;
}
