# jpa-play
Sandpit for SpringBoot + JPA + Tests - from basics to advanced mapping strategies. 

-- server port is 8090 (see application.properties)  
-- docker for postgres db   (database is postgres and password is postgres)
-- start up the Postgres 
   docker-compose up - to bring up the db ( port 5433 )
-- Ensure DB is up before you start the App.
-- popualte DB - -- run the src/main/resources/import.sql to populate the data in the Postgres DB


-- mvn spring-boot:run   - to start the application (note DB starts up on 5433 port )
-- run the src/main/resources/import.sql to populate the data in the Postgres DB 



Some curl / postman url to check

-- curl http://localhost:8090/books/list

-- curl http://localhost:8090/books/isbn/978-1-2345-6789-0

-- curl http://localhost:8090/books/title/The Shadow

-- curl http://localhost:8090/books/title/Burning

-- command to login into the docker container's postgres instance. 

docker exec -it <container-id> psql -U postgres
