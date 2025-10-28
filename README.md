# JSP Authentication App

Aplicación Spring Boot con vistas JSP para autenticación de usuarios. Combina REST API y páginas renderizadas en el servidor.

## Descripción

Aplicación web que combina endpoints REST con vistas JSP para registro y login de usuarios. Demuestra patrones API y MVC tradicional.

## Tecnologías

Java 17+ | Spring Boot | JSP | Spring MVC | REST API | CSS3

## Estructura del Proyecto

    src/main/
    ├── java/com/Huski/JSP/
    │   ├── controller/
    │   │   ├── ApiController.java (REST)
    │   │   └── AppController.java (JSP)
    │   ├── service/
    │   │   └── UsuarioService.java
    │   ├── model/
    │   │   └── Usuario.java
    │   └── config/
    │       └── database.java
    ├── resources/
    │   ├── static/css/style.css
    │   └── application.properties
    └── webapp/WEB-INF/views/
        ├── index.jsp
        ├── login.jsp
        └── home.jsp

## Instalación

    mvn spring-boot:run

Acceso: `http://localhost:8080`

## Funcionalidades

### Interfaz Web (JSP)

- **/** - Página de inicio
- **/login** - Formulario de login
- **/landing** - Página protegida tras login

### REST API

- **GET /api** - Listar usuarios
- **POST /api** - Registrar usuario
- **POST /api/login** - Login API

## Endpoints REST

### Registrar Usuario

    POST /api
    Content-Type: application/json

    {
        "name": "Juan",
        "correo": "juan@mail.com",
        "password": "123"
    }

### Login

    POST /api/login

    {
        "correo": "juan@mail.com",
        "password": "123"
    }

## Modelo de Datos

    {
        "id": Long,
        "name": String,
        "correo": String,
        "password": String
    }

## Configuración

    spring.mvc.view.prefix=/WEB-INF/views/
    spring.mvc.view.suffix=.jsp

## Flujo de Navegación

    Inicio (/) → Login (/login) → Landing (/landing)

## Características

- Interfaz dual (Web + API)
- Renderizado JSP en servidor
- Validación de formularios
- Redirección con mensajes de error
- Almacenamiento en memoria
- UI moderna con tema oscuro

## Códigos HTTP

| Código | Descripción           |
|--------|-----------------------|
| 200    | Login exitoso         |
| 201    | Usuario registrado    |
| 401    | Credenciales inválidas|
| 409    | Email ya existe       |

## Desarrollador

Nombre: SebitasDown
Proyecto: JSP Authentication App

---

Desarrollado con Spring Boot y JSP
