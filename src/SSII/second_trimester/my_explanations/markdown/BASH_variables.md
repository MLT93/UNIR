# Variables

---

## 🔹 **Declaración de operandos en Bash**
### **1️⃣ Usando variables**
Las variables en Bash se declaran sin espacios alrededor del `=`:

```bash
num1=10
num2=20

if [ "$num1" -lt "$num2" ]; then
    echo "$num1 es menor que $num2"
fi
```
✔ Esto imprimirá: `10 es menor que 20`

📌 **Nota**: Siempre es recomendable usar `"$variable"` (con comillas dobles) para evitar problemas si la variable está vacía.

---

### **2️⃣ Usando valores literales directamente**
Puedes comparar números sin necesidad de variables:

```bash
if [ 5 -gt 3 ]; then
    echo "5 es mayor que 3"
fi
```
✔ Esto imprimirá: `5 es mayor que 3`

---

### **3️⃣ Usando entrada del usuario**
Si quieres que el usuario introduzca los operandos:

```bash
read -p "Ingresa el primer número: " num1
read -p "Ingresa el segundo número: " num2

if [ "$num1" -ge "$num2" ]; then
    echo "$num1 es mayor o igual que $num2"
else
    echo "$num1 es menor que $num2"
fi
```

📌 **Importante**: `read` almacena la entrada como texto, pero Bash automáticamente la maneja como número en las comparaciones.

---

## 🔹 **Errores comunes al declarar operandos**
### ❌ **1. No poner espacios en los corchetes `[` y `]`**
```bash
# Esto es incorrecto y generará un error
if [$num1 -lt $num2]; then
```
✔ **Corrección**: Debe haber espacios alrededor de `[` y `]`
```bash
if [ "$num1" -lt "$num2" ]; then
```

### ❌ **2. Usar `==` en comparaciones numéricas**
```bash
if [ "$num1" == "$num2" ]; then  # ❌ Esto no funciona para números
```
✔ **Corrección**: Usa `-eq` para comparar números
```bash
if [ "$num1" -eq "$num2" ]; then
```

### ❌ **3. Usar `-lt` o `-gt` con cadenas de texto**
```bash
nombre1="Ana"
nombre2="Carlos"

if [ "$nombre1" -lt "$nombre2" ]; then  # ❌ Esto dará error porque son cadenas
```
✔ **Corrección**: Usa `[[ ... < ... ]]` para comparar cadenas
```bash
if [[ "$nombre1" < "$nombre2" ]]; then
```

---

## 🔥 **Resumen rápido**
| Operación | Números (Enteros) | Cadenas (Texto) |
|-----------|------------------|----------------|
| Igualdad  | `-eq`            | `==` o `=`     |
| Desigualdad | `-ne`          | `!=`           |
| Mayor que | `-gt`            | `>`            |
| Mayor o igual | `-ge`        | `>=`           |
| Menor que | `-lt`            | `<`            |
| Menor o igual | `-le`        | `<=`           |
