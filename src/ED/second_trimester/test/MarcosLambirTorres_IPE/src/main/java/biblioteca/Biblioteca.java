package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase inherente a la biblioteca
 *
 * @author marcoslt93
 * @version 1.0
 */
public class Biblioteca {

    // TODO: Documentar estos atributos
    /**
     *  Crea una constante con la lista de libros y accesibilidad privada
     */
    private final List<Libro> libros;

    // TODO: Documentar este método
    /**
     * Crea una lista de libros vacía
     */
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    // TODO: Documentar este método.
    //  Test: NO HAY QUE TESTEAR ESTE METODO
    /**
     * Añade una lista de libros
     * @param libros
     */
    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }

    // TODO: Testear este metodo.
    //  Test: Comprobar si se ha agregado
    /**
     * Añade un libro a la lista
     * @param libro
     * @return
     */
    public boolean agregarLibro(Libro libro) {
        return libros.add(libro);
    }

    // TODO: Testear este metodo.
    //  Test: comprobar si se ha eliminado
    /**
     * Elimina un libro de la lista
     * @param libro
     * @return lista nueva sin el libro eliminado
     */
    public boolean eliminarLibro(Libro libro) {
        return libros.remove(libro);
    }

    // TODO: Documentar este método
    /**
     * Devuelve la lista
     * @return libros
     */
    public List<Libro> getLibros() {
        return libros;
    }

    // TODO: Documentar este método.
    //  Test 01: buscar libro existente y comprobar que lo localiza.
    //  Test 02: buscar libro NO existente y comprobar que no lo localiza.
    /**
     * Busca un libro según el título. Si lo encuentra, lo devuélve
     * @param titulo
     * @return libro encontrado
     */
    public Libro encuentraLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    // TODO: Documentar este metodo.
    //  No testearlo
    // Este metodo está obsoleto. Hay que documentarlo como tal.
    //  Recuerda: las anotaciones @deprecated y @link a la nueva
    //  versión mejorada encuentraLibrosPorAutor(...)
    //  En esta ocasión, NO TESTEAREMOS este metodo
    /**
     * @deprecated Método fuera de uso. Utilizar {@link #encuentraLibrosPorAutor(String)}
     * @since 1.0
     */
    @Deprecated
    public Libro encuentaLibroPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }

    // TODO: Documentar este metodo
    // Este metodo sustituye al metodo anterior. Está disponible desde la
    //  versión 2.0. Hay que documentarlo teniéndolo en cuenta.
    // TODO: Testear este metodo.
    //  Test: Comprobar la lista de libros que devuelve para un autor existentes.
    //  Test: Comprobar la lista de libros que devuelve para un autor No existente
    /**
     * Método sustitudo de {@link #encuentaLibroPorAutor(String)}
     * @param autor
     * @return devuélve una lista de libros con el libro buscado. Si no hay lista, lo añade.
     * @since 2.0
     */
    public List<Libro> encuentraLibrosPorAutor(String autor) {
        List<Libro> listaLibros = null;
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                if (listaLibros == null) {
                    listaLibros = new ArrayList<>();
                }
                listaLibros.add(libro);
            }
        }
        return listaLibros;
    }
}