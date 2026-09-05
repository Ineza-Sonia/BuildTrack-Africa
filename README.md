# BuildTrack Africa

BuildTrack Africa is a digital construction site coordination and resource management system designed to support small and medium-scale construction projects. It replaces manual record-keeping, verbal communication, and informal tracking methods with a centralized digital platform for managing construction projects, workers, tasks, materials, material usage, and project progress.

## Problem Statement

Small and medium-scale construction projects often rely on manual records, verbal communication, and informal methods to coordinate construction tasks and manage materials. This results in poor coordination, inaccurate material tracking, unexpected shortages, inefficient resource use, and delays in construction activities.

## Scope

BuildTrack Africa manages six core entities:

| Entity | Description |
|---|---|
| **Project** | A construction project (e.g. building a house) |
| **ConstructionTask** | Tasks within a project (foundation, walls, roofing, painting, etc.) |
| **Worker** | Workers involved in a construction project |
| **Material** | Construction materials and stock levels (cement, sand, bricks, steel, etc.) |
| **MaterialUsage** | Records of material consumption against specific tasks |
| **ProjectProgress** | Periodic progress updates for a project |

## System Workflow

```
Create Project → Register Workers → Create and Assign Tasks →
Add and Monitor Materials → Record Material Usage →
Update Task Status → Record Project Progress → Monitor Project Information
```

## Practical Implementation

For this phase of the assignment, full **CRUD (Create, Read, Update, Delete)** operations were implemented for two entities:

- **Project**
- **Worker**

### Validation types implemented
1. **Bean Validation (JSR 380)** — `@NotBlank`, `@NotNull`, `@Pattern` annotations on entity fields
2. **Built-in JSF validators** — `f:validateLength`, `f:validateRegex` (e.g. worker phone number)
3. **Custom validator classes** — `ProjectStatusValidator`, `WorkerRoleValidator` implementing `jakarta.faces.validator.Validator`

### CSS types implemented
- **External CSS** — `resources/css/style.css`
- **Internal CSS** — `<style>` block in list pages
- **Inline CSS** — `style="..."` attributes on individual elements

## Tech Stack

- **Java 17**
- **Jakarta EE 11** (Servlet, Faces, CDI)
- **JavaServer Faces (Mojarra)** — web/presentation layer
- **Hibernate ORM / JPA** — persistence layer
- **JBoss Weld** — CDI implementation
- **MySQL** — database
- **Apache Maven** — build tool
- **Apache Tomcat 11** — application server

## Project Structure

```
BuildTrackAfrica
├── src/main/java/com/buildtrackafrica/buildtrackafrica
│   ├── entity/       # JPA entity classes
│   ├── dao/          # Data access objects (Hibernate/JPA)
│   ├── controller/   # JSF managed beans (@Named)
│   ├── validator/    # Custom JSF validators
│   └── util/         # HibernateUtil (EntityManagerFactory)
├── src/main/resources/META-INF/persistence.xml
└── src/main/webapp
    ├── WEB-INF/       # web.xml, beans.xml
    ├── resources/css/ # external stylesheet
    ├── project/       # create/list/edit views
    ├── worker/        # create/list/edit views
    └── index.xhtml
```

## Setup Instructions

### Prerequisites
- JDK 17+
- Apache Maven
- Apache Tomcat 11
- MySQL Server

### Database Setup
1. Ensure MySQL is running.
2. Update credentials in `src/main/resources/META-INF/persistence.xml`:
   ```xml
   <property name="jakarta.persistence.jdbc.user" value="root"/>
   <property name="jakarta.persistence.jdbc.password" value="PASSWORD"/>
   ```
3. No manual schema creation is required — the database and tables (`project`, `worker`) are created automatically via `createDatabaseIfNotExist=true` and `hibernate.hbm2ddl.auto=update`.

### Build & Run
```bash
mvn clean package
```
Deploy the generated `target/BuildTrackAfrica-1.0-SNAPSHOT.war` to Tomcat, or run it directly via your IDE's Tomcat integration.

Then visit:
```
http://localhost:8080/BuildTrackAfrica/
```

## Software Quality Attributes

Usability, Reliability, Performance Efficiency, Maintainability, Security, Scalability, Data Integrity, and Availability were considered in the design — see full documentation for details.

## Demo Video

[Video link here]

## Author

Ineza Sonia — 27852
