package biblioteca;

import org.junit.jupiter.api.*;

import biblioteca.Biblioteca;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    private Biblioteca biblioteca;

    // Ejecuto esto antes de cada test
    @BeforeEach
    void setUp() {
        this.biblioteca = new Biblioteca();
    }

    @DisplayName("Valorar el agregado del Libro")
    @Test
    void agregarLibro() {
        Libro libro = new Libro("aa", "yo", 2025);
        boolean result = biblioteca.agregarLibro(libro);
        try {
            assertTrue(biblioteca.getLibros().contains(libro), "Sí contiene el libro");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void eliminarLibro() {
        Libro libro = new Libro("aa", "yo", 2025);
        biblioteca.agregarLibro(libro);
        boolean resultado = biblioteca.eliminarLibro(libro);
        try {
            assertTrue(resultado, "El libro debería haberse eliminado correctamente.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void encuentraLibroPorTitulo() {
        Libro libro = new Libro("aa", "yo", 2025);
        biblioteca.agregarLibro(libro);
        try {
            Libro libroEncontrado = biblioteca.encuentraLibroPorTitulo("aa");
            assertNotNull(libroEncontrado, "El libro se ha encontrado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void encuentraLibrosPorAutor() {
            Libro libro1 = new Libro("aa", "yo", 2025);
            Libro libro2 = new Libro("bb", "yo", 2024);
            biblioteca.agregarLibro(libro1);
            biblioteca.agregarLibro(libro2);
        try {
            List<Libro> librosEncontrados = biblioteca.encuentraLibrosPorAutor("yo");
            assertEquals(2, librosEncontrados.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}