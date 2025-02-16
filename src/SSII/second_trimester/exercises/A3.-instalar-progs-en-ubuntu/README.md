# Explicación y desarrollo de la actividad

# Instalaciones requeridas:

- VSCode
- XAMPP
- MySQL Workbench
- Netbeans

# Procedimiento

VSCode por estabilidad y facilidad de instalación se instala con SNAP (el programa de descarga integrado en Ubuntu 24.04)

XAMPP se intenta instalar utilizando esta guía https://inteligentedigital.com/como-instalar-xampp-en-ubuntu-22-04-paso-a-paso/
Me dió varios problemas para instalarlo, no por comandos o por versiones del mismo, más bien fué debido a que directamente no pude realizar la descarga porque apachefriends.com no cargaba (supongo que estaban haciendo algo de mantenimiento).

<div style="page-break-before: always;"></div>

MySQL Workbench se instala a través de SNAP también y se instala a través de comandos el servidor al que se conecta.

```bash
sudo apt update && sudo apt upgrade && sudo apt autoremove

sudo apt install mysql-server -y

sudo mysql --version

sudo systemctl status mysql.service

sudo systemctl start mysql && sudo systemctl enable mysql

sudo snap install mysql-workbench-community

Posteriormente, entro en Ubuntu Software, busco la aplicación de `mysql-workbench-community`, pincho en ella y voy a `permissions`. Ahí deberemos darle los siguientes permisos: `Read, add, change or remove saved passwords` para que funcione la aplicación. También se pude dar los permisos con el comando `chmod` en la raíz de la carpeta al ejecutable de la aplicación

sudo mysql -u root -p

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '<escribr-aqui-la-password-que-quieras>';

\q

exit

sudo systemctl stop mysql.service && sudo systemctl start mysql && sudo systemctl enable mysql
```

<div style="page-break-before: always;"></div>

NetBeans se instala siguiendo esta guía https://greenwebpage.com/community/how-to-install-netbeans-on-ubuntu-24-04/
También se podría optar por la instalación de SNAP que sería más estable para sus actualizaciones.

Se instala sFTP Client desde SNAP para poder interactuar con servidores FTP en el intercambio de archivos.

Se instala Apache y PHP siguiendo esta guía https://stackoverflow.com/questions/16830891/mysql-is-not-starting-in-xampp-ubuntu
```bash
sudo apt-get install php8.1-cli php libapache2-mod-php php-mysql php-curl php-gd libapache2-mod-php php-fpm php-mbstring php-xml php-bcmath php-json php-curl php-zip libzip-dev -y

sudo apt-get install apache2 -y

sudo service apache2 status

sudo ufw app list

sudo ufw app info "Apache Full"

sudo vim /etc/apache2/mods-enabled/dir.conf
```

```vim
i

# Se edita el index.php para que quede en segunda posición (index.html, index.php, ...)

esc

:wq
```

<div style="page-break-before: always;"></div>

```bash
apt-cache search php- | less

apt-cache show php8.1-tidy

sudo apt install php8.1-tidy -y

sudo systemctl restart apache2
```

```web
http://localhost/
```

```bash
cd /var/www/html/

sudo rm -rf index.html

# Dar permisos a la carpeta
sudo chown [name_of_PC_user] /var/www/html/

sudo systemctl restart apache2

sudo systemctl status apache2

# Crear proyecto en /var/www/html/
```

<div style="page-break-before: always;"></div>

# Bugs & Fix

Al intentar realizar la instalación de XAMPP se encontró el servidor de apache caído y en la página de descarga no me dejaba entrar. Por lo tanto, al tener instalado MySQL, PHP y Apache por separado, decidí instalar FileZilla para completar el pack.

Se descarga paquete .deb para utilizar el comando 'dpkg -i' y realizar su instalación.

Se instala un LAMP al final.

# Resumen

Se instalan los paquetes necesarios para construir XAMPP por separado y se instalan los demás softwares como requerido.
