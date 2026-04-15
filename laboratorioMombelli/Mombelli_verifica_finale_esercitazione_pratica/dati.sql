-- ==========================================
-- dati.sql (MySQL 8+)
-- Popolamento realistico DB scuola
-- ==========================================

USE scuola;

-- CLASSI
INSERT INTO classe (anno, sezione, indirizzo) VALUES
(5, 'A', 'Informatica'),
(5, 'B', 'Informatica'),
(4, 'A', 'Elettronica');

-- MATERIE
INSERT INTO materia (nome, ore_settimanali) VALUES
('Matematica', 4),
('Informatica', 5),
('Italiano', 4),
('Inglese', 3),
('Sistemi e Reti', 4),
('TPSIT', 3);

-- DOCENTI
INSERT INTO docente (nome, cognome, email) VALUES
('Giovanni', 'Bianchi', 'giovanni.bianchi@scuola.it'),
('Laura', 'Verdi', 'laura.verdi@scuola.it'),
('Marco', 'Rossi', 'marco.rossi@scuola.it'),
('Anna', 'Neri', 'anna.neri@scuola.it'),
('Paolo', 'Ricci', 'paolo.ricci@scuola.it'),
('Silvia', 'Romano', 'silvia.romano@scuola.it'),
('Davide', 'Greco', 'davide.greco@scuola.it'),
('Marta', 'Galli', 'marta.galli@scuola.it');

-- DOCENTE_MATERIA
INSERT INTO docente_materia (id_docente, id_materia) VALUES
(1, 1),
(2, 3),
(3, 2),
(4, 4),
(5, 5),
(6, 6),
(7, 2),
(8, 1);

-- STUDENTI (20)
INSERT INTO studente (nome, cognome, data_nascita, email) VALUES
('Mario', 'Rossi', '2007-02-10', 'mario.rossi@studenti.it'),
('Anna', 'Bianchi', '2006-11-21', 'anna.bianchi@studenti.it'),
('Luca', 'Verdi', '2007-05-14', 'luca.verdi@studenti.it'),
('Sara', 'Neri', '2006-08-03', 'sara.neri@studenti.it'),
('Davide', 'Ricci', '2007-01-30', 'davide.ricci@studenti.it'),
('Elena', 'Galli', '2006-06-18', 'elena.galli@studenti.it'),
('Matteo', 'Romano', '2007-09-12', 'matteo.romano@studenti.it'),
('Giulia', 'Greco', '2006-03-07', 'giulia.greco@studenti.it'),
('Federico', 'Costa', '2007-07-22', 'federico.costa@studenti.it'),
('Martina', 'Fontana', '2006-12-05', 'martina.fontana@studenti.it'),
('Simone', 'Ferrari', '2007-04-19', 'simone.ferrari@studenti.it'),
('Chiara', 'Marino', '2006-09-28', 'chiara.marino@studenti.it'),
('Alessandro', 'De Luca', '2007-10-11', 'alessandro.deluca@studenti.it'),
('Francesca', 'Rinaldi', '2006-02-15', 'francesca.rinaldi@studenti.it'),
('Giorgio', 'Conti', '2007-06-09', 'giorgio.conti@studenti.it'),
('Valentina', 'Serra', '2006-05-20', 'valentina.serra@studenti.it'),
('Stefano', 'Moretti', '2007-08-01', 'stefano.moretti@studenti.it'),
('Irene', 'Barbieri', '2006-01-17', 'irene.barbieri@studenti.it'),
('Andrea', 'Pellegrini', '2007-03-25', 'andrea.pellegrini@studenti.it'),
('Noemi', 'Fabbri', '2006-07-13', 'noemi.fabbri@studenti.it');

-- ISCRIZIONI
INSERT INTO iscrizione (id_studente, id_classe, anno_scolastico) VALUES
(1, 1, '2025/2026'),
(2, 1, '2025/2026'),
(3, 1, '2025/2026'),
(4, 1, '2025/2026'),
(5, 1, '2025/2026'),
(6, 1, '2025/2026'),
(7, 2, '2025/2026'),
(8, 2, '2025/2026'),
(9, 2, '2025/2026'),
(10, 2, '2025/2026'),
(11, 2, '2025/2026'),
(12, 2, '2025/2026'),
(13, 3, '2025/2026'),
(14, 3, '2025/2026'),
(15, 3, '2025/2026'),
(16, 3, '2025/2026'),
(17, 3, '2025/2026'),
(18, 3, '2025/2026'),
(19, 1, '2025/2026'),
(20, 2, '2025/2026');

-- ESAMI (80+)
INSERT INTO esame (id_studente, id_materia, data_esame, voto, tipo) VALUES
(1, 1, '2025-10-10', 7, 'scritto'),
(1, 2, '2025-10-15', 9, 'pratico'),
(1, 5, '2025-11-05', 8, 'orale'),
(1, 3, '2025-11-20', 6, 'orale'),

(2, 1, '2025-10-10', 6, 'scritto'),
(2, 2, '2025-10-15', 7, 'pratico'),
(2, 4, '2025-11-10', 8, 'orale'),
(2, 3, '2025-11-20', 7, 'orale'),

(3, 1, '2025-10-10', 5, 'scritto'),
(3, 2, '2025-10-15', 6, 'pratico'),
(3, 6, '2025-11-12', 7, 'pratico'),
(3, 5, '2025-11-25', 6, 'orale'),

