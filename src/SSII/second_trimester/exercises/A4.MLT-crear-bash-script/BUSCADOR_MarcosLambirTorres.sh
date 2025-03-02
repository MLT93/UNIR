#!/bin/bash

# Agarrar 2 parámetros posicionales:
echo " "; 
echo "Fichero, $1!.";
echo "Directorio, $2!.";
echo " "

# Guardo valores de los parámetros en variables:
fichero=$1
directorio=$2

# Pedir palabra al usuario:
read -p "Dame una palabra para buscar en fichero y directorio: " palabraABuscar

# Creo archivo SALIDAS.txt:
touch SALIDAS.txt

# Vacío el archivo SALIDAS.txt:
echo > SALIDAS.txt

# Escribo en el archivo con '>>', escribo también la palabra y busco en él con 'grep -i' escrito en el archivo:
echo "Buscando en '$fichero': " >> SALIDAS.txt
echo "$palabraABuscar" >> SALIDAS.txt
grep -i "$palabraABuscar" "$fichero" >> SALIDAS.txt

# Agrego separador con comando de escape `-e` escrito en el archivo:
echo -e "\n******************\n" >> SALIDAS.txt

# Busco la palabra en el directorio de manera recursiva con `-ri` escrito en el archivo:
echo "Resultados de la búsqueda en el directorio '$directorio':" >> SALIDAS.txt
grep -ri "$palabraABuscar" "$directorio" >> SALIDAS.txt

# Mensaje final escrito en el archivo:
echo "ESTO ES TODO AMIGOOOOS!!!" >> SALIDAS.txt

# Mostrar mensaje de finalización
echo "Búsqueda terminada..."
echo "Resultados en 'SALIDAS.txt': ";echo " "
