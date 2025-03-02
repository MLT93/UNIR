# DO-WHILE

---

## 🔹 **1. Sintaxis básica de `do-while`**
```bash
do
    # Código a ejecutar
while [ condición ]
```
El bucle se ejecutará **siempre al menos una vez**, y luego continuará ejecutándose mientras la condición sea **verdadera**.

*'Primero dispara y luego pregunta'*.

Crea menús recursivos junto a un **switch**.

---

## 🔹 **2. Ejemplo simple con un contador**
```bash
#!/bin/bash

contador=1

do
    echo "Iteración: $contador"
    contador=$((contador + 1))  # Incrementa el contador
while [ "$contador" -le 5 ]
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
- El código dentro del `do` siempre se ejecutará al menos una vez, incluso si la condición no se cumple al principio.

---

## 🔹 **3. `do-while` esperando entrada del usuario**
```bash
#!/bin/bash

opcion=""

do
    echo "Escribe algo (o 'salir' para terminar):"
    read opcion
    echo "Ingresaste: $opcion"
while [ "$opcion" != "salir" ]
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
- El `do-while` asegura que el bloque de código se ejecute **al menos una vez** antes de verificar la condición.
- `read opcion` captura la entrada del usuario en cada iteración.

---

## 🔹 **4. `do-while` con una encuesta (leer valores del usuario y evaluar respuestas)**
```bash
#!/bin/bash

respuesta=""

do
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
    esac

    echo ""  # Espacio para mejorar la legibilidad
while [ "$respuesta" != "5" ]  # Continuar hasta que se seleccione '5' para salir
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
- Se usa un `do-while` para garantizar que la encuesta se ejecute al menos una vez.
- El `case` evalúa la opción ingresada y muestra la respuesta correspondiente.
- El bucle continuará hasta que el usuario elija `5` para salir.

---

## 🔹 **5. `do-while` leyendo línea por línea de un archivo**
```bash
#!/bin/bash

do
    read -r linea
    echo "Línea leída: $linea"
while IFS= read -r linea <&3
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
- `<&3` redirige la entrada de un archivo abierto previamente, en este caso, el archivo `archivo.txt`.

---

## 🔹 **6. `do-while` infinito (hasta que se detenga)**
Un bucle infinito es útil para procesos que deben ejecutarse continuamente.

```bash
#!/bin/bash

do
    echo "Presiona Ctrl + C para detenerme..."
    sleep 2  # Espera 2 segundos entre cada iteración
while true
```
✔ **Salida (se repetirá hasta que lo detengas con `Ctrl + C`):**
```
Presiona Ctrl + C para detenerme...
Presiona Ctrl + C para detenerme...
Presiona Ctrl + C para detenerme...
```

📌 **Explicación**:
- `do` ejecuta el bloque de código al menos una vez antes de verificar la condición `true`.
- El bucle nunca termina porque la condición es siempre verdadera.
- `sleep 2` espera 2 segundos antes de la siguiente iteración.

---

## 🔹 **7. `do-while` con `break` (para salir del bucle)**
```bash
#!/bin/bash

contador=1

do
    echo "Número: $contador"

    if [ "$contador" -eq 5 ]; then
        echo "Deteniendo en 5"
        break  # Sale del bucle
    fi

    contador=$((contador + 1))
while [ "$contador" -le 10 ]
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
- El bucle `do-while` continúa hasta que `contador` llegue a `5`.
- Cuando esto ocurre, el `break` termina el bucle.

---

## 🔹 **8. `do-while` con `continue` (para saltar una iteración)**
```bash
#!/bin/bash

contador=0

do
    contador=$((contador + 1))

    if [ "$contador" -eq 3 ]; then
        echo "Saltando el número 3"
        continue  # Salta esta iteración y sigue con la siguiente
    fi

    echo "Número: $contador"
while [ "$contador" -lt 5 ]
```
✔ **Salida:**
```
Número: 1
Número: 2
Saltando el número 3
Número: 4
```

📌 **Explicación**:
- Cuando `contador = 3`, `continue` hace que la iteración actual se salte y se continúe con la siguiente, sin ejecutar el `echo "Número: $contador"` en esa iteración.

---

## 🔹 **9. `do-while` con `until` (inverso de `do-while`)**
Mientras `do-while` **se ejecuta al menos una vez** y luego verifica la condición, `until` **se ejecuta al menos una vez** y repite mientras la condición sea **falsa**.

```bash
#!/bin/bash

contador=1

do
    echo "Número: $contador"
    contador=$((contador + 1))
while [ "$contador" -le 5 ]
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
- `do-while [ condición ]` → Se ejecuta al menos una vez y **luego** evalúa la condición.
- `until [ condición ]` → Se ejecuta al menos una vez y **luego** evalúa la condición, continuando mientras sea **falsa**.

