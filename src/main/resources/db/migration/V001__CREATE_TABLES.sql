DROP SEQUENCE IF EXISTS course_tbl_seq;
CREATE SEQUENCE course_tbl_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

DROP SEQUENCE IF EXISTS student_tbl_seq;
CREATE SEQUENCE student_tbl_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;



CREATE TABLE orders (
                        ID BIGSERIAL PRIMARY KEY,
                        TRACKING_NUMBER VARCHAR(255) UNIQUE NOT NULL,
                        ITEMS jsonb
);

CREATE TABLE books (
                       id BIGSERIAL PRIMARY KEY,
                       name varchar(255) not null
);

CREATE TABLE MyProduct (
                       id bigserial PRIMARY KEY,
                       name varchar(255) not null,
                       price double precision not null
);


CREATE TABLE STUDENT_TBL
(
    "id"   bigint  not null primary key,
    "name" varchar not null,
    "age"  bigint  not null,
    "dept" varchar
);

CREATE TABLE COURSE_TBL (
                              "id" bigint not null primary key ,
                              "title" varchar not null ,
                              "abbreviation" varchar not null ,
                              "modules" bigint not null,
                              "fee" double precision
);

CREATE TABLE STUDENT_COURSE_LINK_TABLE (
                            "student_id" bigint not null,
                            "course_id" bigint not null

)
