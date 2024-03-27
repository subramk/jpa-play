CREATE TABLE orders (
                        ID BIGSERIAL PRIMARY KEY,
                        TRACKING_NUMBER VARCHAR(255) UNIQUE NOT NULL,
                        ITEMS JSONB
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
