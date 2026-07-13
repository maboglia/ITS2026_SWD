create database autosalone;
create database listino_barlistino_bar;

desc automobili;

ALTER TABLE `autosalone`.`motociclette` 
ADD COLUMN `id` INT NOT NULL AUTO_INCREMENT FIRST,
CHANGE COLUMN `Cilindrata (cc)` `Cilindrata` INT NULL DEFAULT NULL ,
CHANGE COLUMN `Prezzo (â‚¬)` `Prezzo` DECIMAL(10,2) NULL DEFAULT NULL ,
ADD PRIMARY KEY (`id`);
;

select * from automobili
union
select * from motociclette;
