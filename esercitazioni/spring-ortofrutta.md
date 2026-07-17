# Spring ortofrutta

Esercitazione Spring Boot: Esposizione dati della tabella prodotti ortofrutticoli tramite API REST

## Obiettivo

Realizzare una semplice applicazione Spring Boot che si connetta a un database MySQL contenente la tabella prodotti_ortofrutticoli e che esponga un endpoint REST in grado di restituire i dati della tabella in formato JSON.

## Requisiti

* Java 17 o superiore
* Spring Boot
* Spring Data JPA
* MySQL Driver
* Maven

## Attività da svolgere

* Creare un nuovo progetto Spring Boot utilizzando le dipendenze:
    * Spring Web
    * Spring Data JPA
    * MySQL Driver

Configurare la connessione al database nel file application.properties.

* Creare l'entity ProdottoOrtofrutticolo che rappresenti la tabella prodotti_ortofrutticoli.
* Creare un repository JPA che permetta di leggere i dati dalla tabella.
* Creare un service che recuperi tutti i prodotti presenti nel database.
* Creare un controller REST con un endpoint:
GET /api/prodotti
che restituisca tutti i record della tabella in formato JSON.

## Struttura suggerita

src/main/java
 ├── entity
 │    └── ProdottoOrtofrutticolo.java
 ├── repository
 │    └── ProdottoRepository.java
 ├── service
 │    └── ProdottoService.java
 ├── controller
 │    └── ProdottoController.java
 └── DemoApplication.java

## Output atteso

Invocando l'endpoint:

GET `http://localhost:8080/api/prodotti`
si dovrà ottenere una risposta simile:

```json
[
  {
    "id": 1,
    "nome": "Mele Fuji",
    "categoria": "Frutta",
    "origine": "Trentino-Alto Adige",
    "prezzoKg": 1.85,
    "disponibilita": "alta"
  },
  {
    "id": 2,
    "nome": "Pere Abate",
    "categoria": "Frutta",
    "origine": "Emilia-Romagna",
    "prezzoKg": 2.10,
    "disponibilita": "media"
  },
  {
    "id": 3,
    "nome": "Arance Navel",
    "categoria": "Frutta",
    "origine": "Sicilia",
    "prezzoKg": 1.25,
    "disponibilita": "alta"
  },
  {
    "id": 4,
    "nome": "Banane",
    "categoria": "Frutta",
    "origine": "Ecuador",
    "prezzoKg": 1.40,
    "disponibilita": "alta"
  }
]
```

## Obiettivo finale

Verificare il corretto funzionamento dell'applicazione utilizzando un browser o un client REST come Postman, controllando che l'endpoint restituisca i dati presenti nella tabella sotto forma di JSON.