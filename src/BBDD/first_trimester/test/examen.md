# Teórico:

  - UF1 y UF2

# Práctico:
Un ayuntamiento ante la nueva Ley 7/2023, de 28 de marzo, de protección de los derechos y el bienestar de los animales, se ha visto obligado a crear una base de datos que registre los datos personales de los propietarios de cada mascota/s que puedan tener en su domicilio.

Al visualizar la Ley, se han dado cuenta que deben de registrar de cada persona los siguientes campos de manera obligatoria:
  - El Documento Nacional de Identidad.
  - Una sola dirección de correo electrónico.
  - Un solo teléfono de contacto, que puede ser indistintamente un móvil o fijo.
  - La fecha de nacimiento de la persona.
  - El nombre completo, entendido este como el **nombre** y sus **dos apellidos**. Es cierto que en el ayuntamiento hay mucho residente extranjero que carece de segundo apellido, por lo que el segundo apellido se puede considerar no obligatorio (opcional). 
  - El domicilio en la localidad del ayuntamiento, entendido este por la constitución de tres subcampos:
    - El tipo de la vía, el nombre y el número del domicilio.
    - El código postal del domicilio.
    - El municipio donde se localiza el domicilio.

Respecto de las mascotas, se considera fundamental guardar la siguiente documentación:
  - Numero del chip de la mascota (se entiende que todas las mascotas que se van a censar poseen esta documentación ya que es obligatoria).
  - El peso en kilogramos de la mascota.
  - La fecha de nacimiento de la mascota. 
  - El nombre de la mascota en un solo campo.
  - La raza de la mascota. Para aquellas mascotas que no posean una sola raza, sino que sean producto del mestizaje de dos razas, se anotaran en el mismo campo las dos principales razas que posee ese animal.

El ayuntamiento es conocedor por información recolectada a partir de las clínicas veterinarias emplazadas en el ayuntamiento, que una mascota puede estar registrada a nombre de varios titulares, figurando siempre al menos un solo titular en sus bases de datos, ya que ellos tratan a mascotas domésticas. **Cardinalidad**

Del mismo modo, se sabe que hay vecinos que pueden no tener mascotas, ya que poseen alergia a los animales de compañía. Al mismo tiempo, también sabemos que hay vecinos que son amantes de las mascotas, y tienen varias mascotas en sus domicilios. **Cardinalidad**

Debido a esta razón debemos saber, desde cuando tienen a sus mascotas en su domicilio, ya que hay muchas mascotas que proceden de adopción de refugios de animales emplazados en la localidad del ayuntamiento. **Atributo**

Se pide crear una imagen con extensión png del modelo entidad relación (M-E-R):
Identificando todas las entidades, relaciones y atributos correspondientes, según la nomenclatura propuesta por De Miguel et al., 1999.
Identificar la cardinalidad de las relaciones y el grado de la relación.
