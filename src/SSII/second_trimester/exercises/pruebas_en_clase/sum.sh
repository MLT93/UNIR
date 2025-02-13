#!/bin/bash
clear

echo " "; echo "¡VAMOS A SUMAR Y A HACER LA MEDIA!"; echo " "

# Valores del usuario y guardarlos en una variable (num1 y num2)
read -p "Dame el primer número: " num1
read -p "Dame el segundo número: " num2

sum=$((num1 + num2))
media=$((sum / 2))
fecha=$`date` # Para encerrar comandos (``)

echo "Calculando..."; echo " "
sleep 1  # Simula un pequeño retraso

echo "La suma es: $num1 + $num2 = $sum"
echo "La media es: ($sum) / 2 = $media"
echo "Cálculo realizado el $fecha"

echo " "; echo "GRACIAS POR USAR NUESTRA APP"; echo " "
exit 0
