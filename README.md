# jpa-play
Sandpit for SpringBoot + JPA + Tests - from basics to advanced mapping strategies. 

-- TODO port is configured to something other than the standard 8080 port.  

-- docker for postgres db   (database is postgres and password is example)
   docker-compose up - to bring up the db 

-- run the src/main/resources/import.sql to populate the data in the Postgres DB 

-- Ensure DB is up before you start the App.

-- mvn spring-boot:run   - to start the application 

Some curl / postman url to check

-- curl http://localhost:8080/books/list

-- curl http://localhost:8080/books/isbn/978-1-2345-6789-0

-- curl http://localhost:8080/books/title/The Shadow

-- curl http://localhost:8080/books/title/Burning
