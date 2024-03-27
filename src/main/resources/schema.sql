drop table if exists product;
DROP TABLE IF EXISTS "authors";
DROP TABLE IF EXISTS "books";
drop table if exists myproduct;


DROP SEQUENCE IF EXISTS authors_id_seq;
CREATE SEQUENCE authors_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

DROP SEQUENCE IF EXISTS myproduct_id_seq;
CREATE SEQUENCE myproduct_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;


create table myproduct(
                        id bigint DEFAULT nextval('myproduct_id_seq') NOT NULL primary key ,
                        name varchar(255) not null,
                        price numeric(38,2) not null,
                        primary key(id)
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



