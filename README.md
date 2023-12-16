# jpa-play
Sandpit for SpringBoot + JPA + Tests - from basics to the Unknown !! 

set up mysql via a docker command and get it to run on your local ( port 3306 to be free)

-- these are the mysql db details
user=root and password=secret . These values are in the application.properties as well , so change with care ! 

-- docker for mysql
docker run -d --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=mySchema mysql:5

-- Note this 
To run mvn clean install, the DB needs to be up . So also for bringing up the app using  --> mvn  spring-boot:run . Why should DB be running when we are only r
running unit test and mockMvc ??
