#!/bin/bash

# Agarrar 2 parámetros posicionales:
echo " "; 
echo "########### Primer  valor introducido: $1 ###########";
echo "########### Segundo valor introducido: $2 ###########";
echo " "

if [ -z "$1" ] || [ -z "$2" ]; then
    echo "Debe introducir dos valores para los parámetros posicionales al ejecutar este archivo."
    exit 1
fi

valor1="$1"
valor2="$2"

aux=""
while true; do
    echo "Elige una operación matemática"; echo " "
    echo "1) Multiplicar"
    echo "2) Dividir"
    echo "3) Sumar"
    echo "4) Restar"
    echo "5) Salir"
    echo " "
    read -p "Selecciona una opción (1-5): " aux

    case $aux in
        1) echo " "; 
           read -p "Has elegido Multiplicar, presiona [Enter] para continuar...";
           echo " "; 
           echo "El resultado de tu Multiplicación es: $((valor1 * valor2))"
           echo " "
           ;;
        2) read -p "Has elegido Dividir, presiona [Enter] para continuar...";
            if [ "$valor2" -eq 0 ]; then
                echo "Error: No se puede dividir por cero."
                echo " "
            else
                echo " "; 
                echo "El resultado de tu División es: $((valor1 / valor2))"
                echo " "
            fi
           ;;
        3) read -p "Has elegido Sumar, presiona [Enter] para continuar...";
           echo " "; 
           echo "El resultado de tu Suma es: $((valor1 + valor2))"
           echo " "
           ;;
        4) read -p "Has elegido Restar, presiona [Enter] para continuar...";
           echo " "; 
           echo "El resultado de tu Resta es: $((valor1 - valor2))"
           echo " "
           ;;
        # Break y salir
        5) read -p "Has elegido Salir, presiona [Enter] para continuar...";
           echo " "; 
           echo "Saliendo..."; 
           echo "Gracias por usar este programa!"; 
           echo " "
           break 
           ;;
        # Default y opción por defecto
        *) echo " "
           echo "###########################################"
           echo "### Opción no válida, intenta de nuevo. ###"
           echo "###########################################"
           echo " "
           read -p "Presiona [Enter] para continuar..."
           ;;
    esac

    read -p "Presiona [Enter] para volver al menú..."; 
done
