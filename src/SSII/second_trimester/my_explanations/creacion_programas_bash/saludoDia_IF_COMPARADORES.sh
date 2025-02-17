#!/bin/bash

# Obtener la hora actual

horactual=$(date +%H)
echo " "; echo "Son las $horactual horas:"; echo " "

# Obtener saludo con IF y COMPARADORES

# Ejemplo de uso:
# ```bash
# if [ 3 -lt 5 ]; then
#     echo "3 es menor que 5"
# fi
# ```
# ✔ Esto imprimirá: `3 es menor que 5`

# 🔹 **Resumen rápido de operadores numéricos en Bash:**
# - `-eq` → Igual a (`==`)
# - `-ne` → No es igual a (`!=`)
# - `-gt` → Mayor que (`>`)
# - `-ge` → Mayor o igual que (`>=`)
# - `-lt` → Menor que (`<`)
# - `-le` → Menor o igual que (`<=`)
# Si necesitas comparar cadenas en lugar de números, deberías usar `[[ "cadena1" < "cadena2" ]]` en lugar de `[ cadena1 -lt cadena2 ]`, porque `-lt` solo funciona con valores numéricos.

if [ $horactual -ge 6 ] && [ $horactual -le 12 ]; then # -ge es '>=' (greater)
	echo "¡Buenos días!"; echo " "
elif [ $horactual -ge 12 ] && [ $horactual -le 18 ]; then # -le es '<=' (later)
	echo "¡Buenas tardes!"; echo " "
elif [ $horactual -ge 18 ] && [ $horactual -le 22 ]; then
	echo "¡Buenas noches!"; echo " "
else
	echo "¡Es hora de dormir!"; echo " "
fi
