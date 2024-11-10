# Ejercicios de navegación y gestión de archivos-directorios en la terminal o consola

Vamos a practicar con los comandos anteriores. Comienza utilizando la terminal de MinTTY (Linux) y luego la línea de comandos de Windows (tipo MS-DOS).

Apunta los comandos utilizados para cada ejercicio.

---

### Ejercicio 1: Navegación Básica

1. Verifica tu ubicación actual en el sistema de archivos.

   - **Windows**:

     ```bash
     chdir
     ```

   - **Linux**:

     ```bash
     pwd
     ```

2. Navega al directorio raíz de tu sistema de archivos (del PC).

   - **Windows**:

     ```bash
     cd /
     ```

   - **Linux**:

     ```bash
     cd /
     ```

3. Vuelve al directorio personal (home).

   - **Windows**:

     ```bash
     cd %HOMEPATH%
     ```

   - **Linux**:

     ```bash
     cd ~
     ```

---

### Ejercicio 2: Creación de Directorios

1. Crea una carpeta llamada **proyectos** en tu directorio personal.

   - **Windows**:

     ```bash
     md proyectos
     ```

   - **Linux**:

     ```bash
     mkdir proyectos
     ```

2. Dentro de la carpeta **proyectos**, crea tres subdirectorios: **html**, **css** y **javascript**.

   Navega primero al directorio **proyectos**:

   - **Windows y Linux**:

     ```bash
     cd proyectos
     ```

   Luego crea los subdirectorios:

   - **Windows**:

     ```bash
     md html
     md css
     md javascript
     ```

   - **Linux**:

     ```bash
     mkdir html
     mkdir css
     mkdir javascript
     ```

3. Verifica que los directorios han sido creados correctamente listando el contenido de **proyectos**.

   - **Windows**:

     ```bash
     dir
     ```

   - **Linux**:
     
     normal
     ```bash
     ls
     ```

     especifica detallada con archivos ocultos y lectura para humano (h)
     ```bash
     ls -lha
     ```

     alias de ls -la
     ```bash
     ll
     ```

     alias de ls -la con lectura para humano (h). Equivalente a ls -lha
     ```bash
     ll -h
     ```

---

### Ejercicio 3: Creación de Ficheros

1. Navega al directorio **html** que creaste en el ejercicio anterior:

   - **Windows y Linux**:

     ```bash
     cd html
     ```

2. Crea un fichero llamado **index.html** dentro de la carpeta **html**.

   - **Windows**:

     ```bash
     echo > index.html
     ```

   - **Linux**:

     ```bash
     touch index.html
     ```

3. Crea un archivo llamado **styles.css** dentro de la carpeta **css**.

   Primero, navega al directorio **css**:

   - **Windows y Linux**:

     ```bash
     cd ..
     cd css
     ```

   Luego, crea el archivo:

   - **Windows**:

     ```bash
     echo > styles.css
     ```

   - **Linux**:

     ```bash
     touch styles.css
     ```

4. Crea un archivo llamado **app.js** dentro de la carpeta **javascript**.

   Primero, navega al directorio **javascript**:

   - **Windows y Linux**:

     ```bash
     cd ..
     cd javascript
     ```

   Luego, crea el archivo:

   - **Windows**:

     ```bash
     echo > app.js
     ```

   - **Linux**:

     ```bash
     touch app.js
     ```

---

### Ejercicio 4: Renombrar y Eliminar Archivos y Directorios

1. Renombra el archivo **app.js** a **main.js**.

   - **Windows**:

     ```bash
     ren app.js main.js
     ```

   - **Linux**:

     ```bash
     mv app.js main.js
     ```

2. Elimina el archivo **styles.css** en la carpeta **css**.

   Primero, navega a la carpeta **css**:

   - **Windows y Linux**:

     ```bash
     cd ..
     cd css
     ```

   Luego, elimina el archivo:

   - **Windows**:

     ```bash
     del styles.css
     ```

   - **Linux**:

     eliminación básica de archivos. Pide confirmación para cada borrado
     ```bash
     rm styles.css
     ```

3. Elimina la carpeta **javascript** (incluyendo su contenido).

   Primero, navega al directorio superior (**proyectos**)

   - **Windows y Linux**:
     ```bash
     cd ..
     ```

   Luego, elimina la carpeta:

   - **Windows**:

     ```bash
     rmdir javascript
     ```

   - **Linux**:

     eliminación recursiva de carpetas con pregunta. Elimina también todos los subdirectorios y archivos
     ```bash
     rm -ri javascript
     ```

     eliminación recursiva y forzada sin pedir confirmación. Elimina también todos los subdirectorios y archivos
     ```bash
     rm -rf javascript
     ```

---

### Ejercicio 5: Exploración de Ficheros

1. Verifica el contenido del archivo **index.html** que creaste anteriormente leyéndolo por pantalla.

   - **Windows**:

     ```bash
     cd html
     type index.html
     ```

   - **Linux**:

     ```bash
     cd html
     cat index.html
     ```

2. Agrega una línea de texto al archivo **index.html**. Añade el texto <h1>Hola Mundo</h1>.

   - **Windows**:

     ```bash
     echo "<h1>Hola mundo</h1>" > index.html
     ```

   - **Linux**:

     escritura y sobreescritura
     ```bash
     echo "<h1>Hola mundo</h1>" > index.html
     ```

     escritura y concatenación ascendente. Respeta lo escrito previamente.
     ```bash
     echo "<h1>Adiós</h1>" >> index.html
     ```

3. Verifica nuevamente el contenido del archivo **index.html** para confirmar que se añadió el texto correctamente.

   - **Windows**:

     ```bash
     cd html
     type index.html
     ```

   - **Linux**:

     ```bash
     cd html
     cat index.html
     ```
