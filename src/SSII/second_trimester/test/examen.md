# Examen de Linux

Identifica distribuciones Linux, su utilidad y diferencias.



Pregunta 10.05 pts
¿Cuál de las siguientes es una distribución de Linux basada en Debian?
Grupo de opciones de respuesta

Fedora

Arch Linux

Ubuntu

CentOS
 
Pregunta de la marca: Pregunta 2
Pregunta 20.05 pts
¿Qué distribución de Linux es conocida por su enfoque a la ciberseguridad y es utilizada comúnmente en pruebas de penetración?
Grupo de opciones de respuesta

Fedora

Kali Linux

openSUSE

Debian
 
Pregunta de la marca: Pregunta 3
Pregunta 30.05 pts
¿Cuál de las siguientes distribuciones es conocida por ser muy ligera y adecuada para equipos con recursos limitados?
Grupo de opciones de respuesta

Fedora

CentOS

Arch Linux

Lubuntu
 
Pregunta de la marca: Pregunta 4
Pregunta 40.05 pts
¿Qué gestor de archivos es comúnmente utilizado en entornos de escritorio GNOME?
Grupo de opciones de respuesta

Dolphin

Nautilus

Thunar

PCManFM
 
Pregunta de la marca: Pregunta 5
Pregunta 50.05 pts
¿Qué comando se utiliza para mostrar la ruta del directorio actual en la consola?
Grupo de opciones de respuesta

ls

cd

pwd

mkdir
 
Pregunta de la marca: Pregunta 6
Pregunta 60.05 pts
¿Qué carácter se utiliza para indicar un comentario en un script Bash?
Grupo de opciones de respuesta

#

//

*

--
 
Pregunta de la marca: Pregunta 7
Pregunta 70.05 pts
¿Qué estructura de control se utiliza para ejecutar un bloque de código si se cumple una condición?
Grupo de opciones de respuesta

while

for

if

case
 
Pregunta de la marca: Pregunta 8
Pregunta 80.05 pts
¿Qué comando se utiliza para mostrar un mensaje en la consola desde un script Bash?
Grupo de opciones de respuesta

print

echo

display

write
 
Pregunta de la marca: Pregunta 9
Pregunta 90.05 pts
¿Qué variable se utiliza para acceder al primer argumento pasado a un script Bash?
Grupo de opciones de respuesta

$0

$2

$3

$1
 
Pregunta de la marca: Pregunta 10
Pregunta 100.05 pts
¿Qué comando se utiliza para leer la entrada del usuario desde la consola en un script Bash?
Grupo de opciones de respuesta

echo

input

read

scan
 
Pregunta de la marca: Pregunta 11
Pregunta 110.05 pts
¿Cómo se declara una variable en Bash?
Grupo de opciones de respuesta

variable = "valor"

variable="valor"

set variable = "valor"

let variable = "valor"
 
Pregunta de la marca: Pregunta 12
Pregunta 120.05 pts
¿Cómo se accede al valor de una variable en Bash?
Grupo de opciones de respuesta

$variable

variable

(variable)

${variable}
 
Pregunta de la marca: Pregunta 13
Pregunta 130.05 pts
¿Cómo se pasan argumentos a un script Bash desde la línea de comandos?
Grupo de opciones de respuesta

script.sh arg1, arg2

script.sh (arg1 arg2)

script.sh arg1 arg2

script.sh [arg1] [arg2]
 
Pregunta de la marca: Pregunta 14
Pregunta 140.05 pts
¿Qué hace el comando grep?
Grupo de opciones de respuesta

Busca patrones en archivos de texto.

Lista archivos y directorios.

Cambia permisos de archivos.

Muestra el contenido de un archivo.
 
Pregunta de la marca: Pregunta 15
Pregunta 150.05 pts
¿Cómo se usa grep para buscar una palabra en un archivo?
Grupo de opciones de respuesta

grep "palabra"

grep "palabra" archivo.txt

grep archivo.txt "palabra"

find "palabra" archivo.txt
 
Pregunta de la marca: Pregunta 16
Pregunta 160.05 pts
¿Qué opción de grep muestra el número de línea donde se encuentra una coincidencia?
Grupo de opciones de respuesta

-r

-v

-i

-n
 
Pregunta de la marca: Pregunta 17
Pregunta 170.05 pts
¿Qué comando se utiliza para cambiar los permisos de un archivo o directorio en Linux?
Grupo de opciones de respuesta

chown

chmod

chgrp

useradd
 
Pregunta de la marca: Pregunta 18
Pregunta 180.05 pts
¿Qué representan los números en la representación octal de los permisos (por ejemplo, 755)?
Grupo de opciones de respuesta

Los ID de usuario y grupo.

El tamaño del archivo en bytes.

Los permisos para el propietario, el grupo y otros usuarios.

La fecha de última modificación del archivo.
 
Pregunta de la marca: Pregunta 19
Pregunta 190.05 pts
¿Qué comando se utiliza para cambiar el propietario de un archivo o directorio en Linux?
Grupo de opciones de respuesta

chown

chmod

chgrp

passwd
 
Pregunta de la marca: Pregunta 20
Pregunta 200.05 pts
¿Qué efecto tiene el comando chmod u+x archivo.sh?
Grupo de opciones de respuesta

Cambia el propietario del archivo a "usuario x".

Otorga permisos de ejecución al grupo propietario del archivo.

Otorga permisos de escritura a todos los usuarios.

Otorga permisos de ejecución al propietario del archivo.



### Crea un script Bash llamado calculadora.sh que realice las siguientes acciones:

Reciba dos números como argumentos de 2 parámetros en la línea de comandos.
Pregunte al usuario qué operación desea realizar: suma, resta, multiplicación o división.
Lea la respuesta del usuario utilizando el comando read.
Realice la operación seleccionada con los dos números proporcionados por parámetro.
Muestre el resultado en la consola.
Ejemplo de uso:

./calculadora.sh 10 5
¿Qué operación desea realizar? (suma/resta/multiplicacion/division): suma
El resultado es: 15