---

## 🔹 **10. Menú recursivo con `do-while` y `switch`**

En este ejemplo, vamos a crear un menú recursivo que utiliza `do-while` para repetirse hasta que el usuario elija una opción para salir. Además, emplearemos un `case` (similar a un `switch` en otros lenguajes) para manejar las opciones seleccionadas.

```bash
#!/bin/bash

# Función para mostrar el menú
mostrar_menu() {
    echo "Menú interactivo:"
    echo "1) Ver la fecha y hora actual"
    echo "2) Listar archivos en el directorio"
    echo "3) Salir"
    read -p "Selecciona una opción (1-3): " opcion
}

# Bucle recursivo con do-while y switch (case)
do
    mostrar_menu  # Muestra el menú al usuario

    case $opcion in
        1) 
            echo "Fecha y hora actual: $(date)"
            ;;
        2)
            echo "Lista de archivos en el directorio actual:"
            ls
            ;;
        3)
            echo "Saliendo del programa..."
            break  # Sale del bucle y termina el script
            ;;
        *)
            echo "Opción no válida, por favor intenta de nuevo."
            ;;
    esac
    echo ""  # Espacio entre iteraciones para mayor legibilidad
while [ "$opcion" != "3" ]  # Repite el bucle hasta que el usuario elija '3' para salir
```

- **Función `mostrar_menu()`**: Esta función imprime el menú de opciones y solicita al usuario que ingrese una opción.
  
- **Bucle `do-while`**: El bucle se ejecuta **siempre al menos una vez** y repite hasta que el usuario elija la opción "3" (salir). Dentro del bucle, se ejecuta la función `mostrar_menu` para mostrar el menú nuevamente.

- **Switch con `case`**: Usamos `case` (que actúa como un `switch` en otros lenguajes) para manejar las diferentes opciones:
  - Opción 1: Muestra la fecha y hora actual con el comando `date`.
  - Opción 2: Lista los archivos en el directorio actual usando `ls`.
  - Opción 3: Sale del programa utilizando `break` para salir del bucle.

- **Opción no válida**: Si el usuario ingresa una opción no válida, el mensaje "Opción no válida" se imprime y el menú se muestra nuevamente.

- **Ejemplo de ejecución**:

```
Menú interactivo:
1) Ver la fecha y hora actual
2) Listar archivos en el directorio
3) Salir
Selecciona una opción (1-3): 1
Fecha y hora actual: Sun Mar  2 14:30:22 PST 2025

Menú interactivo:
1) Ver la fecha y hora actual
2) Listar archivos en el directorio
3) Salir
Selecciona una opción (1-3): 2
Lista de archivos en el directorio actual:
archivo1.txt  archivo2.sh  directorio1/

Menú interactivo:
1) Ver la fecha y hora actual
2) Listar archivos en el directorio
3) Salir
Selecciona una opción (1-3): 3
Saliendo del programa...
```

1. **Recursividad con `do-while`**: La recursividad se logra mediante el ciclo `do-while`, donde el menú se muestra al menos una vez y se repite si el usuario no ha seleccionado la opción para salir.
2. **Salida con `break`**: El uso de `break` permite salir del bucle cuando el usuario elige la opción "3".
3. **Switch (`case`)**: El `case` es útil para manejar múltiples opciones de manera estructurada, similar a un `switch` en otros lenguajes.

---

## 🚀 **Resumen rápido**
| Tipo de `do-while` | Ejemplo |
|--------------|---------|
| Bucle con contador | `do echo $contador; done while [ "$contador" -le 5 ]` |
| Esperando entrada del usuario | `do read opcion; done while [ "$opcion" != "salir" ]` |
| Encuesta interactiva | `do read -p "Pregunta:" res; done while [ "$res" != "5" ]` |
| Leyendo un archivo línea por línea | `do read linea; done while IFS= read -r linea` |
| Bucle infinito | `do ... done while true` |
| `do-while` con `break` | `if [ "$i" -eq 5 ]; then break; fi` |
| `do-while` con `continue` | `if [ "$i" -eq 3 ]; then continue; fi` |
|

 `until` (versión inversa de `do-while`) | `do ... done while [ "$i" -gt 5 ]` |

---

## 🎯 **Conclusión**
- `do-while` se ejecuta **al menos una vez** antes de verificar la condición.
- Se usa para **bucles que necesitan ejecutarse por lo menos una vez**.
- `break` detiene el bucle, `continue` salta una iteración.
- `until` es lo opuesto a `do-while` (se ejecuta hasta que la condición sea **verdadera**).
