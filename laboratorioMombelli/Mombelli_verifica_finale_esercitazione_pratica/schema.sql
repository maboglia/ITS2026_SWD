-- ==========================================
-- schema.sql (MySQL 8+)
-- Database: scuola
-- ==========================================

DROP DATABASE IF EXISTS scuola;
CREATE DATABASE scuola;
USE scuola;

-- ==========================================
-- TABELLA CLASSE
-- ==========================================
CREATE TABLE classe (
    id_classe INT AUTO_INCREMENT PRIMARY KEY,
    anno INT NOT NULL,
    sezione VARCHAR(5) NOT NULL,
    indirizzo VARCHAR(100) NOT NULL,
    UNIQUE (anno, sezione, indirizzo),
    CHECK (anno BETWEEN 1 AND 5)
) ENGINE=InnoDB;

-- ==========================================
-- TABELLA STUDENTE
-- ==========================================
CREATE TABLE studente (
    id_studente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    data_nascita DATE NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- ==========================================
-- TABELLA DOCENTE
-- ==========================================
CREATE TABLE docente (
    id_docente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- ==========================================
-- TABELLA MATERIA
-- ==========================================
CREATE TABLE materia (
    id_materia INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE,
    ore_settimanali INT NOT NULL,
    CHECK (ore_settimanali BETWEEN 1 AND 10)
) ENGINE=InnoDB;

-- ==========================================
-- TABELLA ISCRIZIONE
-- ==========================================
CREATE TABLE iscrizione (
    id_iscrizione INT AUTO_INCREMENT PRIMARY KEY,
    id_studente INT NOT NULL,
    id_classe INT NOT NULL,
    anno_scolastico VARCHAR(9) NOT NULL,

    CONSTRAINT fk_iscrizione_studente
        FOREIGN KEY (id_studente)
        REFERENCES studente(id_studente)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_iscrizione_classe
        FOREIGN KEY (id_classe)
        REFERENCES classe(id_classe)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    UNIQUE (id_studente, anno_scolastico)
) ENGINE=InnoDB;

-- ==========================================
-- TABELLA DOCENTE_MATERIA (N:M)
-- ==========================================
CREATE TABLE docente_materia (
    id_docente INT NOT NULL,
    id_materia INT NOT NULL,

    PRIMARY KEY (id_docente, id_materia),

    CONSTRAINT fk_dm_docente
        FOREIGN KEY (id_docente)
        REFERENCES docente(id_docente)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_dm_materia
        FOREIGN KEY (id_materia)
        REFERENCES materia(id_materia)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- ==========================================
-- TABELLA ESAME
-- ==========================================
CREATE TABLE esame (
    id_esame INT AUTO_INCREMENT PRIMARY KEY,
    id_studente INT NOT NULL,
    id_materia INT NOT NULL,
    data_esame DATE NOT NULL,
    voto INT NOT NULL,
    tipo ENUM('orale','scritto','pratico') NOT NULL,

    CONSTRAINT fk_esame_studente
        FOREIGN KEY (id_studente)
        REFERENCES studente(id_studente)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_esame_materia
        FOREIGN KEY (id_materia)
        REFERENCES materia(id_materia)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CHECK (voto BETWEEN 2 AND 10)
) ENGINE=InnoDB;

-- ==========================================
-- INDICI CONSIGLIATI
-- ==========================================
CREATE INDEX idx_esame_studente ON esame(id_studente);
CREATE INDEX idx_esame_materia ON esame(id_materia);
CREATE INDEX idx_iscrizione_classe ON iscrizione(id_classe);
CREATE INDEX idx_studente_email ON studente(email);
