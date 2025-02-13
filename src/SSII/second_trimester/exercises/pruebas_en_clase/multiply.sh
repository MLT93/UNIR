#!/bin/bash
clear

echo "TABLA DE MULTIPLICAR DE "; echo " "

for n in {1..10}; do
  # $1 es un parámetro que introduce el utente
  multi=$(($1*$n))
  echo "$1 * $n = $multi"
done

echo "GRACIAS POR USAR NUESTRA APP"; echo " "

exit 0
