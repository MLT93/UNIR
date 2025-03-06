package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    private Libro libro;
    private Biblioteca biblioteca;

    // Ejecuto esto antes de cada test
    @BeforeEach
    void setUp() {
        this.biblioteca = new Biblioteca();
        this.libro = new Libro("aa", "yo", 2025);
        biblioteca.agregarLibro(libro);
    }

    @DisplayName("Comprobar si funciona el constructor")
    @Test
    void comprobarConstructor() {
        try {
            assertTrue(biblioteca.getLibros().contains(libro), "El libro se ha creado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}