:: Define que los comandos sean invisibles en consola. Solo muestra el comando y la salida, sin su ejecución
@echo off

:: Define etiquetas de navegación para `goto` (la referencia)
:menu

:: Limpia la consola
cls

:: Imprime en pantalla
echo =============================
echo ==      MENU PRINCIPAL     ==   
echo =============================
echo 1 - CREAR ESTRUCTURA
echo 2 - CREAR INFORMACION
echo 3 - SALIR
echo =============================

:: Pide una entrada al usuario con `/p`, crea la variable `option` y la inicializa con el valor puesto por el usuario
:: Después se realiza la comprobación con el `if` y se hace la redirección con `goto`
set /p opcion="Selecciona una opcion (elige del 1 al 3): "
if "%opcion%"=="1" goto :crear_estructura
if "%opcion%"=="2" goto :crear_informacion
if "%opcion%"=="3" goto :salir

:: Previene la elección de otra opción que sea distinta a 1, 2 o 3 y nos devuelve al menu inicial
echo Valor incorrecto, prueba de nuevo.

:: Esto pregunta si deseamos continuar, y después nos lleva a la referencia con el `goto`
pause
goto :menu

:crear_estructura
cls

set /p dir_raiz="Introduce el nombre del directorio raíz de tu programa: "
if "%dir_raiz%"=="" set dir_raiz=MY_APP

mkdir "%dir_raiz%"
mkdir "%dir_raiz%\RED"
mkdir "%dir_raiz%\SISTEMA"
mkdir "%dir_raiz%\ONLINE"
echo Estructura de directorios creada exitosamente en "%dir_raiz%".

pause
goto :menu

:crear_informacion
cls

if not exist "%dir_raiz%" (
    echo No se ha creado el directorio. Seleccione primero la opcion 1.
    
    pause
    goto :menu
) else (
    echo Has creado tu directorio en: 
    cd
)

:: Crear CONFIGRED.txt con ipconfig
ipconfig > "%dir_raiz%\RED\CONFIGRED.txt"
echo Archivo CONFIGRED.txt creado en %dir_raiz%\RED

:: Crear CHEQUEO.txt con `chkdsk`
set /p unidad="Introduce la unidad a comprobar (por ejemplo, C:): "
chkdsk %unidad% > "%dir_raiz%\SISTEMA\CHEQUEO.txt"
echo Archivo CHEQUEO.txt creado en %dir_raiz%\SISTEMA

:: Crear archivo PING con `ping`
set /p ip="Introduce la direccion IP para hacer PING: "
ping %ip% > "%dir_raiz%\ONLINE\PING.txt"
echo Archivo PING.txt creado en %dir_raiz%\ONLINE

pause
goto :menu

:salir
cls

echo Gracias por usar este programa.

pause
exit
