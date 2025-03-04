#!/bin/bash
clear

# DECLARACIÓN SIMPLE
var="mi variable"
echo " "; echo "Esta es mi var"; echo " " 

echo "¡VAMOS A SUMAR Y A HACER LA MEDIA!"; echo " "

# GUARDAR VALORES EN VARIABLES INTRODUCIDOS POR EL USUARIO (num1 y num2)
read -p "Dame el primer número: " num1
read -p "Dame el segundo número: " num2

# VARIABLES
sum=$((num1 + num2))
media=$((sum / 2))
fecha=$`date` # Para encerrar comandos se usa ``

echo "Calculando..."; echo " "
sleep 1  # Simula un pequeño retraso

echo "La suma es: $num1 + $num2 = $sum"
echo "La media es: ($sum) / 2 = $media"
echo "Cálculo realizado el $fecha"

echo " "; echo "GRACIAS POR USAR NUESTRA APP"; echo " "
exit 0
