# Chinook

# Database



-- 1-5: Selezioni base

# Trova tutti gli album nella tabella Album.

select * from album;

# Trova il nome degli artisti nella tabella Artist.

select Name from artist;

# Trova i dettagli dei clienti che vivono negli Stati Uniti.

select * from customer where Country = 'USA';

# Trova i dipendenti con il titolo "Sales Manager".

select * from employee where Title = 'Sales Manager';

# Trova i generi musicali elencati nella tabella Genre.

select Name from genre group by GenreId; 

-- 6-10: Filtri e ordinamenti

# Trova i clienti la cui città inizia con "San".

select * from customer where City REGEXP '^(San)';

# Trova i brani con una durata superiore a 5 minuti (300000 millisecondi).

select * from track where Milliseconds > 300000;

# Ordina gli artisti in ordine alfabetico.

select * from artist order by Name;

# Trova gli album associati all'artista con ArtistId 5.

select * from album where ArtistId = 5;

# Trova le fatture con un totale superiore a $50, ordinate per data.

select * from invoice where Total > 50 order by InvoiceDate;

-- 11-15: Funzioni aggregate

# Conta il numero totale di clienti.

select count(*) from customer;

# Calcola il totale delle vendite registrate nella tabella Invoice.

select count(*) from invoice;

# Trova il prezzo massimo tra i brani nella tabella Track.

select MAX(UnitPrice) from track;

# Trova il numero di dipendenti per ogni città.

select City, count(*) as NumeroDipendenti from employee group by City;

# Trova il prezzo medio per unità dei brani.

select AVG(UnitPrice) as PrezzoMedio from track;

-- 16-20: Join semplici

# Trova i dettagli degli album e degli artisti associati.

select * from artist inner join album using(ArtistId); 

# Trova i brani e i loro generi.

select track.Name,genre.Name from track inner join genre using(GenreId);

# Trova i dettagli delle fatture e dei clienti.

select * from customer inner join invoice using(CustomerId);

# Trova le playlist e i brani associati.

select track.Name,playlist.Name from track,playlist,playlisttrack where track.TrackId = playlisttrack.TrackId and playlist.PlaylistId = playlisttrack.PlaylistId; 

# Trova i brani con il rispettivo tipo di supporto.

select track.Name,mediatype.Name from track inner join mediatype on track.MediaTypeId = mediatype.MediaTypeId order by track.Name;

-- 21-25: Filtri avanzati e subquery

# Trova i brani più lunghi (durata superiore alla media).

select track.Name,track.Milliseconds from track where Milliseconds > (select avg(Milliseconds)from track);

# Trova i dipendenti che non riportano a nessuno.

select * from employee where ReportsTo is NULL;

# Trova i clienti che non hanno effettuato fatture.

select customer.CustomerId,invoice.InvoiceId from customer  left join invoice using(CustomerId) where invoice.InvoiceId is NULL order by customer.CustomerId;

# Trova le città che hanno più di 2 dipendenti.

select City,count(*) as NumeroDipendentiPerCitta from employee group by City having NumeroDipendentiPerCitta > 2 ;

# Trova i brani appartenenti a generi diversi da "Rock".

select * from track inner join genre using(GenreId) where NOT genre.Name = 'Rock';

-- 26-30: Query avanzate

# Trova i dettagli delle fatture e dei dipendenti di supporto associati.

SELECT employee.*, invoice.*
FROM employee
JOIN customer ON customer.SupportRepId = employee.EmployeeId
JOIN invoice ON customer.CustomerId = invoice.CustomerId; 

# Trova i brani presenti in più di una playlist.

select track.*,playlisttrack.PlaylistId from track inner join playlisttrack using(TrackId) inner join playlist using(PlaylistId) where track.TrackId IN ( SELECT TrackId
    FROM playlisttrack
    GROUP BY TrackId
    HAVING COUNT(*) > 1) 
    order by track.Name;

# Conta il numero di album per artista.

select Name,count(*) as Numero_Album from artist inner join album using(ArtistId) group by ArtistId;

# Trova il cliente con la spesa totale più alta.

select customer.*,SUM(invoice.Total) as Spesa_Totale from customer inner join invoice using(CustomerId) group by CustomerId order by Spesa_Totale DESC limit 1;

# Trova le città in cui vivono sia dipendenti che clienti.

select customer.City from customer inner join employee on customer.City = employee.City group by customer.City;