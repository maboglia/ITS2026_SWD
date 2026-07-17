# Mini-Stack PHP REST API

Una micro-architettura PHP minimale, veloce e strutturata, ideale per lo sviluppo di API REST. Utilizza **Composer** per la gestione delle dipendenze, **FastRoute** per il routing avanzato e gestisce i payload JSON nativamente tramite `php://input`.

## 📁 Struttura del Progetto

```text
├── config/
│   └── routes.php         # Definizione delle rotte dell'applicazione
├── public/
│   └── index.php          # Front Controller (Unico punto di accesso)
├── src/
│   └── Controllers/
│       └── ApiController.php # Logica di business e gestione risposte
├── composer.json          # Configurazione di Composer e Autoload PSR-4
└── README.md              # Documentazione del progetto
```

---

## 🚀 Requisiti Minimi

* PHP 8.0 o superiore
* Composer installato sul sistema

---

## 🛠️ Installazione e Configurazione

Segui questi passaggi per configurare l'ambiente e scaricare le dipendenze corrette.

### 1. Preparazione dei File
Crea la struttura delle cartelle e i file necessari manualmente oppure utilizza lo script automatico corretto.

Se usi lo script Bash, assicurati che utilizzi il comando `require` per scaricare i pacchetti mancanti:
```bash
# Sostituisci la sezione finale del vecchio script con questa, oppure esegui:
composer require nikic/fast-route
composer dump-autoload
```

### 2. Generazione manuale (Alternativa rapida)
Se preferisci fare tutto da terminale senza script:
```bash
# Crea le cartelle
mkdir -p config public src/Controllers

# Inizializza Composer e installa il Router
composer init --no-interaction
composer require nikic/fast-route
```
Assicurati di aggiungere la mappatura `autoload` nel tuo `composer.json`:
```json
"autoload": {
    "psr-4": {
        "App\\": "src/"
    }
}
```
Aggiorna l'autoloader se modifichi il file json:
```bash
composer dump-autoload
```

---

## 💻 Avvio del Server Locale

Avvia il server di sviluppo integrato in PHP puntando direttamente alla cartella pubblica (`public/`):

```bash
php -S localhost:8000 -t public
```

---

## 📡 Testare gli Endpoint API

Puoi testare il funzionamento della mini-stack usando strumenti come Postman, Bruno, cURL o l'estensione Thunder Client di VS Code.

### 1. Richiesta GET (Home)
Verifica che il routing funzioni correttamente.

* **URL:** `http://localhost:8000/`
* **Metodo:** `GET`

**Risposta attesa (JSON):**
```json
{
  "message": "Benvenuto nella tua Mini-Stack strutturata!"
}
```

### 2. Richiesta POST (Invio dati JSON)
Invia un payload raw nel corpo della richiesta per testare la lettura da `php://input`.

* **URL:** `http://localhost:8000/api/dati`
* **Metodo:** `POST`
* **Header richiesto:** `Content-Type: application/json`
* **Payload (Body RAW):**
```json
{
  "nome": "Mario",
  "ruolo": "Developer"
}
```

**Risposta attesa (JSON):**
```json
{
  "status": "success",
  "dati_ricevuti": {
    "nome": "Mario",
    "ruolo": "Developer"
  }
}
```

---

## 🔍 Come Funziona il Recupero Dati (`php://input`)

Nelle API REST moderne, i dati vengono inviati spesso come stringhe JSON grezze (`application/json`) e non come classici moduli di form (`multipart/form-data`). 

L'array globale `$_POST` di PHP in questi casi rimane vuoto. Nel file `ApiController.php` viene usato questo approccio per intercettare il flusso:

```php
// Legge il flusso di input raw
\$input = file_get_contents('php://input');

// Trasforma la stringa JSON in un array associativo PHP
\(data = json_decode(\)input, true);
```