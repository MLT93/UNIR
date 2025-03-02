# If-Elif-Else-fi

---

## 🔹 **1. Sintaxis básica de `if`**

La estructura básica de una declaración `if` en Bash es la siguiente:

```bash
if [ condición ]; then
    # Código a ejecutar si la condición es verdadera
fi
```

- **`[ condición ]`**: Evaluación de la condición (dentro de los corchetes).
- **`then`**: Se ejecuta si la condición es verdadera.
- **`fi`**: Finaliza el bloque `if`.

---

## 🔹 **2. Ejemplo básico de `if`**

```bash
#!/bin/bash

numero=10

if [ $numero -gt 5 ]; then
    echo "El número es mayor que 5"
fi
```

✔ **Salida:**
```
El número es mayor que 5
```

📌 **Explicación**:
- Si la variable `$numero` es mayor que 5, se imprime el mensaje "El número es mayor que 5".
- En este caso, como 10 es mayor que 5, la condición se cumple.

---

## 🔹 **3. `if-else` (Condición falsa)**

La estructura `if-else` permite ejecutar una alternativa cuando la condición no se cumple.

```bash
#!/bin/bash

numero=3

if [ $numero -gt 5 ]; then
    echo "El número es mayor que 5"
else
    echo "El número es menor o igual a 5"
fi
```

✔ **Salida:**
```
El número es menor o igual a 5
```

📌 **Explicación**:
- Si la condición `[ $numero -gt 5 ]` no se cumple, el bloque `else` se ejecuta.
- En este caso, como 3 no es mayor que 5, se imprime "El número es menor o igual a 5".

---

## 🔹 **4. `if-elif-else` (Varias condiciones)**

El bloque `if-elif-else` te permite manejar múltiples condiciones alternativas.

```bash
#!/bin/bash

numero=7

if [ $numero -gt 10 ]; then
    echo "El número es mayor que 10"
elif [ $numero -eq 7 ]; then
    echo "El número es 7"
else
    echo "El número es menor que 7"
fi
```

✔ **Salida:**
```
El número es 7
```

📌 **Explicación**:
- La condición `if [ $numero -gt 10 ]` no se cumple.
- Luego, la condición `elif [ $numero -eq 7 ]` se cumple, por lo que se ejecuta su bloque.
- Si ninguna de las condiciones anteriores se cumple, se ejecutaría el bloque `else`.

---

## 🔹 **5. `if` con operadores lógicos (AND, OR)**

Puedes combinar condiciones usando operadores lógicos como `-a` (AND) y `-o` (OR).

### **Ejemplo con `AND` (`-a`)**

```bash
#!/bin/bash

numero=8
cadena="Hola"

if [ $numero -gt 5 ] && [ "$cadena" == "Hola" ]; then
    echo "Ambas condiciones son verdaderas"
fi
```

✔ **Salida:**
```
Ambas condiciones son verdaderas
```

📌 **Explicación**:
- Ambas condiciones deben ser verdaderas para que el bloque `then` se ejecute. La condición `numero -gt 5` y `cadena == "Hola"` son verdaderas, por lo que se imprime el mensaje.

### **Ejemplo con `OR` (`-o`)**

```bash
#!/bin/bash

numero=4
cadena="Adiós"

if [ $numero -gt 5 ] || [ "$cadena" == "Adiós" ]; then
    echo "Al menos una de las condiciones es verdadera"
fi
```

✔ **Salida:**
```
Al menos una de las condiciones es verdadera
```

📌 **Explicación**:
- En este caso, al usar el operador `OR` (`||` o `-o`), basta con que una de las condiciones sea verdadera para que el bloque `then` se ejecute. Como `cadena == "Adiós"` es verdadera, se imprime el mensaje.

---

## 🔹 **6. `if` con comparación de cadenas**

Puedes comparar cadenas dentro de un `if` usando operadores como `==` o `!=`.

```bash
#!/bin/bash

fruta="manzana"

if [ "$fruta" == "manzana" ]; then
    echo "La fruta es una manzana"
else
    echo "La fruta no es una manzana"
fi
```

✔ **Salida:**
```
La fruta es una manzana
```

📌 **Explicación**:
- La condición `"$fruta" == "manzana"` se cumple, por lo que se imprime "La fruta es una manzana".
- Recuerda siempre usar comillas alrededor de las variables cuando se comparan cadenas, para evitar errores si la variable está vacía.

---

## 🔹 **7. `if` con comparación de números**

En Bash, puedes usar operadores específicos para comparar números, como `-eq`, `-lt`, `-le`, `-gt`, `-ge`, y `-ne`.

```bash
#!/bin/bash

numero1=5
numero2=10

if [ $numero1 -lt $numero2 ]; then
    echo "$numero1 es menor que $numero2"
fi
```

✔ **Salida:**
```
5 es menor que 10
```

📌 **Explicación**:
- La condición `[ $numero1 -lt $numero2 ]` evalúa si `$numero1` es menor que `$numero2`.
- Como `5` es menor que `10`, la condición se cumple y se imprime el mensaje.

---

## 🔹 **8. `if` anidado (Nested `if`)**

Es posible anidar `if` dentro de otros `if`, creando estructuras más complejas.

```bash
#!/bin/bash

edad=25
ciudad="Madrid"

if [ $edad -ge 18 ]; then
    echo "Eres mayor de edad"
    if [ "$ciudad" == "Madrid" ]; then
        echo "Vives en Madrid"
    else
        echo "No vives en Madrid"
    fi
else
    echo "Eres menor de edad"
fi
```

✔ **Salida:**
```
Eres mayor de edad
Vives en Madrid
```

📌 **Explicación**:
- Primero se evalúa si la persona es mayor de edad. Si la condición es verdadera, se evalúa si vive en Madrid con un `if` anidado.
- En este caso, ambas condiciones se cumplen.

---

## 🔹 **9. `if` con `!` (Negación)**

El operador `!` se usa para negar una condición.

```bash
#!/bin/bash

archivo="/ruta/al/archivo.txt"

if [ ! -e "$archivo" ]; then
    echo "El archivo no existe"
fi
```

✔ **Salida:**
```
El archivo no existe
```

📌 **Explicación**:
- El operador `!` niega la condición. En este caso, si el archivo no existe, se ejecuta el bloque `then`.
- `-e` verifica si el archivo existe. Si no existe, la condición se evalúa como verdadera y el mensaje se imprime.

---

## 🚀 **Resumen rápido**

| Acción | Ejemplo |
|--------|---------|
| **`if` básico** | `if [ $numero -gt 5 ]; then echo "Mayor que 5"; fi` |
| **`if-else`** | `if [ $numero -gt 5 ]; then echo "Mayor"; else echo "Menor"; fi` |
| **`if-elif-else`** | `if [ $numero -gt 10 ]; then ... elif [ $numero -eq 7 ]; then ... else ... fi` |
| **`AND` (`-a`)** | `if [ $numero -gt 5 ] && [ $cadena == "Hola" ]; then ... fi` |
| **`OR` (`-o`)** | `if [ $numero -gt 5 ] || [ $cadena == "Adiós" ]; then ... fi` |
| **Comparación de cadenas** | `if [ "$fruta" == "manzana" ]; then ... fi` |
| **Comparación de números** | `if [ $numero1 -lt $numero2 ]; then ... fi` |
| **`if` anidado** | `if [ $edad -ge 18 ]; then if [ $ciudad == "Madrid" ]; then ... fi; fi` |
| **Negación (`!`)** | `if [ ! -e "$archivo" ]; then ... fi` |

---

## 🎯 **Conclusión**
- **`if`** en Bash es fundamental para tomar decisiones basadas en condiciones.
- Puedes usar `else`, `elif`, y combinaciones con operadores lógicos como `-a` (AND) y `-o` (OR).
- Las comparaciones se hacen usando operadores específicos para cadenas y números.
- **`if` anidados** y la negación con `!` te permiten crear lógica más compleja y precisa en tus scripts.

