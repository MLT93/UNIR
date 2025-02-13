#!/bin/bash

# IF
if [true]; then
  echo "Así se crea un IF"
  continue
fi

# FOR
for n in {1..10}; do
  # $1 es un parámetro posicional introducido por consola (al ejecutar el archivo. Se escribe justo al lado)
  # Hay que poner el `$(())` para devolver las operaciones matemáticas
  multi = $(($1*$n))
  echo "$1 * $n = $multi"
done

# WHILE
while true; do

done

# SWITCH
case $opcion in
    1)
        echo "Introduce el nombre del directorio raiz:"
        read dir_raiz
        mkdir -p "$dir_raiz/RED" "$dir_raiz/SISTEMA" "$dir_raiz/ONLINE"
        echo "Estructura de directorios creada exitosamente en '$dir_raiz'."
        read -p "Presiona [Enter] para continuar..."
        # el `;;` es el `break`
        ;;
    2)
        if [ ! -d "$dir_raiz" ]; then
            echo "El directorio raiz no existe. Selecciona primero la opcion 1."
            read -p "Presiona [Enter] para continuar..."
            continue
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
        echo "Opcion invalida, intenta nuevamente."
        read -p "Presiona [Enter] para continuar..."
        ;;
esac
