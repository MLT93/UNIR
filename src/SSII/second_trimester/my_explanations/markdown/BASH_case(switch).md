# Switch 

---

## 🔹 **1. Sintaxis de `case` en Bash**
```bash
case $variable in
    opción1)
        # Código si $variable es opción1
        ;;
    opción2)
        # Código si $variable es opción2
        ;;
    opción3 | opción4)
        # Código si $variable es opción3 o opción4
        ;;
    *)
        # Código si no coincide con ninguna opción (default)
        ;;
esac
```
📌 **Detalles importantes**:
- `case $variable in` → Indica la variable a evaluar.
- Cada opción termina con `)` y el código que se ejecuta va debajo.
- `;;` → Es obligatorio para separar cada opción.
- `*)` → Representa el **caso por defecto** (como `default` en otros lenguajes).
- `esac` → Finaliza la estructura.

---

## 🔹 **2. Ejemplo básico de `case`**
```bash
#!/bin/bash

echo "¿Cuál es tu color favorito? (rojo, azul, verde)"
read color

case $color in
    rojo)
        echo "El rojo simboliza pasión y energía."
        ;;
    azul)
        echo "El azul transmite calma y confianza."
        ;;
    verde)
        echo "El verde representa la naturaleza y frescura."
        ;;
    *)
        echo "Color no reconocido."
        ;;
esac
```
✔ **Ejemplo de ejecución:**
```
¿Cuál es tu color favorito? (rojo, azul, verde)
rojo
El rojo simboliza pasión y energía.
```

📌 **Explicación**:
- Se usa `read` para pedir un valor al usuario.
- `case` compara el valor ingresado con `rojo`, `azul` y `verde`.
- Si no coincide con ninguna opción, entra en `*)` (caso por defecto).

---

## 🔹 **3. `case` con múltiples opciones para un mismo caso**
Podemos usar **`|`** (pipe) para agrupar varias opciones en un solo bloque.

```bash
#!/bin/bash

echo "Selecciona un día (lunes - viernes):"
read dia

case $dia in
    lunes | martes | miércoles)
        echo "Inicio de la semana."
        ;;
    jueves | viernes)
        echo "Fin de la semana."
        ;;
    *)
        echo "Día inválido."
        ;;
esac
```
✔ **Ejemplo de ejecución:**
```
Selecciona un día (lunes - viernes):
martes
Inicio de la semana.
```

📌 **Explicación**:
- `lunes | martes | miércoles)` → Cualquier opción en este grupo ejecutará el mismo código.
- `jueves | viernes)` → Otro grupo con otro mensaje.

---

## 🔹 **4. `case` con valores numéricos**
```bash
#!/bin/bash

echo "Ingresa un número del 1 al 3:"
read num

case $num in
    1)
        echo "Elegiste uno."
        ;;
    2)
        echo "Elegiste dos."
        ;;
    3)
        echo "Elegiste tres."
        ;;
    *)
        echo "Número fuera de rango."
        ;;
esac
```
✔ **Ejemplo de ejecución:**
```
Ingresa un número del 1 al 3:
2
Elegiste dos.
```

📌 **Nota**:  
Los números se tratan como texto en Bash, por lo que `case` compara **cadenas de caracteres**, no valores numéricos como en otros lenguajes.

---

## 🔹 **5. `case` con rangos de números (`[[ ]]` y `if` anidado)**
Bash no admite rangos directamente en `case`, pero podemos combinarlos con `if`.

```bash
#!/bin/bash

echo "Ingresa tu edad:"
read edad

case $edad in
    [0-9] | 1[0-7]) # De 0 a 17 años
        echo "Eres menor de edad."
        ;;
    1[8-9] | [2-5][0-9]) # De 18 a 59 años
        echo "Eres un adulto."
        ;;
    [6-9][0-9] | 100) # De 60 a 100 años
        echo "Eres un adulto mayor."
        ;;
    *)
        echo "Edad fuera de rango."
        ;;
esac
```
✔ **Ejemplo de ejecución:**
```
Ingresa tu edad:
25
Eres un adulto.
```

📌 **Explicación**:
- `[0-9]` → Cualquier dígito de 0 a 9.
- `1[0-7]` → Números del 10 al 17.
- `[6-9][0-9]` → Números del 60 al 99.
- `100` → Se incluye específicamente.
- Si la entrada no coincide con ninguna, entra en `*)`.

---

## 🔹 **6. `case` con `while` (Menú interactivo)**
```bash
#!/bin/bash

while true; do
    echo "Menú:"
    echo "1) Ver fecha y hora"
    echo "2) Mostrar archivos en el directorio"
    echo "3) Mostrar usuarios conectados"
    echo "4) Salir"
    read -p "Elige una opción: " opcion

    case $opcion in
        1) date ;;
        2) ls ;;
        3) who ;;
        4) echo "Saliendo..."; break ;;
        *) echo "Opción no válida, intenta de nuevo." ;;
    esac

    echo ""  # Espacio entre iteraciones
done
```
✔ **Ejemplo de ejecución:**
```
Menú:
1) Ver fecha y hora
2) Mostrar archivos en el directorio
3) Mostrar usuarios conectados
4) Salir
Elige una opción: 1
lun feb 19 10:15:23 UTC 2025
```

📌 **Explicación**:
- Se usa `while true` para repetir el menú hasta que el usuario elija `4`.
- `date`, `ls`, y `who` son comandos de Linux que ejecutan acciones.
- `break` detiene el `while` cuando se elige `4`.

---

## 🚀 **Resumen rápido**
| **Función** | **Ejemplo** |
|------------|------------|
| Evaluar valores de texto | `case $var in "hola") echo "Saludo" ;; esac` |
| Agrupar varias opciones | `case $var in "a" | "b") echo "Letra válida" ;; esac` |
| Comparar números como texto | `case $num in 1) echo "Uno" ;; 2) echo "Dos" ;; esac` |
| Usar rangos numéricos | `case $edad in [0-9]) echo "Niño" ;; 1[0-7]) echo "Adolescente" ;; esac` |
| Crear un menú interactivo | `while true; do case $opcion in 1) date ;; 4) break ;; esac; done` |

---

## 🎯 **Conclusión**
- `case` es el equivalente de `switch` en Bash.
- Se usa para **evaluar una variable con múltiples opciones sin usar `if-elif-else`**.
- Separa las opciones con `)` y finaliza cada una con `;;`.
- Se puede combinar con `while` para hacer **menús interactivos**.
