

package calculadora;
/**
 * Esta clase implementará todos los métodos que están relacionados con la suma de la calculadora. Esta
 * clase tendrá los siguientes métodos:
 * 1. Suma de dos números reales, tendrá 2 parámetros de entrada y uno de salida que será la solución.
 * 2. Suma de dos números enteros, tendrá 2 parámetros de entrada y uno de salida que será la solución.
 * 3. Suma de tres números reales, tendrá 3 parámetros de entrada y uno de salida que será la solución.
 * ---
 * Clase solicitada para realizar la suma.
 *
 * @author Stephen Nicholas Jones De Giorgi -- github: https://github.com/L0cksat
 * @version 0.1
 */

public class Suma {
private static double numAcumulado = 0;
    /*
     * Ahora añadimos el constructor sin ningún parámetros.
     */

    public Suma() {
    }

    public static double getNumAcumulado() {
        return numAcumulado;
    }

    /**
 * Suman dos números reales
 * @param numReal1 Primer número real para sumar
 * @param numReal2 Segundo número real para sumar
 * @return devuelve la suma de los parámetros anteriormente declarados.
 */
public double sumaDosNumReals(double numReal1, double numReal2){
        return numReal1 + numReal2;
    }


/**
 * Suman dos números enteros
 * @param numEntero1 Primer número entero para sumar
 * @param numEntero2 Segundo número entero para sumar
 * @return devuelve la suma de los parámetros anteriormente declarados.
 */
    public int sumaDosEnteros(int numEntero1, int numEntero2){
        return numEntero1 + numEntero2;
    }


    /**
     * Suman dos números enteros
     * @param numReal1 Primer número real para sumar
     * @param numReal2 Segundo número real para sumar
     * @param numReal3 Tercer número real para sumar
     * @return devuelve la suma de los parámetros anteriormente declarados.
     */

    public double sumaTresNumReals(double numReal1, double numReal2, double numReal3){
            return numReal1 + numReal2 + numReal3;
        }


    /**
     * Suman dos números enteros
     * @param numSumar Número real para sumar
     * @return devuelve la suma de los parámetros anteriormente declarados.
     */
    public double sumaAcumulado(double numSumar){

         numAcumulado += numSumar;
        return numAcumulado;
    }
}
