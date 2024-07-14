# Foro

Este proyecto es una aplicación de gestión de foro desarrollada en Java utilizando Spring Boot. Proporciona una  API Rest para la gestion de topicos , persistir datos en una base de datos Mysql .

## Endpoints

1. **/topicos**``
   - Metodo GET: Lista todos los topicos guardados en la base de datos, ejemplo.
     http://localhost:8080/topicos/
     o puedes colocar el id en la url de un topico para una busqueda individual, ejemplo:
     http://localhost:8080/topicos/1
   - Metodo POST: crea un nuevo topico, debe enviar el sigiente json:
     {
     "titulo": "topico ejemplo",
     "mensaje": "este es un topico de ejemplo",
     "idAutor": 1,
     "idCurso": 1
      }
   - Metodo PUT: modifica un topico, debe enviar el sigiente json:
      {
	   "id":1,
      "titulo": "topico actualizado",
	   "mensaje":"mensaje actualizado"
      }
   - Metodo DELETE: elimina logicamente un topico, debe incluir el id del topico en la url, ejemplo:
     http://localhost:8080/topicos/1

2. **/login:**
   - permite la generacion de token para la autorizacion, se debe crear un usuario en la base de datos previamente

## Configuración

1. **Requisitos previos:**
   - Java 11 o superior instalado.
   - Mysql instalado y configurado.

2. **Configuración de la Base de Datos:**
   - Crea una base de datos en Mysql para almacenar los datos de la librería.
   - Actualiza las propiedades de conexión en `application.properties`.

3. **Ejecución del Proyecto:**
   - Clona este repositorio.
   - Ejecuta la aplicación usando `./mvnw spring-boot:run`.

## Contribución

¡Siéntete libre de contribuir al proyecto! Puedes abrir problemas, enviar solicitudes de extracción o mejorar la documentación.
