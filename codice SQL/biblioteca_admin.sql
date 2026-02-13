# quale db usa
use biblioteca;

# mostra tabelle
show tables;

# table editori
create table editori(

	editore_id int primary key auto_increment,
	nome varchar(30) not null unique,
	contatto varchar(100)
);
# table libri: un libro dve essere collegato a un editore
drop table if exists libri;
create table libri(

	libro_id int primary key auto_increment,
	titolo varchar(100) not null,
	prezzo decimal(5,2) default 0,
	pagine int default 0,
	editore_id int not null,
	foreign key (editore_id) references editori(editore_id)

);

# CRUD
insert into editori (nome, contatto) values ('Mondadori', 'info@mondadori.it');
insert into editori (nome, contatto) values ('Feltrinelli', 'info@Feltrinelli.it');
select * from editori;
update editori set contatto = 'commerciale@mondadori.it' where editore_id = 1;
delete from editori where editore_id = 1;

truncate editori;
truncate libri;

alter table libri drop foreign key libri_ibfk_1;
alter table libri add constraint libri_ibfk_1 foreign key (editore_id) references editori(editore_id);
alter table autori_libri drop foreign key autori_libri_ibfk_1;
alter table autori_libri add constraint autori_libri_ibfk_1 foreign key (`libro_id`) REFERENCES `libri` (`libro_id`);

insert into libri (titolo, editore_id) values ('Zanna bianca', 1);
insert into libri (titolo, editore_id) values ('Zanna verde', 1);
insert into libri (titolo, editore_id) values ('Zanna gialla', 2);

select libri.titolo, editori.nome 
from libri, editori
where libri.editore_id = editori.editore_id 
;

create table libri_rari like libri;
insert into libri_rari select * from libri_rari;

create table autori(
	autore_id int primary key auto_increment,
	nome varchar(30) not null,
	cognome varchar(50) default null,
	nazionalita char(2) default null
);

drop table autori_libri;
create table autori_libri(
	libro_id int not null,
	autore_id int not null,
	primary key (libro_id, autore_id),
	foreign key (libro_id) references libri (libro_id),
	foreign key (autore_id) references autori (autore_id)

);

describe autori_libri;
show create table autori_libri;
CREATE TABLE `autori_libri` (
  `libro_id` int NOT NULL,
  `autore_id` int NOT NULL,
  PRIMARY KEY (`libro_id`,`autore_id`),
  KEY `autore_id` (`autore_id`),
  CONSTRAINT `autori_libri_ibfk_1` FOREIGN KEY (`libro_id`) REFERENCES `libri` (`libro_id`),
  CONSTRAINT `autori_libri_ibfk_2` FOREIGN KEY (`autore_id`) REFERENCES `autori` (`autore_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `editori` VALUES (1,'Mondadori','info-mondadori@gmail.com'),(3,'Einaudi','amm-einaudi@gmail.com'),(4,'Salani','salani-info@gmail.com'),(5,'Edizioni Clandestine','clandestine-info@gmail.com'),(6,'Bao Publishing','bao_editore@gmail.com'),(7,'Sellerio','amm-sellerio@gmail.com'),(8,'BUR','bur_editore@gmail.com'),(9,'Sperling & Kupfer','sperling-info@gmail.com'),(10,'Bompiani','contact-bompiani@gmail.com'),(11,'Adelphi','adelphi-info@gmail.com');

INSERT INTO `libri` VALUES (1,'Alchimista (L\')',12.00,10,1),(2,'Cinquanta sfumature di grigio',10.20,560,1),(3,'Dieci piccoli indiani',10.20,208,1),(4,'Don Chisciotte della Mancha',20.40,123,3),(5,'Harry Potter e la Pietra Filosofale',8.50,302,4),(6,'Il Codice da Vinci',11.00,512,1),(7,'Il giovane Holden',10.20,251,3),(8,'Il leone, la strega e l\'armadio',7.65,182,1),(9,'Il libretto rosso',7.22,160,5),(10,'Il Piccolo Principe',4.25,95,1),(11,'Il Signore degli Anelli: La compagnia dell\'anello. Le due torri. Il ritorno del re',25.00,1255,10),(12,'Il sogno della camera rossa. Romanzo cinese del XVIII secolo',15.30,721,3),(13,'La colonna di fuoco',27.00,912,1),(14,'La donna della domenica',12.00,434,1),(15,'Lo Hobbit',9.35,417,10),(16,'Macerie prime',14.45,192,6),(17,'Origin',21.25,564,1),(18,'Quel che resta del giorno',12.00,276,3),(19,'Un mese con Montalbano',12.75,512,7),(20,'Una storia tra due città',9.77,600,10),(21,'Marcovaldo',10.00,120,7),(22,'IT',25.00,550,9),(23,'gomorra',12.59,345,1);

INSERT INTO `autori` VALUES (1,'John Ronald Reuel','Tolkien','za'),(2,'Dan','Brown','us'),(3,'Paulo','Coelho','br'),(4,'J. D.','Salinger','us'),(5,'Agatha','Christie','en'),(6,'J. K.','Rowling','en'),(7,'Tsao','Chan','cn'),(8,'E. L.','James','en'),(9,'Antoine','de Saint-Exup?ry','fr'),(10,'Charles','Dickens','en'),(11,'Miguel','de Cervantes','es'),(12,'Clive Staples','Lewis','en'),(13,'Tse-tung','Mao','cn'),(14,'Michele','Rech, Zerocalcare','it'),(15,'Andrea','Camilleri','it'),(16,'Ken','Follett','en'),(17,'Kazuo','Ishiguro','jp'),(18,'Carlo','Fruttero','it'),(19,'Franco','Lucentini','it'),(20,'Italo','Calvino','it'),(21,'Stephen','King','us'),(22,'Isabel','Allende','cl');

INSERT INTO `autori_libri` VALUES (1,3),(2,8),(3,5),(4,11),(5,6),(6,2),(7,4),(8,12),(9,13),(10,9),(11,1),(12,7),(13,16),(14,18),(14,19),(15,1),(16,14),(17,2),(18,17),(19,15),(20,10),(21,20),(22,21);

# query

select 
	l.titolo,
	(l.prezzo * 1.22) as 'Prezzo i.c.',
	e.nome as 'Casa editrice' 
from 
	libri l, 
	editori e
where l.editore_id = e.editore_id
order by l.prezzo
;

alter table libri add column prezzo_ivato decimal(5,2);
select * from libri;
update libri set prezzo_ivato = prezzo * 1.22;

select 
	l.titolo, 
	concat(a.nome, ' ', a.cognome) as autore,
	e.nome
from autori_libri al, 
	libri l, 
	autori a,
	editori e
where al.libro_id = l.libro_id 
	and	al.autore_id = a.autore_id 
	and l.editore_id = e.editore_id 
order by e.nome, l.titolo
; 






