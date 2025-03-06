package biblioteca;


/**
 * Clase inherente a los libros de la biblioteca
 *
 * @author marcoslt93
 * @version 1.0
 */
public class Libro {

    // TODO: Documentar estos atributos
    /**
     * @field titulo
     * @field autor
     * @field anioPublicacion
     */
    private String titulo;
    private String autor;
    private int anioPublicacion;

    // TODO: Documentar este método
    // TODO: Testear este método
    /**
     *
     * @param titulo
     * @param autor
     * @param anioPublicacion
     */
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // TODO: Documentar este método
    /**
     *
     * @return autor
     */
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // TODO: Documentar este método
    /**
     *
     * @return anioPublicacion
     */
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
}
