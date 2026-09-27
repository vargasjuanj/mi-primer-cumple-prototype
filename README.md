# Mi Primer Cumple: Prototipo Full Stack (Spring Boot & Angular)

[![Java 11](https://img.shields.io/badge/Java-11-orange.svg?style=flat&logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.x-brightgreen.svg?style=flat&logo=springboot)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-SPA-dd0031.svg?style=flat&logo=angular)](https://angular.io/)
[![MySQL](https://img.shields.io/badge/MySQL-Relational%20DB-4479A1.svg?style=flat&logo=mysql)](https://www.mysql.com/)
[![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL%20Document-47A248.svg?style=flat&logo=mongodb)](https://www.mongodb.com/)

**Mi Primer Cumple** es un prototipo funcional / MVP Full Stack desarrollado en el período **2020–2021** en modalidad freelance para la digitalización y gestión integral de eventos y salones infantiles.

El repositorio presenta el extracto consolidado del código fuente desarrollado en dicha etapa:
1. **Backend Relacional (`backend-mysql`)**: API REST basada en Spring Boot con Spring Data JPA / Hibernate y MySQL para transacciones estructuradas de eventos, reservas y roles.
2. **Backend NoSQL (`backend-mongo`)**: Variante orientada a documentos implementada con Spring Data MongoDB para evaluar persistencia flexible y agregaciones de stock/catálogo.
3. **Frontend SPA (`frontend`)**: Aplicación web desarrollada en Angular con Angular Material, formularios dinámicos y navegación protegida mediante Guards.

Este desarrollo sirve como respaldo técnico del caso de estudio de producto y diseño UX/UI disponible en **[Behance](https://www.behance.net/gallery/123047495/Mi-Primer-Cumple)**.

---

## 🏛️ Estructura del Repositorio

```text
mi-primer-cumple-prototype/
├── backend-mysql/           # API REST con Spring Boot y Spring Data JPA (MySQL)
│   ├── pom.xml
│   └── src/main/java/com/jjvproyectos/miprimercumple/
│       ├── controllers/     # Endpoints REST (Salón, Stock, Anfitrión, Invitado)
│       ├── daos/            # Repositorios JPA
│       ├── dtos/            # Data Transfer Objects
│       ├── model/           # Entidades de dominio relacional
│       └── services/        # Capa de servicios y lógica de negocio
│
├── backend-mongo/           # Variante de API REST con Spring Data MongoDB (NoSQL)
│   ├── pom.xml
│   └── src/main/java/com/jjvproyectosjjv/miprimercumplemongo/
│       ├── controllers/     # Endpoints REST document-oriented
│       ├── daos/            # Spring Data Mongo Repositories
│       ├── model/           # Documentos y colecciones de dominio
│       └── services/        # Lógica de persistencia de documentos
│
└── frontend/                # Single Page Application con Angular & Angular Material
    ├── package.json
    ├── angular.json
    └── src/app/
        ├── modules/         # Módulos funcionales (Anfitrión, Invitado, Home)
        └── shared/          # Componentes reutilizables, guards y servicios
```

---

## 🚀 Capacidades y Módulos Implementados

### 1. Modelo de Dominio y Negocio
* **Gestión de Participantes:** Modelado jerárquico de roles (`Anfitrión`, `Invitado`, `HijoInvitado`, `Admin`).
* **Catálogo de Artículos y Stock:** Clasificación de ítems del evento (bebidas, comidas, golosinas, postres) con unidades de medida y asignación por participante.
* **Infraestructura del Evento:** Administración de salones, ubicaciones geográficas y detalle de servicios.
* **Capa de Servicios Base:** Implementación de `BaseService` y `BaseController` para operaciones CRUD y paginación uniforme.

### 2. Arquitectura Frontend (Angular)
* **Modularización:** Separación por módulos funcionales y lazy loading para carga diferida.
* **Seguridad en Rutas:** Implementación de `CanActivate` guards (`usuario.guard.ts`) para protección de navegación según el rol del usuario.
* **Formularios Dinámicos:** Componentes reactivos para carga y edición de artículos y confirmación de invitados.
* **UI con Angular Material:** Diálogos modales (`MatDialog`), tablas interactivas, toolbars y tarjetas visuales.

---

## 🛠️ Stack Tecnológico

| Componente | Tecnologías |
| :--- | :--- |
| **Backend Relacional** | Java 11, Spring Boot 2.x, Spring Data JPA / Hibernate, MySQL |
| **Backend Documental** | Java 11, Spring Boot 2.x, Spring Data MongoDB |
| **Frontend Core** | Angular, TypeScript, RxJS, Angular Material |
| **Diseño & Producto** | Prototipado, UX Research y Design System en Behance |

---

## ⚙️ Puesta en Marcha Local

### 1. Prerrequisitos
* **Java 11** instalado.
* **Node.js** (v12 - v14) y npm.
* **MySQL** (puerto 3306) o **MongoDB** (puerto 27017).

### 2. Backend Relacional (MySQL)
```bash
cd backend-mysql
./mvnw clean spring-boot:run
```
Disponible en `http://localhost:9001/api/v1/`.

### 3. Backend Documental (MongoDB)
```bash
cd backend-mongo
./mvnw clean spring-boot:run
```
Disponible en `http://localhost:8082/api/v1/`.

### 4. Frontend (Angular)
```bash
cd frontend
npm install
ng serve
```
Disponible en `http://localhost:4200/`.

---

## 🎨 Caso de Estudio de Diseño & UX
Para visualizar el flujo de pantallas, la investigación de usuarios y el sistema de diseño del producto:
* 🖼️ **[Behance: Mi Primer Cumple Case Study](https://www.behance.net/gallery/123047495/Mi-Primer-Cumple)**