(4, 1, '2025-10-10', 8, 'scritto'),
(4, 2, '2025-10-15', 8, 'pratico'),
(4, 3, '2025-11-20', 9, 'orale'),
(4, 4, '2025-12-02', 7, 'orale'),

(5, 1, '2025-10-10', 4, 'scritto'),
(5, 2, '2025-10-15', 5, 'pratico'),
(5, 6, '2025-11-12', 6, 'pratico'),
(5, 3, '2025-11-20', 5, 'orale'),

(6, 1, '2025-10-10', 7, 'scritto'),
(6, 2, '2025-10-15', 7, 'pratico'),
(6, 5, '2025-11-25', 8, 'orale'),
(6, 4, '2025-12-02', 7, 'orale'),

(7, 1, '2025-10-11', 9, 'scritto'),
(7, 2, '2025-10-18', 10, 'pratico'),
(7, 6, '2025-11-12', 9, 'pratico'),
(7, 5, '2025-11-25', 10, 'orale'),

(8, 1, '2025-10-11', 6, 'scritto'),
(8, 2, '2025-10-18', 7, 'pratico'),
(8, 3, '2025-11-20', 7, 'orale'),
(8, 4, '2025-12-02', 6, 'orale'),

(9, 1, '2025-10-11', 5, 'scritto'),
(9, 2, '2025-10-18', 6, 'pratico'),
(9, 5, '2025-11-25', 5, 'orale'),
(9, 6, '2025-11-12', 6, 'pratico'),

(10, 1, '2025-10-11', 8, 'scritto'),
(10, 2, '2025-10-18', 8, 'pratico'),
(10, 4, '2025-11-10', 9, 'orale'),
(10, 3, '2025-11-20', 7, 'orale'),

(11, 1, '2025-10-11', 7, 'scritto'),
(11, 2, '2025-10-18', 7, 'pratico'),
(11, 5, '2025-11-25', 8, 'orale'),
(11, 6, '2025-11-12', 8, 'pratico'),

(12, 1, '2025-10-11', 6, 'scritto'),
(12, 2, '2025-10-18', 6, 'pratico'),
(12, 3, '2025-11-20', 6, 'orale'),
(12, 4, '2025-12-02', 5, 'orale'),

(13, 1, '2025-10-12', 9, 'scritto'),
(13, 2, '2025-10-19', 9, 'pratico'),
(13, 5, '2025-11-25', 8, 'orale'),
(13, 6, '2025-11-12', 9, 'pratico'),

(14, 1, '2025-10-12', 7, 'scritto'),
(14, 2, '2025-10-19', 7, 'pratico'),
(14, 3, '2025-11-20', 8, 'orale'),
(14, 4, '2025-12-02', 7, 'orale'),

(15, 1, '2025-10-12', 5, 'scritto'),
(15, 2, '2025-10-19', 6, 'pratico'),
(15, 5, '2025-11-25', 6, 'orale'),
(15, 6, '2025-11-12', 5, 'pratico'),

(16, 1, '2025-10-12', 6, 'scritto'),
(16, 2, '2025-10-19', 7, 'pratico'),
(16, 3, '2025-11-20', 7, 'orale'),
(16, 4, '2025-12-02', 8, 'orale'),

(17, 1, '2025-10-12', 4, 'scritto'),
(17, 2, '2025-10-19', 5, 'pratico'),
(17, 5, '2025-11-25', 5, 'orale'),
(17, 6, '2025-11-12', 6, 'pratico'),

(18, 1, '2025-10-12', 8, 'scritto'),
(18, 2, '2025-10-19', 9, 'pratico'),
(18, 5, '2025-11-25', 9, 'orale'),
(18, 6, '2025-11-12', 8, 'pratico'),

(19, 1, '2025-10-10', 6, 'scritto'),
(19, 2, '2025-10-15', 6, 'pratico'),
(19, 4, '2025-11-10', 7, 'orale'),
(19, 3, '2025-11-20', 6, 'orale'),

(20, 1, '2025-10-11', 7, 'scritto'),
(20, 2, '2025-10-18', 8, 'pratico'),
(20, 5, '2025-11-25', 7, 'orale'),
(20, 6, '2025-11-12', 8, 'pratico');

-- SESSIONE EXTRA (secondo giro)
INSERT INTO esame (id_studente, id_materia, data_esame, voto, tipo) VALUES
(1, 1, '2026-02-10', 8, 'orale'),
(2, 2, '2026-02-12', 8, 'orale'),
(3, 3, '2026-02-15', 6, 'scritto'),
(4, 5, '2026-02-20', 9, 'orale'),
(5, 1, '2026-02-10', 5, 'orale'),
(6, 6, '2026-02-18', 7, 'pratico'),
(7, 3, '2026-02-15', 10, 'orale'),
(8, 5, '2026-02-20', 6, 'orale'),
(9, 4, '2026-02-22', 5, 'orale'),
(10, 6, '2026-02-18', 8, 'pratico'),
(11, 3, '2026-02-15', 7, 'orale'),
(12, 5, '2026-02-20', 6, 'orale'),
(13, 4, '2026-02-22', 9, 'orale'),
(14, 6, '2026-02-18', 7, 'pratico'),
(15, 3, '2026-02-15', 6, 'orale'),
(16, 5, '2026-02-20', 8, 'orale'),
(17, 4, '2026-02-22', 6, 'orale'),
(18, 3, '2026-02-15', 9, 'orale'),
(19, 5, '2026-02-20', 7, 'orale'),
(20, 4, '2026-02-22', 8, 'orale');