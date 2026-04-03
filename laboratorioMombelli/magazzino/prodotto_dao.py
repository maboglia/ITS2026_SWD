from dataclasses import dataclass # importazione del decoratore dataclass
from database import prodotti # importazione della lista di prodotti dal modulo database



@dataclass # decorazione della classe Prodotto con @dataclass
class Prodotto:
    nome_prodotto: str
    prezzo: float
    stock: int
    categoria: str
    fornitore: str

lista_prodotti = []
for a,b,c,d,e in prodotti:
    p = Prodotto(a,b,c,d,e)
    lista_prodotti.append(p)