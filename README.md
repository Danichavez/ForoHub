API REST ForoHub

API RESTful para gestionar tópicos en ForoHub.

Descripción del Proyecto
Este proyecto implementa una API REST para la gestión de tópicos en un foro de discusión. Permite la creación, actualización, obtención y eliminación de tópicos, así como la asociación con usuarios y cursos.

Tecnologías Utilizadas
Java 11
Spring Boot 2.5.4
Maven como gestor de dependencias
Base de datos MySQL
Dependencias del Proyecto
El proyecto utiliza las siguientes dependencias principales:

Spring Boot Starter Web
Spring Boot Starter Data JPA
Lombok (para reducir código boilerplate)
MySQL Connector Java
Estructura del Proyecto
El proyecto está estructurado en varios paquetes:

alura.forohub.api: Contiene las clases principales de la API.
alura.forohub.api.domain: Define las entidades de dominio como Usuario, Curso, Topico.
alura.forohub.api.repository: Repositorios para las entidades JPA.
alura.forohub.api.controller: Controladores REST para cada recurso.
alura.forohub.api.dto: Objetos de transferencia de datos para las solicitudes y respuestas de la API.
alura.forohub.api.service: Servicios que encapsulan la lógica de negocio.
alura.forohub.api.exception: Manejo de excepciones personalizado.
Configuración
Configuración de la Base de Datos
La configuración de la base de datos se realiza en application.properties: