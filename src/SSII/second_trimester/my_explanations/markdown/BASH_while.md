# While

---

## 🔹 **1. Sintaxis básica de `while`**
```bash
while [ condición ]; do
    # Código a ejecutar
done
```
El bucle se ejecutará **mientras la condición sea verdadera**.

*'Primero pregunta y luego dispara'*.

---

## 🔹 **2. Ejemplo simple con un contador**
```bash
#!/bin/bash

contador=1

while [ "$contador" -le 5 ]; do
    echo "Iteración: $contador"
    contador=$((contador + 1))  # Incrementa el contador
done
```
✔ **Salida:**
```
Iteración: 1
Iteración: 2
Iteración: 3
Iteración: 4
Iteración: 5
```

📌 **Explicación**:
- `contador=1` → Se inicializa la variable.
- `[ "$contador" -le 5 ]` → Mientras `contador` sea menor o igual a `5`, el bucle sigue.
- `contador=$((contador + 1))` → Incrementa `contador` en cada iteración.

---

## 🔹 **3. `while` esperando entrada del usuario**
```bash
#!/bin/bash

opcion=""

while [ "$opcion" != "salir" ]; do
    echo "Escribe algo (o 'salir' para terminar):"
    read opcion
    echo "Ingresaste: $opcion"
done
```
✔ **Ejemplo de ejecución:**
```
Escribe algo (o 'salir' para terminar):
hola
Ingresaste: hola
Escribe algo (o 'salir' para terminar):
adiós
Ingresaste: adiós
Escribe algo (o 'salir' para terminar):
salir
Ingresaste: salir
```

📌 **Explicación**:
- El `while` se ejecuta hasta que el usuario escriba `"salir"`.
- `read opcion` toma la entrada del usuario en cada iteración.

---

## 🔹 **4. `while` con una encuesta (leer valores del usuario y evaluar respuestas)**
```bash
#!/bin/bash

respuesta=""

while true; do # Se repite siempre
    echo "¿Cuál es tu lenguaje de programación favorito?"
    echo "1) Python"
    echo "2) JavaScript"
    echo "3) C++"
    echo "4) Otro"
    echo "5) Salir"
    read -p "Selecciona una opción (1-5): " respuesta

    case $respuesta in
        1) echo "¡Python es genial para ciencia de datos y automatización!" ;;
        2) echo "¡JavaScript domina el desarrollo web!" ;;
        3) echo "¡C++ es potente para sistemas y videojuegos!" ;;
        4) echo "¡Genial! Hay muchos lenguajes interesantes." ;;
        5) echo "Saliendo de la encuesta..."; break ;; # Termina el script
        *) echo "Opción no válida, intenta de nuevo." ;;
    esac # Cierra el `case`

    echo ""  # Espacio para mejorar la legibilidad
done
```
✔ **Ejemplo de salida:**
```
¿Cuál es tu lenguaje de programación favorito?
1) Python
2) JavaScript
3) C++
4) Otro
5) Salir
Selecciona una opción (1-5): 2
¡JavaScript domina el desarrollo web!

¿Cuál es tu lenguaje de programación favorito?
1) Python
2) JavaScript
3) C++
4) Otro
5) Salir
Selecciona una opción (1-5): 5
Saliendo de la encuesta...
```

📌 **Explicación**:
- Se usa un `while true` para repetir la encuesta hasta que el usuario elija salir (`5`).
- `read -p` muestra un mensaje antes de capturar la entrada.
- `case` evalúa la opción ingresada y da una respuesta.
- `break` detiene el bucle si el usuario elige `5`.

---

## 🔹 **5. `while` leyendo línea por línea de un archivo**
```bash
#!/bin/bash

while IFS= read -r linea; do
    echo "Línea leída: $linea"
done < archivo.txt
```
✔ **Ejemplo de salida (si `archivo.txt` tiene esto):**
```
Hola mundo
Esto es Bash
```
Salida:
```
Línea leída: Hola mundo
Línea leída: Esto es Bash
```

