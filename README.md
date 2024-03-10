# jpa-play
Sandpit for SpringBoot + JPA + Tests - from basics to the Unknown !! 

-- port is configured to 8091

-- docker for postgres db   (database is postgres and password is example)
   docker-compose up - to bring up the db 

-- run the src/main/resources/import.sql to populate the data in the DB 

-- Ensure DB is up before you start the App.
-- mvn spring-boot:run   - to start the application 

postman url to check
-- http://localhost:8080/books/list
-- http://localhost:8080/books/isbn/978-1-2345-6789-0
-- http://localhost:8080/books/title/The Shadow
-- http://localhost:8080/books/title/Burning
