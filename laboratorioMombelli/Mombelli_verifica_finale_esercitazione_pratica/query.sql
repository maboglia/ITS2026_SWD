-- STEP 5 — Query base (SELECT, WHERE, ORDER BY)
-- Task
-- Scrivere query per:
-- 
-- Elenco studenti ordinati per cognome
select * from studente order by cognome;
-- Studenti nati dopo il 2007
select * from studente where data_nascita > '2008-01-01'; 
-- Materie con più di 3 ore settimanali
select * from materia where ore_settimanali > 3;
-- Esami con voto >= 8
select * from esame where voto >= 8;
-- Docenti che hanno email con dominio @scuola.it
select * from docente where email like '%@scuola.it';

-- STEP 6 — Join fondamentali
-- Task
-- Scrivere query con JOIN per:
-- 
-- Elenco studenti con la loro classe attuale
select *
from studente s
inner join iscrizione i on s.id_studente = i.id_studente 
inner join classe c on c.id_classe = i.id_classe;
-- Elenco esami con nome studente + materia + voto
select s.nome nome_studente,
m.nome nome_materia,
e.voto
from studente s
inner join esame e on s.id_studente = e.id_studente
inner join materia m on m.id_materia = e.id_materia;
-- Docenti e materie insegnate
select d.nome,
d.cognome,
m.nome materia
from docente d
inner join docente_materia dm on d.id_docente = dm.id_docente
inner join materia m on m.id_materia = dm.id_materia;
-- Studenti che hanno sostenuto un esame di Informatica
select s.nome,
s.cognome,
m.nome materia,
e.voto
from studente s 
join esame e on s.id_studente = e.id_studente
join materia m on m.id_materia = e.id_materia
where m.nome = 'Informatica';
-- Classi con numero studenti iscritti
select c.anno,
c.sezione,
c.indirizzo,
count(i.id_studente) studenti_iscritti
from classe c
left join iscrizione i on c.id_classe = i.id_classe
group by c.id_classe;
-- Join richiesti:
-- 
-- INNER JOIN
-- LEFT JOIN (almeno una query)


-- STEP 7 — Aggregazioni (GROUP BY, HAVING)
-- Task
-- Scrivere query per:
-- 
-- Media voti per studente
select s.nome,
s.cognome,
avg(e.voto) media_voti
from studente s 
inner join esame e on s.id_studente = e.id_studente
group by s.id_studente;
-- Media voti per materia
select m.nome materia,
avg(e.voto) media_voti
from materia m
inner join esame e on m.id_materia = e.id_materia
group by m.id_materia;
-- Numero esami per materia
select m.nome materia,
count(e.voto) numero_esami
from materia m
inner join esame e on m.id_materia = e.id_materia
group by m.id_materia;
-- Numero studenti per classe
select count(s.id_studente) numero_studenti,
c.anno,
c.sezione
from studente s
inner join iscrizione i on s.id_studente = i.id_studente
inner join classe c on c.id_classe = i.id_classe
group by c.anno,c.sezione;
-- Studenti con media > 7 (HAVING)
select s.nome,
s.cognome,
avg(e.voto) media_voti
from studente s 
inner join esame e on s.id_studente = e.id_studente
group by s.id_studente
having media_voti > 7;
-- Esempio:
-- 
-- SELECT id_studente, AVG(voto) AS media
-- FROM esame
-- GROUP BY id_studente
-- HAVING AVG(voto) > 7;

-- STEP 8 — Subquery e query avanzate
-- Task
-- Scrivere query con subquery per:
-- 
-- Studente con media più alta
select s.nome,
s.cognome,
avg(e.voto) media_voti
from studente s 
inner join esame e on s.id_studente = e.id_studente
group by s.id_studente
order by media_voti desc
limit 1;
-- Materia con voto medio più basso
select m.nome materia,
avg(e.voto) media_voti
from materia m
inner join esame e on m.id_materia = e.id_materia
group by m.id_materia
order by media_voti
limit 1;
-- Studenti che non hanno mai sostenuto esami
select s.nome,
s.cognome,
e.voto
from studente s 
left join esame e on s.id_studente = e.id_studente
where e.id_esame is null;
-- Docenti che insegnano più di 1 materia
select d.id_docente, 
d.nome,
d.cognome,
count(dm.id_materia) numero_materie
from docente d
inner join docente_materia dm on d.id_docente = dm.id_docente
group by d.id_docente
having numero_materie > 1;
-- Studenti che hanno almeno un 10
select distinct s.nome nome_studente,
e.voto
from studente s
inner join esame e on s.id_studente = e.id_studente
where e.voto = 10;


-- STEP 9 — Operazioni DML avanzate (UPDATE, DELETE)
-- Task
SET SQL_SAFE_UPDATES = 0;
-- Aumentare di +1 tutti i voti < 6 (max 6)
update esame
set voto = least(voto + 1,6)
where voto < 6;
-- Aggiornare email di un docente
update docente
set email = 'emailaggiornata@gmail.it'
where id_docente = 1;
-- Cancellare esami più vecchi di una data (test)
delete from esame
where data_esame < '2025-11-01';
-- Cancellare uno studente e verificare cosa succede (vincoli FK)
delete from studente
where id_studente = 1;
-- Scopo: testare ON DELETE CASCADE / RESTRICT.

