/* PRINCIPIO DE SUSTITUCIÓN EN JAVA */
package testing;

import negocio.*;

public TestingInterface {
  public static void main(String [] args) {
    
    // Dentro de un obj ICountry DAO me entra cualquier clase que implemente esa interface
    /* 
      Si mi obj es de tipo `ICountryDao`, aunque la clase `CountryDaoImplList` 
      posea más métodos, en tiempo de escritura veré sólo las funciones de la interfaz, 
      y en tiempo de ejecución veré TODAS las funciones porque así funciona JAVA
    */
    /* 
       Entonces: Si mi obj si es de tipo `List` veré los métodos de esa interfaz
       en tiempo de escritura, y en tiempo de ejecución veré el desarrollo de esos métodos

       JAVA sabe que lo que tiene la interfaz manda
    */
    ICountryDao variableObj = new CountryDaoImplList();
  }
}
