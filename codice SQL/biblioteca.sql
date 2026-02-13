# DCL

-- creato nuovo utente
create user biblioteca_admin identified by '123456';

-- creato nuovo database
create database biblioteca;

-- permessi all'utente sul db
grant all on biblioteca.* to biblioteca_admin;