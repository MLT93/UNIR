# Script BASH .sh

Crea un script bash, que se llamará **BUSCADOR.sh** y ejecútalo para probar si funciona tal como se describe a continuación.

El script recogerá dos parámetros que serán un fichero y un directorio, que estarán en el directorio actual de lanzamiento. 

Al ejecutar el script con los parámetros nos pedirá por teclado una palabra que buscará en el fichero y en el directorio indicado recursivamente. Finalmente, el script redireccionará los resultados de las búsquedas en un fichero que se llamará **SALIDAS.txt**.

Primero estará en el fichero 'salidas' el resultado de el fichero, después habrá una separación de asteriscos, a continuación estará el resultado de la ejecución recursiva del directorio, y al final se avisará de la finalización del proceso con: "ESTOS ES TODO AMIGOOOOS!!!".

Nota: Siempre se generará la salida nueva, no se añadirá.

Ejemplo de uso:
```bash
./BUSCADOR.sh castilla.txt VACACIONES

TOLEDO
```
