import mysql.connector

magazzino = mysql.connector.connect(
    host="localhost",
    user= "root",
    password="root",
    database="magazzino"
)

cursor = magazzino.cursor()

query = """
    SELECT
        p.nome AS nome_prodotto,
        p.prezzo_unitario AS prezzo,
        p.quantita_stock AS stock,
        c.nome AS categoria,
        f.ragione_sociale AS fornitore
    FROM prodotti p
    JOIN fornitori f using (id_fornitore)
    JOIN categorie c using (id_categoria)
    order by categoria, fornitore
    ;

"""

cursor.execute(query)

prodotti = cursor.fetchall()

cursor.close()
magazzino.close()