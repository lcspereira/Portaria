-- Arquivo de inicialização do banco de dados.
-- IMPORTANTE: Este arquivo deve ser executado com psql.
CREATE ROLE portaria NOSUPERUSER NOCREATEDB NOCREATEROLE LOGIN PASSWORD 'p0r74r14';

CREATE DATABASE portaria WITH OWNER portaria ENCODING 'UTF8';
\c portaria

-- Table: visitante
CREATE TABLE visitante ( 
    id             SERIAL NOT NULL,
    nome           TEXT        NOT NULL,
    rg             VARCHAR( 10 ),
    cpf            VARCHAR( 11 ),
    telefone       TEXT,
    email          TEXT,
    endereco       TEXT,
    num_endereco   TEXT,
    compl_endereco TEXT,
    bairro         TEXT,
    cidade         TEXT,
    uf             VARCHAR( 2 ),
    cep            VARCHAR( 9 ),
    obs            TEXT,
    foto           TEXT        NOT NULL, 
    CONSTRAINT id_visitante_pk PRIMARY KEY (id)
);


-- Table: visita
CREATE TABLE visita ( 
    id           SERIAL NOT NULL,
    id_visitante BIGINT NOT NULL,
    data_hora    TIMESTAMP NOT NULL,
    obs          TEXT,
    CONSTRAINT id_visita_pk PRIMARY KEY (id),
    CONSTRAINT id_visitante_fk FOREIGN KEY (id_visitante) REFERENCES visitante ( id )
);


-- Index: idx_visitante
CREATE INDEX idx_visitante ON visitante ( 
    nome
);

GRANT ALL ON TABLE visitante TO portaria;
GRANT ALL ON TABLE visita TO portaria;
GRANT ALL ON SEQUENCE visitante_id_seq TO portaria;
GRANT ALL ON SEQUENCE visita_id_seq TO portaria;
GRANT CONNECT ON DATABASE portaria TO portaria;
ANALYZE;
