CREATE SCHEMA IF NOT EXISTS lang_catalog
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS lang_catalog.language
(
    name character varying(10) NOT NULL,
    description character varying(100),
    rating integer NOT NULL,
    CONSTRAINT language_pkey PRIMARY KEY (name)
);

ALTER TABLE IF EXISTS lang_catalog.language
    OWNER to postgres;