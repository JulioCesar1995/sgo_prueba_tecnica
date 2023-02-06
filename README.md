# Descripción del POC

En el presente repositorio se incluye una POC que implementa un listado de paises. Por simplicidad se combina backend y frontend en un mismo módulo. 

Se utilizan las siguientes tecnologías y bibliotecas:

<b>Backend</b> 
- JAVA 8, Spring Boot, Mybatis, H2 (motor de base de datos, utilizado en este caso en formato "embedded")
- Gestión de dependencias utilizando Maven.

<b>Frontend</b>
- Thymeleaf, 
- HTML5, CSS y ES6 
- Bootstrap (4.6) y Datatables (https://datatables.net/)
- Gestión de dependencias mediante node/npm

## Requisitos de instalación

Para compilar y ejecutar el proyecto se requiere tener instalado:

- JAVA JDK 8
- Versión reciente de Maven (probado con la versión 3.6.3)
- Versión reciente de Node (probado con la versión 19.6.0)
- IDE de desarrollo de su preferencia.

## Instrucciones de compilación

El proyecto se compila ejecutando los siguientes comandos dentro de la ruta del proyecto:

1) npm install (sólo la primera vez)
2) npm run build
3) mvn clean install -U -DskipTests

## Instrucciones de ejecución

Dentro de las múltiples formas de ejecutar el proyecto, resaltamos la siguiente: desde la línea de comandos ejecutar:

mvn spring-boot:run

## Acceso al POC

Apuntar navegador a http://localhost:8080/paises

# Enunciado prueba

1) Se debe implementar nuevos endpoints en la API REST existente que permitan listar, registrar, editar y eliminar un nuevo recurso: <b>persona</b>. La idea es apoyarse en las tecnologías ya existentes en la POC. El recurso persona debe constar de los siguientes atributos:

- Nombres
- Apellido
- Pais

En concreto, debe crearse la tabla persona en el ddl de la POC: /src/main/resources/schema.sql y las construcciones necesarias para operar sobre ella bajo una arquitectura REST 
 
2) Se debe implementar una nueva pantalla que despliegue el listado de personas con botones y/o acciones para eliminar, crear y editar una persona. Esta pantalla opera conectándose a los recursos REST de la API. La solicitud de los datos de creación y edición se debe realizar en una pantalla modal. La idea es nuevamente apoyarse en las tecnologías ya existentes en la POC. 

4) Se debe mantener la arquitectura existente, creando construcciones análogas (por ejemplo un @RestController de persona).

5) Se debe respetar el look & feel existente








