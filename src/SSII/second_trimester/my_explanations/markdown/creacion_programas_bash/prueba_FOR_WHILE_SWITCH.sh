#!/bin/bash

# FOR + PARÁMETRO POSICIONAL
for n in {1..10}; do
  # El parámetro posicional es `$1` y viene introducido por consola como argumento (al ejecutar el archivo. Se escribe justo al lado)
  # Hay que poner el `$(())` para devolver las operaciones matemáticas
  multi=$(($1*$n))
  echo "$1 * $n = $multi"
done; echo " "

# WHILE
# Pedir la entrada del usuario
read -p "Introduce el número 5: " cinco
# El bucle repite la pregunta mientras no se ingrese '5'
while [ "$cinco" != "5" ]; do  # Mientras la entrada no sea 5
    echo "Por favor, introduce el número 5."  # Mensaje si no es 5
    read -p "Introduce el número 5: " cinco  # Esto repite la pregunta si no se introduce 5
done
# Cuando el usuario introduce '5', se sale del bucle
echo "¡Correcto! El número es 5."; echo " "

# CASE(SWITCH) + WHILE
# Menú de opciones
while true; do
    echo "Seleccione una opción:"
    echo "1) Crear estructura de directorios"
    echo "2) Crear archivos de configuración"
    echo "3) Salir"

    read -p "Ingrese su opción: " opcion

    case $opcion in
        1)
            # Pedir nombre del directorio raíz
            echo "Introduce el nombre del directorio raiz: "
            read dir_raiz

            # Crear estructura de directorios
            mkdir -p "$dir_raiz/RED" "$dir_raiz/SISTEMA" "$dir_raiz/ONLINE"
            echo "Estructura de directorios creada exitosamente en '$dir_raiz'."

            read -p "Presiona [Enter] para continuar..."
            ;; # el `;;` es el `break` de JS que sale de la evaluación. Después también está el `break` que sirve para detener el programa
        
        2)
            # Verificar si el directorio raíz existe
            if [ ! -d "$dir_raiz" ]; then
                echo "El directorio raiz no existe. Selecciona primero la opcion 1."
                read -p "Presiona [Enter] para continuar..."
                continue  # Aquí, el continue reinicia el bucle y vuelve al menú principal
            fi
             
            # Crear archivo CONFIGRED.txt con ifconfig
            ifconfig > "$dir_raiz/RED/CONFIGRED.txt"
            echo "Archivo CONFIGRED.txt creado en '$dir_raiz/RED'."
             
            # Crear archivo CHEQUEO.txt con fsck
            echo "Introduce la unidad a comprobar (por ejemplo, /dev/sda1):"
            read unidad
            sudo fsck "$unidad" > "$dir_raiz/SISTEMA/CHEQUEO.txt"
            echo "Archivo CHEQUEO.txt creado en '$dir_raiz/SISTEMA'."
            
            # Crear archivo PING.txt con ping
            echo "Introduce la direccion IP para hacer PING:"
            read ip
            ping -c 4 "$ip" > "$dir_raiz/ONLINE/PING.txt"
            echo "Archivo PING.txt creado en '$dir_raiz/ONLINE'."
              
            read -p "Presiona [Enter] para continuar..."
            ;;
        
        3)
            echo "Gracias por usar este programa."
            exit 0
            ;;
        
        *)
            echo "¡Esta opción es inválida! ¡Me cierro!"

            break
            ;;
    esac
done
