# Journal

A simple Spring Boot journal API built with Kotlin, Spring Web MVC, Spring Data JPA, and H2.

## Stack

- Kotlin
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- H2 file-based database
- Gradle Kotlin DSL

## Requirements

- Java 17

## Run

```bash
./gradlew bootRun
```

The app starts on:

```text
http://localhost:8080
```

## Test

```bash
./gradlew test
```

## Database

This project uses a file-based H2 database, configured in [`application.yaml`](/Users/harshranjan/Documents/apps/Journal/src/main/resources/application.yaml).

JDBC URL:

```text
jdbc:h2:file:./data/journaldb
```

Data is persisted on disk at:

[`data/journaldb.mv.db`](/Users/harshranjan/Documents/apps/Journal/data/journaldb.mv.db)

### H2 Console

If the app is running, open:

```text
http://localhost:8080/h2-console
```

Use:

- JDBC URL: `jdbc:h2:file:./data/journaldb`
- User Name: `sa`
- Password: empty

## API Endpoints

### Health Check

```bash
curl http://localhost:8080/health-check
```

### Get All Journal Items

```bash
curl http://localhost:8080/api/journal/get-all
```

### Get Journal Item By Id

```bash
curl http://localhost:8080/api/journal/get-journal/1
```

### Add Journal Item

```bash
curl -X POST http://localhost:8080/api/journal/add-journal \
  -H "Content-Type: application/json" \
  -d '{
    "title": "First journal entry",
    "content": "Today was productive."
  }'
```

## Project Structure

```text
src/main/kotlin/com/harsh/journal
├── controller
├── mappers
├── models
│   ├── dto
│   └── entity
├── repository
└── service
```

## Notes

- H2 runs embedded inside the Spring Boot application, not on a separate DB port.
- The database is accessed through the application on port `8080`.
- Journal entries are stored in the `journal_entry_entity` table.
