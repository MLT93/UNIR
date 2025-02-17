# Parámetros posicionales (los que necesitan argumentos)

---

## 🔹 **Ejemplo de `$1`, `$2`, etc. en un script**  
Si tienes un script llamado `saludo.sh`:

```bash
#!/bin/bash

echo "Hola, $1! Bienvenido."
```
Si lo ejecutas en la terminal con un argumento:

```bash
bash saludo.sh Juan
```
✔ Esto imprimirá:  
```
Hola, Juan! Bienvenido.
```

---

## 🔹 **Ejemplo con múltiples parámetros**
```bash
#!/bin/bash

echo "Hola, $1!"
echo "Tu apellido es $2."
echo "Tienes $3 años."
```
Si ejecutas:

```bash
bash script.sh Pedro Gómez 25
```
✔ La salida será:
```
Hola, Pedro!
Tu apellido es Gómez.
Tienes 25 años.
```

---

## 🔹 **Lista de parámetros especiales en Bash**
| Parámetro | Descripción |
|-----------|------------|
| `$0` | Nombre del script |
| `$1, $2, $3, ...` | Argumentos pasados al script |
| `$#` | Número total de argumentos |
| `$@` | Todos los argumentos como una lista (cada uno independiente) |
| `"$*"` | Todos los argumentos como una sola cadena |
| `"$@"` | Igual a `$@`, pero preservando los argumentos entre comillas |
| `$$` | PID del script |
| `$?` | Código de salida del último comando ejecutado |
| `"$!"` | PID del último proceso ejecutado en segundo plano |

---

## 🔹 **Ejemplo con `$#` y `$@`**
```bash
#!/bin/bash

echo "Has ingresado $# argumentos:"
echo "Lista de argumentos: $@"
```
Si ejecutas:

```bash
bash script.sh uno dos tres
```
✔ La salida será:
```
Has ingresado 3 argumentos:
Lista de argumentos: uno dos tres
```

---

## 🔥 **Ejemplo de validación de argumentos**
Si quieres asegurarte de que el usuario ingrese al menos un argumento:

```bash
#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Error: No ingresaste argumentos."
    echo "Uso: bash script.sh <nombre>"
    exit 1  # Termina el script con código de error
fi

echo "Hola, $1!"
```
Si intentas ejecutarlo sin argumentos:

```bash
bash script.sh
```
✔ Esto imprimirá:
```
Error: No ingresaste argumentos.
Uso: bash script.sh <nombre>
```

---

## 🔥 **Diferencia entre `$@` y `"$@"`**
```bash
#!/bin/bash
echo "Con \$@: $@"
echo "Con \"\$@\": \"$@\""
```
Si ejecutas:

```bash
bash script.sh hola "mundo cruel"
```
✔ La salida será:
```
Con $@: hola mundo cruel
Con "$@": "hola" "mundo cruel"
```
📌 **Explicación**:
- `$@` separa los argumentos por espacios.
- `"$@"` mantiene los argumentos con comillas.

---

## 🚀 **Conclusión**
- `$1`, `$2`, `$3`, ... → Son argumentos pasados al script.
- `$#` → Número de argumentos.
- `$@` → Lista de argumentos (sin preservar comillas).
- `"$@"` → Lista de argumentos (preservando comillas).

Ahora ya sabes cómo recibir datos desde la terminal en un script de Bash. ¿Tienes más dudas? 😃
