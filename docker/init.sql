CREATE USER bank_admin WITH PASSWORD 'bank_admin' CREATEDB;
CREATE DATABASE bank
    WITH
    OWNER = bank_admin
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;