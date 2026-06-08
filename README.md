# 🎓 Student Management API - Spring Boot

API REST desarrollada con Java y Spring Boot para la gestión de alumnos mediante operaciones CRUD.

El proyecto nace como una migración de una aplicación previa basada en JPA/Hibernate hacia una arquitectura más moderna utilizando Spring Boot, Spring Data JPA y una estructura organizada en capas.

---

# 📖 Descripción

Este proyecto consiste en una API REST para la gestión de alumnos, desarrollada con Spring Boot.

La aplicación permite realizar operaciones básicas sobre la entidad `Alumno`, como consultar todos los registros, buscar por identificador, crear nuevos alumnos, actualizar información existente y eliminar registros.

El objetivo principal del proyecto fue migrar una implementación anterior basada en JPA/Hibernate tradicional hacia Spring Data JPA, simplificando el acceso a datos mediante repositorios y aprovechando las ventajas del ecosistema Spring.

---

# ✨ Funcionalidades

* Obtener todos los alumnos registrados.
* Buscar un alumno por ID.
* Crear un nuevo alumno.
* Actualizar los datos de un alumno existente.
* Eliminar un alumno por ID.
* Contar el número total de alumnos.
* Gestión de respuestas HTTP mediante `ResponseEntity`.
* Separación de responsabilidades mediante capas.

---

# 🏗 Arquitectura

El proyecto sigue una arquitectura por capas propia de aplicaciones Spring Boot.

```text
Cliente HTTP / Postman
        │
        ▼
Controller
        │
        ▼
Service
        │
        ▼
Repository
        │
        ▼
Base de datos
```

## Capas principales

| Capa       | Responsabilidad                                          |
| ---------- | -------------------------------------------------------- |
| Controller | Expone los endpoints REST y gestiona las peticiones HTTP |
| Service    | Contiene la lógica de negocio                            |
| Repository | Gestiona el acceso a datos mediante Spring Data JPA      |
| Entity     | Representa las tablas de la base de datos                |

---

# 🛠 Tecnologías utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Lombok
* Maven
* Postman
* Base de datos relacional

---

# 🗄 Entidad principal

La entidad principal del proyecto es `Alumno`.

Ejemplo de estructura:

```java
@Entity
@Data
public class Alumno {

    @Id
    private Integer idAlumno;

    private String nombre;
    private String apellidos;
    private LocalDate fechaNac;
}
```

Lombok permite reducir código repetitivo mediante anotaciones como `@Data`, generando automáticamente getters, setters y otros métodos comunes.

---

# 🔗 Endpoints principales

| Método | Endpoint         | Descripción                         |
| ------ | ---------------- | ----------------------------------- |
| GET    | `/alumnos`       | Obtiene todos los alumnos           |
| GET    | `/alumnos/{id}`  | Obtiene un alumno por ID            |
| POST   | `/alumnos`       | Crea un nuevo alumno                |
| PUT    | `/alumnos/{id}`  | Actualiza un alumno existente       |
| DELETE | `/alumnos/{id}`  | Elimina un alumno por ID            |
| GET    | `/alumnos/count` | Devuelve el número total de alumnos |

---

# 📬 Ejemplos de uso

## Obtener todos los alumnos

```http
GET http://localhost:8080/alumnos
```

## Obtener un alumno por ID

```http
GET http://localhost:8080/alumnos/1
```

## Crear un alumno

```http
POST http://localhost:8080/alumnos
Content-Type: application/json
```

```json
{
  "nombre": "Juan",
  "apellidos": "Pérez López",
  "fechaNac": "2000-05-12"
}
```

## Actualizar un alumno

```http
PUT http://localhost:8080/alumnos/1
Content-Type: application/json
```

```json
{
  "nombre": "Juan",
  "apellidos": "Pérez García",
  "fechaNac": "2000-05-12"
}
```

## Eliminar un alumno

```http
DELETE http://localhost:8080/alumnos/1
```

---

# 📸 Capturas

## GET - Obtener todos los alumnos

![GET alumnos](screenshots/get-alumnos.png)

## GET - Obtener alumno por ID

![GET alumno por ID](screenshots/get-alumno-id.png)

## POST - Crear alumno

![POST alumno](screenshots/post-alumno.png)

## PUT - Actualizar alumno

![PUT alumno](screenshots/put-alumno.png)

## DELETE - Eliminar alumno

![DELETE alumno](screenshots/delete-alumno.png)

---

# 🚀 Cómo ejecutar el proyecto

## Requisitos

* Java JDK 17 o superior
* Maven
* IDE compatible con Spring Boot
* Base de datos relacional
* Postman o similar para probar los endpoints

## Pasos

1. Clonar el repositorio:

```bash
git clone https://github.com/tu-usuario/student-management-api-springboot.git
```

2. Entrar en el proyecto:

```bash
cd student-management-api-springboot
```

3. Configurar la conexión a base de datos en `application.properties`.

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_basedatos
spring.datasource.username=usuario
spring.datasource.password=contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

5. Probar los endpoints desde Postman:

```text
http://localhost:8080/alumnos
```

---

# 📚 Aprendizajes adquiridos

Durante el desarrollo de este proyecto se trabajaron conceptos clave del desarrollo backend con Java:

* Creación de APIs REST.
* Migración desde JPA/Hibernate tradicional a Spring Data JPA.
* Uso de repositorios con `JpaRepository`.
* Separación en capas Controller, Service y Repository.
* Gestión de peticiones HTTP.
* Uso de anotaciones de Spring.
* Pruebas de endpoints con Postman.
* Reducción de código repetitivo mediante Lombok.

---

# 🎯 Competencias demostradas

* Java Backend
* Spring Boot
* Spring Data JPA
* APIs REST
* Hibernate
* Maven
* SQL
* Arquitectura por capas
* Testing manual con Postman

---

# 🎓 Contexto académico

Proyecto desarrollado dentro del módulo de Acceso a Datos del Grado Superior en Desarrollo de Aplicaciones Multiplataforma (DAM).

El objetivo fue adaptar una aplicación previa desarrollada con JPA/Hibernate a una solución basada en Spring Boot y Spring Data JPA, aplicando una arquitectura backend más cercana a entornos profesionales.

