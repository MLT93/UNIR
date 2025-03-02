# Funciones

---

## 🔹 **1. Sintaxis básica de una función en Bash**

En Bash, las funciones se definen con la siguiente sintaxis:

```bash
nombre_funcion() {
    # Cuerpo de la función
    # Código a ejecutar
}
```

Una vez definida, puedes llamar a la función por su nombre en cualquier parte del script.

---

## 🔹 **2. Ejemplo básico de función**

```bash
#!/bin/bash

# Definición de la función
saludar() {
    echo "¡Hola, $1!"
}

# Llamada a la función
saludar "Mundo"
```

✔ **Salida:**
```
¡Hola, Mundo!
```

📌 **Explicación**:
- `saludar` es una función que imprime un saludo. 
- `$1` es un parámetro pasado a la función. En este caso, "Mundo" es el argumento que le damos al llamarla.
- `saludar "Mundo"` llama a la función y pasa el valor "Mundo".

---

## 🔹 **3. Funciones con múltiples parámetros**

Puedes pasar más de un parámetro a una función. Los parámetros se acceden dentro de la función como `$1`, `$2`, `$3`, etc.

```bash
#!/bin/bash

# Definición de la función con dos parámetros
sumar() {
    suma=$(( $1 + $2 ))
    echo "La suma de $1 y $2 es: $suma"
}

# Llamada a la función con dos parámetros
sumar 5 8
```

✔ **Salida:**
```
La suma de 5 y 8 es: 13
```

📌 **Explicación**:
- La función `sumar` toma dos parámetros, los suma y luego muestra el resultado.
- Los parámetros `$1` y `$2` son los valores pasados a la función (5 y 8 en este caso).

---

## 🔹 **4. Función con valor de retorno**

En Bash, las funciones no pueden devolver valores directamente como en otros lenguajes, pero puedes usar `echo` para imprimir el valor o establecer un código de salida con `return`.

### **Usando `echo` para devolver un valor**

```bash
#!/bin/bash

# Definición de la función
multiplicar() {
    echo $(( $1 * $2 ))
}

# Llamada a la función y captura de su salida
resultado=$(multiplicar 3 4)
echo "El resultado de la multiplicación es: $resultado"
```

✔ **Salida:**
```
El resultado de la multiplicación es: 12
```

📌 **Explicación**:
- La función `multiplicar` toma dos parámetros, los multiplica y devuelve el resultado usando `echo`.
- La salida de la función se captura en la variable `resultado` con `$(...)`.

---

## 🔹 **5. Función con `return`**

En Bash, puedes usar `return` para indicar el **código de salida** de la función, que generalmente es un valor numérico.

```bash
#!/bin/bash

# Definición de la función
verificar_par() {
    if [ $(( $1 % 2 )) -eq 0 ]; then
        return 0  # Es par
    else
        return 1  # Es impar
    fi
}

# Llamada a la función
verificar_par 6
if [ $? -eq 0 ]; then
    echo "El número es par"
else
    echo "El número es impar"
fi
```

✔ **Salida:**
```
El número es par
```

📌 **Explicación**:
- La función `verificar_par` recibe un número y devuelve `0` si es par o `1` si es impar.
- `$?` obtiene el código de salida de la última función ejecutada (0 significa éxito, 1 significa fallo en este contexto).

---

## 🔹 **6. Funciones con valores predeterminados**

Es posible establecer valores predeterminados para los parámetros de una función, de modo que si no se pasa un valor, se use el predeterminado.

```bash
#!/bin/bash

# Definición de la función con valor predeterminado
greet() {
    name=${1:-"Amigo"}  # Si no se pasa un parámetro, usar "Amigo"
    echo "¡Hola, $name!"
}

# Llamada a la función con y sin parámetro
greet "Carlos"
greet
```

✔ **Salida:**
```
¡Hola, Carlos!
¡Hola, Amigo!
```

📌 **Explicación**:
- La variable `name` toma el valor del primer parámetro (`$1`), pero si no se pasa ningún parámetro, se usa `"Amigo"` como valor predeterminado.

---

## 🔹 **7. Funciones recursivas**

Una función puede llamarse a sí misma. Esto es útil en algunos algoritmos como los de **búsqueda** o **cálculo de factoriales**.

### **Ejemplo: Cálculo del factorial**

```bash
#!/bin/bash

# Función recursiva para calcular el factorial
factorial() {
    if [ $1 -le 1 ]; then
        echo 1
    else
        prev=$(factorial $(( $1 - 1 )))
        echo $(( $1 * prev ))
    fi
}

# Llamada a la función
resultado=$(factorial 5)
echo "El factorial de 5 es: $resultado"
```

✔ **Salida:**
```
El factorial de 5 es: 120
```

📌 **Explicación**:
- La función `factorial` se llama a sí misma con el valor `$1 - 1`, lo que permite calcular el factorial de manera recursiva.
- El valor de salida se va acumulando en cada llamada recursiva hasta que alcanza el caso base (`$1 -le 1`).

---

## 🔹 **8. Funciones con `local`**

Para evitar que las variables definidas dentro de una función afecten a otras partes del script, se puede utilizar `local` para declarar variables locales.

```bash
#!/bin/bash

# Función con variable local
incrementar() {
    local contador=$1
    contador=$((contador + 1))
    echo "Contador dentro de la función: $contador"
}

# Llamada a la función
incrementar 5
# Verificamos el valor fuera de la función
echo "Contador fuera de la función: $contador"
```

✔ **Salida:**
```
Contador dentro de la función: 6
Contador fuera de la función: (vacío)
```

📌 **Explicación**:
- La variable `contador` es local dentro de la función `incrementar` y no afecta a la variable global `contador`.
- Esto es útil para evitar que las variables dentro de funciones interfieran con las variables globales.

---

## 🚀 **Resumen rápido**

| Acción | Ejemplo |
|--------|---------|
| **Definición básica de una función** | `mi_funcion() { echo "Hola"; }` |
| **Función con parámetros** | `sumar() { echo $(($1 + $2)); }` |
| **Función con valor de retorno** | `multiplicar() { echo $(($1 * $2)); }` |
| **Uso de `return`** | `verificar_par() { return 0; }` |
| **Funciones recursivas** | `factorial() { if [ $1 -le 1 ]; then echo 1; else echo $(($1 * $(factorial $(( $1 - 1 ))))); fi }` |
| **Variables locales** | `mi_funcion() { local var=10; }` |

---

## 🎯 **Conclusión**
- Las funciones en Bash son muy útiles para modularizar código y hacer scripts más reutilizables.
- Pueden tomar parámetros, devolver valores usando `echo` o `return`, y contener lógica recursiva.
- También es posible manejar variables locales con `local` para evitar efectos secundarios no deseados en otras partes del script.