📌 **Explicación**:
- `IFS=` evita que Bash elimine espacios al principio o final de la línea.
- `read -r` evita que `\` (backslash) sea tratado como un carácter especial.
- `< archivo.txt` redirige la entrada para leer el archivo.

---

## 🔹 **6. `while` infinito (hasta que se detenga)**
Un bucle infinito es útil para procesos que deben ejecutarse continuamente.

```bash
#!/bin/bash

while true; do
    echo "Presiona Ctrl + C para detenerme..."
    sleep 2  # Espera 2 segundos entre cada iteración
done
```
✔ **Salida (se repetirá hasta que lo detengas con `Ctrl + C`):**
```
Presiona Ctrl + C para detenerme...
Presiona Ctrl + C para detenerme...
Presiona Ctrl + C para detenerme...
```

📌 **Explicación**:
- `while true` hace que el bucle nunca termine.
- `sleep 2` espera 2 segundos antes de la siguiente iteración.

---

## 🔹 **7. `while` con `break` (para salir del bucle)**
```bash
#!/bin/bash

contador=1

while [ "$contador" -le 10 ]; do
    echo "Número: $contador"

    if [ "$contador" -eq 5 ]; then
        echo "Deteniendo en 5"
        break  # Sale del bucle
    fi

    contador=$((contador + 1))
done
```
✔ **Salida:**
```
Número: 1
Número: 2
Número: 3
Número: 4
Número: 5
Deteniendo en 5
```

📌 **Explicación**:
- Cuando `contador` llega a 5, `break` detiene el bucle.

---

## 🔹 **8. `while` con `continue` (para saltar una iteración)**
```bash
#!/bin/bash

contador=0

while [ "$contador" -lt 5 ]; do
    contador=$((contador + 1))

    if [ "$contador" -eq 3 ]; then
        echo "Saltando el número 3"
        continue  # Salta esta iteración y sigue con la siguiente
    fi

    echo "Número: $contador"
done
```
✔ **Salida:**
```
Número: 1
Número: 2
Saltando el número 3
Número: 4
Número: 5
```

📌 **Explicación**:
- Cuando `contador = 3`, `continue` hace que `echo "Número: $contador"` no se ejecute en esa iteración.

---

## 🔹 **9. `while` con `until` (inverso de `while`)**
Mientras `while` **se ejecuta mientras la condición sea verdadera**, `until` **se ejecuta mientras la condición sea falsa**.

```bash
#!/bin/bash

contador=1

until [ "$contador" -gt 5 ]; do
    echo "Número: $contador"
    contador=$((contador + 1))
done
```
✔ **Salida:**
```
Número: 1
Número: 2
Número: 3
Número: 4
Número: 5
```

📌 **Diferencia clave**:
- `while [ condición ]` → Se ejecuta mientras la condición **sea verdadera**.
- `until [ condición ]` → Se ejecuta mientras la condición **sea falsa**.

---

## 🚀 **Resumen rápido**
| Tipo de `while` | Ejemplo |
|--------------|---------|
| Bucle con contador | `while [ "$i" -le 5 ]; do ... done` |
| Esperando entrada del usuario | `while [ "$var" != "salir" ]; do read var; done` |
| Encuesta interactiva | `while true; do read -p "Pregunta:" res; case $res in ... esac; done` |
| Leyendo un archivo línea por línea | `while read linea; do echo $linea; done < archivo.txt` |
| Bucle infinito | `while true; do ... done` |
| `while` con `break` | `if [ "$i" -eq 5 ]; then break; fi` |
| `while` con `continue` | `if [ "$i" -eq 3 ]; then continue; fi` |
| `until` (versión inversa de `while`) | `until [ "$i" -gt 5 ]; do ... done` |

---

## 🎯 **Conclusión**
- `while` se ejecuta **mientras la condición sea verdadera**.
- Se usa para **bucles indefinidos**, leer archivos, esperar entrada, encuestas, etc.
- `break` detiene el bucle, `continue` salta una iteración.
- `until` es lo opuesto a `while` (se ejecuta hasta que la condición sea verdadera).
