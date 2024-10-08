CREATE USER postgres PASSWORD 'postgres';
CREATE DATABASE postgres;
GRANT ALL PRIVILEGES ON DATABASE postgres TO postgres;
ALTER ROLE postgres SUPERUSER;


drop  table if exists "product";
drop  table if exists "authors";
DROP TABLE IF EXISTS "books" cascade ;
drop table if exists "myproduct" cascade;
drop table if exists "MYCOURSEDETAILS" cascade;
drop table if exists "MYCOURSES" cascade;

drop SEQUENCE IF EXISTS authors_id_seq;

CREATE SEQUENCE authors_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

DROP SEQUENCE IF EXISTS myproduct_id_seq;
CREATE SEQUENCE myproduct_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

DROP SEQUENCE IF EXISTS course_tbl_seq;
CREATE SEQUENCE course_tbl_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

DROP SEQUENCE IF EXISTS student_tbl_seq;
CREATE SEQUENCE student_tbl_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

DROP SEQUENCE IF EXISTS mycourses_id_seq;
CREATE SEQUENCE mycourses_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

create table myproduct(
                          id bigint DEFAULT nextval('myproduct_id_seq') NOT NULL primary key ,
                          name varchar(255) not null,
                          price numeric(38,2) not null
);


CREATE TABLE "authors" (
                           "id" bigint DEFAULT nextval('authors_id_seq') NOT NULL,
                           "name" text,
                           "age" integer,
                           CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

CREATE TABLE "books" (
                         "isbn" text NOT NULL,
                         "title" text,
                         "author_id" bigint,
                         CONSTRAINT "books_pkey" PRIMARY KEY ("isbn")
) WITH (oids = false);
ALTER TABLE ONLY "books" ADD CONSTRAINT "books_author_id_fkey" FOREIGN KEY (author_id) REFERENCES authors(id) NOT DEFERRABLE;

CREATE TABLE "STUDENT_TBL" (
                               "id" bigint not null primary key ,
                               "name" varchar not null ,
                               "age" bigint not null,
                               "department" varchar
) WITH (oids = false);


CREATE TABLE "COURSE_TBL" (
                              "id" bigint not null primary key ,
                              "title" varchar not null ,
                              "abbreviation" varchar not null ,
                              "modules" bigint not null,
                              "fee" double precision
) WITH (oids = false);

drop table if exists "MYCOURSEDETAILS";


CREATE TABLE MYCOURSEDETAILS
(
    id BIGINT PRIMARY KEY,
    description TEXT,
    CONSTRAINT  FK_MYCOURSES FOREIGN KEY (id) REFERENCES MYCOURSES (id)
);


CREATE TABLE MYCOURSES
(
    id    bigint DEFAULT nextval('mycourses_id_seq') NOT NULL PRIMARY KEY,
    title VARCHAR(255),
    primary key(id)
);
