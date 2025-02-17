# For

---

## 🔹 **1. Bucle `for` sobre una lista de valores**
Este es el uso más común, donde `for` recorre una lista de elementos separados por espacios.

```bash
#!/bin/bash

for nombre in Juan Pedro Maria Luis; do
    echo "Hola, $nombre!"
done
```
✔ **Salida:**
```
Hola, Juan!
Hola, Pedro!
Hola, Maria!
Hola, Luis!
```

📌 **Explicación**:
- `nombre` toma el valor de cada elemento en la lista (`Juan`, `Pedro`, `Maria`, `Luis`).
- En cada iteración, se ejecuta el `echo`.

---

## 🔹 **2. `for` con `seq` (rango de números)**
Puedes usar `seq` para generar un rango de números:

```bash
#!/bin/bash

for i in $(seq 1 5); do
    echo "Número: $i"
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

📌 **Explicación**:
- `seq 1 5` genera la secuencia `1 2 3 4 5`, que se usa como lista en el `for`.

---

## 🔹 **3. `for` con un rango de números directo**
En lugar de `seq`, puedes usar `{inicio..fin}`:

```bash
#!/bin/bash

for i in {1..5}; do
    echo "Número: $i"
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

📌 **Diferencia con `seq`**:  
- `{1..5}` usa expansión de llaves (más rápido).
- `seq` es un comando externo (más flexible, permite saltos como `seq 1 2 10` → `1 3 5 7 9`).

---

## 🔹 **4. `for` con un paso diferente**
Puedes definir un **incremento** en `{inicio..fin..paso}`:

```bash
#!/bin/bash

for i in {1..10..2}; do
    echo "Número: $i"
done
```
✔ **Salida:**
```
Número: 1
Número: 3
Número: 5
Número: 7
Número: 9
```

📌 **Explicación**:
- `{1..10..2}` significa *de 1 a 10, aumentando de 2 en 2*.

---

## 🔹 **5. `for` sobre los archivos de un directorio**
Puedes usar `for` para recorrer archivos:

```bash
#!/bin/bash

for archivo in *.txt; do
    echo "Procesando $archivo..."
done
```
✔ **Salida (si hay archivos `.txt` en el directorio):**
```
Procesando notas.txt...
Procesando reporte.txt...
```

📌 **Explicación**:
- `*.txt` selecciona todos los archivos que terminan en `.txt`.
- El `for` los recorre y ejecuta `echo` en cada uno.

---

## 🔹 **6. `for` en una línea (versión corta)**
Puedes escribir el `for` en una sola línea:

```bash
for i in {1..3}; do echo "Hola $i"; done
```
✔ **Salida:**
```
Hola 1
Hola 2
Hola 3
```

---

## 🔹 **7. `for` estilo C (`for (( ))`)**
Puedes escribir un `for` parecido a los de C/C++:

```bash
#!/bin/bash

for ((i=1; i<=5; i++)); do
    echo "Número: $i"
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

📌 **Explicación**:
- `(i=1; i<=5; i++)` define:
  - `i=1` → Inicia en 1.
  - `i<=5` → Se ejecuta mientras `i` sea ≤ 5.
  - `i++` → Aumenta `i` en 1 por cada iteración.

---

## 🔹 **8. `for` con `break` y `continue`**
### **🔸 `break` (romper el bucle)**
Si quieres detener el `for` antes de que termine:

```bash
for i in {1..10}; do
    if [ "$i" -eq 5 ]; then
        echo "Deteniendo en $i"
        break
    fi
    echo "Número: $i"
done
```
✔ **Salida:**
```
Número: 1
Número: 2
Número: 3
Número: 4
Deteniendo en 5
```

📌 **Explicación**:  
- Cuando `i` es `5`, `break` detiene el bucle.

---

### **🔸 `continue` (saltar una iteración)**
Si quieres saltarte un valor y seguir con la siguiente iteración:

```bash
for i in {1..5}; do
    if [ "$i" -eq 3 ]; then
        echo "Saltando $i"
        continue
    fi
    echo "Número: $i"
done
```
✔ **Salida:**
```
Número: 1
Número: 2
Saltando 3
Número: 4
Número: 5
```

📌 **Explicación**:
- Cuando `i=3`, `continue` hace que el `for` pase a la siguiente iteración sin ejecutar `echo "Número: $i"`.

---

## 🚀 **Resumen rápido**
| Tipo de `for` | Ejemplo |
|--------------|---------|
| Lista de valores | `for i in a b c; do ... done` |
| Rango de números (`seq`) | `for i in $(seq 1 5); do ... done` |
| Rango de números (`{}`) | `for i in {1..5}; do ... done` |
| Rango con paso | `for i in {1..10..2}; do ... done` |
| Estilo C | `for ((i=0; i<5; i++)); do ... done` |
| Archivos en un directorio | `for file in *.txt; do ... done` |
| En una línea | `for i in {1..3}; do echo $i; done` |
| `break` (detener) | `if [ "$i" -eq 5 ]; then break; fi` |
| `continue` (saltar) | `if [ "$i" -eq 3 ]; then continue; fi` |

---

## 🎯 **Conclusión**
- `for` es muy útil para recorrer listas, rangos y archivos.
- Puedes usarlo con `{inicio..fin..paso}` o `seq` para números.
- El estilo `for ((...))` es similar a C.
- `break` y `continue` te dan más control en el bucle.