-- STEP 10 — Vincoli e integrità referenziale
-- Task
-- Testare che il DB blocchi:
-- 
-- inserimento studente senza email
insert into studente (nome, cognome, data_nascita, email)
values ('Maikol','Mombelli','2000-09-14');
-- Error Code: 1136. Column count doesn't match value count at row 1	

-- inserimento email duplicata
insert into studente (nome, cognome, data_nascita, email)
values ('Maikol','Mombelli','2000-09-14','anna.bianchi@studenti.it');
-- Error Code: 1062. Duplicate entry 'anna.bianchi@studenti.it' for key 'studente.email'	

-- inserimento voto 11
insert into esame (id_studente, id_materia, data_esame, voto, tipo)
values (2, 4, '2025-11-10', 11	,'orale');
-- Error Code: 3819. Check constraint 'esame_chk_1' is violated.

-- inserimento esame con id_materia inesistente
insert into esame (id_studente, id_materia, data_esame, voto, tipo)
values (2, 120, '2025-11-10', 8	,'orale');
-- Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`scuola`.`esame`, CONSTRAINT `fk_esame_materia` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id_materia`) ON DELETE RESTRICT ON UPDATE CASCADE)
-- Output richiesto:
-- 
-- screenshot o log degli errori DB

-- STEP 11 — Viste SQL (VIEW)
-- Task
-- Creare almeno 3 viste:
-- 
-- Vista 1: elenco studenti con classe
-- CREATE VIEW v_studenti_classi AS ...
create view v_studenti_classi as 
select s.nome,
s.cognome,
c.anno,
c.sezione
from studente s
inner join iscrizione i on s.id_studente = i.id_studente
inner join classe c on c.id_classe = i.id_classe;
-- Vista 2: esami dettagliati
-- (studente + materia + voto + data)
create view e_esami_dettagliati as
select s.nome,
s.cognome,
m.nome materia,
e.voto,
e.data_esame
from studente s
inner join esame e on s.id_studente = e.id_studente
inner join materia m on m.id_materia = e.id_materia;
-- Vista 3: medie studenti
-- (media voti per studente)
create view m_media_voti as
select s.nome,
s.cognome,
avg(e.voto) media_voti
from studente s 
inner join esame e on s.id_studente = e.id_studente
group by s.id_studente;
-- Poi usare le viste in query reali.


-- STEP 12 — Report finale con query complesse
-- Task
-- Scrivere query per produrre report tipo:
-- 
-- Top 5 studenti per media voti
select s.nome,
s.cognome,
avg(e.voto) media_voti
from studente s 
inner join esame e on s.id_studente = e.id_studente
group by s.id_studente
order by media_voti desc
limit 5;
-- Studenti insufficienti (media < 6)
select s.nome,
s.cognome,
avg(e.voto) media_voti
from studente s 
inner join esame e on s.id_studente = e.id_studente
group by s.id_studente
having media_voti < 6;
-- Materie più difficili (media più bassa)
select m.nome materia,
avg(e.voto) media_voti
from materia m
inner join esame e on m.id_materia = e.id_materia
group by m.id_materia
order by media_voti;
-- Distribuzione voti (quanti 10, quanti 9, ecc.)
select esame.voto,
count(*) as numero_voti
from esame
group by esame.voto
order by esame.voto desc;
-- Classe con rendimento migliore (media più alta)
select classe.*, avg(esame.voto) as media_voti
from scuola.classe classe
join scuola.iscrizione iscrizione on classe.id_classe = iscrizione.id_classe
join scuola.esame esame on iscrizione.id_studente = esame.id_studente
group by classe.id_classe, classe.anno, classe.sezione, classe.indirizzo
order by media_voti desc
limit 1;

-- STEP 13 — Indici (INDEX) e performance base
 -- Gli indici servono per facilitare le ricerche `where`, `join`, etc...
 -- Il costo in termini di tempo sarà maggiore nel caso di
-- aggiornamento o inserimento dati.


-- studente(email)
create index idx_studente_email on scuola.studente(email);

-- esame(id_studente)
create index idx_esame_studente on scuola.esame(id_studente);

-- esame(id_materia)
create index idx_esame_materia on scuola.esame(id_materia);

-- iscrizione(id_classe)
create index idx_iscrizione_classe on scuola.iscrizione(id_classe);

-- STEP 14 — Transazioni (COMMIT, ROLLBACK)

-- Transazione Rollback
start transaction;

insert into scuola.esame (id_studente, id_materia, data_esame, voto, tipo)
values (2, 1, '2026-04-15', 7, 'scritto');

update scuola.studente studente
set studente.email = 'anna.bianchi+test@studenti.it'
where studente.id_studente = 2;

rollback;

--  Transazione Commit
start transaction;

insert into scuola.esame (id_studente, id_materia, data_esame, voto, tipo)
values (2, 1, '2026-04-16', 8, 'orale');

update scuola.studente studente
set studente.email = 'anna.bianchi@studenti.it'
where studente.id_studente = 2;

commit;

