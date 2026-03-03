SELECT * FROM papflix.games;
set sql_safe_updates = 0;
update games set genre = 'shootemup' where genre like "%Shoot 'em up%";