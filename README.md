# ITS2026_SWD
Repo del corso SWD 2026

## Descrizione 
Questa repository contiene il codice e le risorse per le lezioni e i progetti del corso di Software Development (SWD) 2026. Gli studenti possono trovare esempi di codice, esercizi pratici e materiali di supporto per approfondire le tematiche trattate durante il corso.

Principali argomenti trattati includono:
- Fondamenti di programmazione
- Linguaggi di programmazione (Java, PHP, Python, JavaScript, ecc.)
- Utilizzo di framework e librerie tra cui Spring e Laravel
- Sviluppo di applicazioni web
- Gestione di database
- Best practices nello sviluppo software


  ### Contribuzione
  Principali contributori:
  - Mauro Bogliaccino
  - Maikol Mombelli
  - Cristian Pappalardo
  - Tommaso Fatticcioni
  - Marco Rizzone

---

## Percorso di apprendimento Java nel repository

### *Analisi di github/copilot*

Ho organizzato gli argomenti dal più semplice al più avanzato, basandomi sugli esempi presenti in `maboglia/ITS2026_SWD`. Il repository contiene sia esercizi Java SE, sia progetti OOP, sia esempi Spring e multithreading.

> La ricerca automatica del codice Java restituisce solo una selezione limitata di risultati; per consultare tutti gli esempi puoi usare la [ricerca Java completa su GitHub](https://github.com/maboglia/ITS2026_SWD/search?q=language%3AJava&type=code).

---

### 1. Struttura minima di un programma Java

**Difficoltà:** ★☆☆☆☆

Argomenti:

- classe Java;
- metodo `main`;
- istruzioni;
- commenti;
- output con `System.out.println`;
- variabili di tipo `String`, `int`, `double`, `boolean`.

Esempio:

- [`HelloWorld.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/laboratorioMombelli/Java/demo/HelloWorld.java)

Concetti da imparare:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
```

---

### 2. Tipi primitivi, variabili e conversioni

**Difficoltà:** ★☆☆☆☆

Argomenti:

- tipi interi: `byte`, `short`, `int`, `long`;
- numeri decimali con `double`;
- valori booleani;
- assegnazione e inizializzazione;
- conversioni da `String` a numero.

Esempi:

- [`Interi.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/swd2026/Prj02_LaboratorioJava/src/tipi/Interi.java)
- [`Demo.java` della calcolatrice](https://github.com/maboglia/ITS2026_SWD/blob/main/workspace_fad/Prj08_Calcolatrice/src/main/Demo.java)

Particolare attenzione a:

```java
double x = Double.parseDouble(a);
```

---

### 3. Input da console e selezione delle operazioni

**Difficoltà:** ★★☆☆☆

Argomenti:

- utilizzo di `Scanner`;
- lettura di stringhe;
- `switch`;
- `case` e `default`;
- operatori aritmetici;
- gestione di input non validi.

Esempio principale:

- [`workspace_fad/Prj08_Calcolatrice`](https://github.com/maboglia/ITS2026_SWD/tree/main/workspace_fad/Prj08_Calcolatrice)

Esercizio consigliato:

- aggiungere l’operatore `%`;
- gestire la divisione per zero;
- ripetere il calcolo in un ciclo fino a quando l’utente sceglie di uscire.

---

### 4. Condizioni, cicli e contatori

**Difficoltà:** ★★☆☆☆

Argomenti:

- `if` / `else`;
- ciclo `for`;
- contatori e accumulatori;
- confronto tra valori;
- calcolo di percentuali;
- misurazione del tempo di esecuzione.

Esempio:

- [`GiocaDadi.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/swd2026/Prj01_HelloWorld/src/demo/GiocaDadi.java)

Nel programma vengono utilizzati:

```java
for (int i = 0; i < lanci; i++) {
    ...
    if (result1 == result2) {
        vittorie++;
    }
}
```

e:

```java
long start = System.currentTimeMillis();
long stop = System.currentTimeMillis();
```

---

### 5. Metodi e decomposizione del programma

**Difficoltà:** ★★☆☆☆

Argomenti:

- dichiarazione dei metodi;
- parametri;
- valori restituiti;
- `return`;
- metodi `void`;
- riutilizzo del codice;
- metodi statici e di istanza.

Esempi da studiare:

- esercitazioni sui metodi ausiliari: `Ripeti`, `TuttiUguali`, `Concatena`, `Incrementa`;
- classe [`Studente.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/fondamenti/codice/Studente.java);
- classe `CalcolatriceStatic` nel progetto della calcolatrice.

Obiettivo pratico: trasformare un programma lungo in più metodi piccoli e comprensibili.

---

### 6. Classi, oggetti, attributi e costruttori

**Difficoltà:** ★★★☆☆

Argomenti:

- differenza tra classe e oggetto;
- attributi;
- costruttori;
- `new`;
- metodi di istanza;
- stato interno dell’oggetto;
- parole chiave `this` e `final`.

Esempi:

- [`Libro.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/laboratorioMombelli/Java/demo/Libro.java)
- [`Studente.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/fondamenti/codice/Studente.java)
- classe `Dado` utilizzata da [`GiocaDadi.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/swd2026/Prj01_HelloWorld/src/demo/GiocaDadi.java)

Esempio di concetto:

```java
Dado dado1 = new Dado(6);
```

Da capire bene:

- il costruttore inizializza l’oggetto;
- ogni oggetto ha i propri valori degli attributi;
- i metodi possono leggere o modificare lo stato dell’oggetto.

---

### 7. Incapsulamento e controllo dello stato

**Difficoltà:** ★★★☆☆

Argomenti:

- modificatori di accesso;
- `private`, `public`, `protected`;
- getter e setter;
- protezione degli attributi;
- validazione dei dati;
- immutabilità di alcuni valori.

Nel codice del repository sono presenti esempi iniziali con attributi a visibilità ridotta, come:

```java
String nome;
String cognome;
int oreLezione = 0;
final String NOME_CORSO = "ITS SWD";
```

Il passo successivo consiste nel trasformarli in:

```java
private String nome;

public String getNome() {
    return nome;
}
```

---

### 8. Override e rappresentazione degli oggetti

**Difficoltà:** ★★★☆☆

Argomenti:

- ridefinizione di metodi;
- annotazione `@Override`;
- metodo `toString`;
- rappresentazione testuale di un oggetto;
- uso delle condizioni all’interno dei metodi.

Esempio:

- [`Todo.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/swd2026/Prj02_LaboratorioJava/src/todo/Todo.java)

La classe `Todo` utilizza:

```java
@Override
public String toString()
```

per produrre una rappresentazione come:

```text
[*] Attività completata
[ ] Attività da completare
```

Questo argomento è fondamentale prima di lavorare con collezioni di oggetti.

---

### 9. Enumerazioni e modellazione dei dati

**Difficoltà:** ★★★☆☆

**Argomenti indicati nel README delle esercitazioni:**

- enumerazioni;
- classi di dominio;
- esercizio `Libro`;
- esercizio `Stanza Prenotazione`;
- esercizio `Curriculum`.

Riferimento:

- [`esercitazioni/README.md`](https://github.com/maboglia/ITS2026_SWD/blob/main/esercitazioni/README.md)

Le `enum` sono utili quando una proprietà può assumere solo valori predefiniti:

```java
enum StatoPrenotazione {
    DISPONIBILE,
    CONFERMATA,
    ANNULLATA
}
```

---

### 10. Array, collezioni e generics

**Difficoltà:** ★★★★☆

Argomenti:

- array;
- `List`;
- `ArrayList`;
- tipi generici;
- ciclo `for-each`;
- inserimento e ricerca di oggetti;
- organizzazione di dati omogenei.

Esempi rilevanti:

- progetto `Prj03_Libreria`;
- classe [`Library.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/laboratorioMombelli/php/L04/library/src/Library.java);
- uso di `List<Book>` e `ArrayList<>`.

Concetto principale:

```java
List<Book> books = new ArrayList<>();
```

Da approfondire:

- differenza tra array e `ArrayList`;
- `add`, `get`, `remove`, `size`;
- ciclo sugli elementi;
- progettazione della classe `Book`.

---

### 11. Eccezioni e gestione degli errori

**Difficoltà:** ★★★★☆

Argomenti:

- `try` / `catch`;
- eccezioni checked e unchecked;
- `InterruptedException`;
- messaggi di errore;
- gestione corretta del fallimento;
- differenza tra interrompere un’attività e terminare la JVM.

Nel progetto di multithreading compaiono diversi esempi di gestione delle eccezioni, ad esempio in [`MyRunnable.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/multithreading/src/lez02/MyRunnable.java).

Concetto importante:

```java
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

Da evitare l’uso indiscriminato di:

```java
System.exit(0);
```

perché termina l’intera applicazione, non soltanto il thread corrente.

---

### 12. File, HTTP e input/output

**Difficoltà:** ★★★★☆

Argomenti:

- lettura e scrittura di file;
- gestione dei percorsi;
- richieste HTTP;
- `HttpClient`;
- `HttpRequest`;
- `HttpResponse`;
- salvataggio del contenuto ricevuto.

Questi concetti sono usati nel progetto di download concorrente del percorso:

- `multithreading/src/lez04`;
- classe `WebPageDownloader`;
- utilizzo di `java.net.http.HttpClient`.

Flusso applicativo:

```text
URL
→ HttpRequest
→ HttpClient
→ HttpResponse
→ contenuto della pagina
→ file HTML
```

---

### 13. Thread e programmazione concorrente di base

**Difficoltà:** ★★★★☆

Argomenti:

- classe `Thread`;
- metodo `run`;
- metodo `start`;
- `Thread.sleep`;
- thread principale;
- thread daemon;
- nome e priorità del thread;
- `isAlive`.

Il percorso nel repository è già organizzato progressivamente:

1. [`multithreading/src/lez01`](https://github.com/maboglia/ITS2026_SWD/tree/main/multithreading/src/lez01)
2. [`multithreading/src/lez02`](https://github.com/maboglia/ITS2026_SWD/tree/main/multithreading/src/lez02)
3. [`multithreading/src/lez03`](https://github.com/maboglia/ITS2026_SWD/tree/main/multithreading/src/lez03)

Concetto fondamentale:

```java
thread.start();
```

crea un nuovo flusso di esecuzione, mentre:

```java
thread.run();
```

è una normale chiamata sincrona a un metodo.

---

### 14. `Runnable`, thread concorrenti e `join`

**Difficoltà:** ★★★★☆

Argomenti:

- separazione tra task e thread;
- implementazione di `Runnable`;
- due o più task indipendenti;
- ordine di esecuzione non deterministico;
- `join`;
- sincronizzazione basilare.

Esempio:

- [`MyRunnable.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/multithreading/src/lez02/MyRunnable.java)
- esercizio `PING` / `PONG` nella lezione 03.

Il modello da comprendere è:

```text
Runnable = lavoro da eseguire
Thread   = esecutore del lavoro
```

Con `join()` il thread principale può attendere la conclusione degli altri thread.

---

### 15. `ExecutorService` e thread pool

**Difficoltà:** ★★★★★

Argomenti:

- `ExecutorService`;
- `Executors.newFixedThreadPool`;
- riutilizzo dei thread;
- coda dei task;
- `submit`;
- `shutdown`;
- `awaitTermination`.

Esempio:

- [`multithreading/src/lez05/Main.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/multithreading/src/lez05/Main.java)

Questo è il passaggio da:

```text
creare manualmente un thread per ogni task
```

a:

```text
inviare molti task a un numero limitato di thread riutilizzabili
```

È particolarmente importante per applicazioni che devono eseguire molti download o operazioni indipendenti.

---

### 16. `Callable`, `Future` e risultati asincroni

**Difficoltà:** ★★★★★

Argomenti:

- differenza tra `Runnable` e `Callable<T>`;
- restituzione di un valore;
- `Future<T>`;
- `submit`;
- `Future.get`;
- operazioni bloccanti;
- rappresentazione dei risultati.

Nel repository viene usato un risultato strutturato, `DownloadResult`, contenente informazioni come:

- URL;
- nome del file;
- successo o fallimento;
- messaggio.

Schema:

```text
Callable<T>
→ ExecutorService
→ Future<T>
→ get()
→ risultato
```

Esempio:

- [`multithreading/src/lez05/Main.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/multithreading/src/lez05/Main.java)

---

### 17. `record` e oggetti immutabili per i risultati

**Difficoltà:** ★★★★★

Argomenti:

- `record`;
- dati immutabili;
- accessor automatici;
- modelli semplici per trasferire dati;
- riduzione del codice boilerplate.

Esempio:

- [`multithreading/src/lez07/DownloadResult.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/multithreading/src/lez07/DownloadResult.java)

Un `record` è adatto per rappresentare un risultato che deve essere letto, ma non modificato liberamente dopo la sua creazione.

---

### 18. `ExecutorCompletionService`

**Difficoltà:** ★★★★★

Argomenti:

- recupero dei risultati nell’ordine di completamento;
- differenza tra `take()` e `poll()`;
- gestione dei task veloci e lenti;
- coda dei risultati completati;
- interruzioni durante l’attesa.

Percorso:

- [`multithreading/src/lez06`](https://github.com/maboglia/ITS2026_SWD/tree/main/multithreading/src/lez06)

Problema risolto:

```text
Future 1 lento
Future 2 veloce
Future 3 velocissimo
```

Con una lista normale di `Future`, aspettare `Future 1` può ritardare l’elaborazione degli altri. `CompletionService` permette invece di elaborare subito il primo risultato disponibile.

---

### 19. Programmazione asincrona con `CompletableFuture`

**Difficoltà:** ★★★★★

Argomenti:

- `CompletableFuture`;
- `HttpClient.sendAsync`;
- pipeline asincrone;
- composizione delle operazioni;
- callback;
- gestione asincrona degli errori;
- timeout;
- combinazione di più operazioni.

Esempi:

- [`multithreading/src/lez07/Main.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/multithreading/src/lez07/Main.java)
- [`multithreading/src/lez07/WebPageDownloader.java`](https://github.com/maboglia/ITS2026_SWD/blob/main/multithreading/src/lez07/WebPageDownloader.java)
- [`multithreading/README.md`](https://github.com/maboglia/ITS2026_SWD/blob/main/multithreading/README.md)

Progressione prevista dal progetto:

```text
Thread
→ Runnable
→ join()
→ ExecutorService
→ Callable
→ Future
→ CompletionService
→ CompletableFuture
```

Questo è il livello Java più avanzato rappresentato chiaramente nel repository.

---

### 20. Spring Boot e sviluppo di API web

**Difficoltà:** ★★★★★

Argomenti:

- applicazioni Spring Boot;
- controller;
- servizi;
- modelli;
- API REST;
- JSON;
- accesso a database;
- separazione a livelli;
- chiamate a servizi esterni.

Esempi e progetti:

- [`spring_vscode/pokemon`](https://github.com/maboglia/ITS2026_SWD/tree/main/spring_vscode/pokemon)
- [`spring_vscode/autosalone`](https://github.com/maboglia/ITS2026_SWD/tree/main/spring_vscode/autosalone)
- [`spring_vscode/magazzino`](https://github.com/maboglia/ITS2026_SWD/tree/main/spring_vscode/magazzino)
- [`spring_vscode/storia`](https://github.com/maboglia/ITS2026_SWD/tree/main/spring_vscode/storia)

Il README delle esercitazioni cita inoltre:

- API prodotti con Spring Boot;
- gestione di ortofrutta;
- prenotazioni e vendita biglietti del cinema;
- applicazione Pokémon;
- budget personale;
- quiz di storia.

Per esempio, il progetto Pokémon richiede di combinare:

```text
database
→ backend Java/Spring
→ API JSON
→ filtri per categoria
→ pagina HTML
→ servizio esterno PokeAPI
```

---

## Ordine consigliato di studio

La sequenza più efficace sarebbe:

1. Sintassi Java e `main`;
2. variabili e tipi primitivi;
3. condizioni e cicli;
4. input con `Scanner`;
5. metodi;
6. classi e oggetti;
7. costruttori e `this`;
8. incapsulamento;
9. `toString` e `@Override`;
10. enum;
11. array e collezioni;
12. generics;
13. eccezioni;
14. file e HTTP;
15. `Thread`;
16. `Runnable`;
17. `join`;
18. `ExecutorService`;
19. `Callable` e `Future`;
20. `record`;
21. `CompletionService`;
22. `CompletableFuture`;
23. Spring Boot e API REST;
24. integrazione database e servizi esterni.

## Progetti pratici da svolgere in questo ordine

1. Modificare `HelloWorld` per stampare dati inseriti dall’utente.
2. Completare la calcolatrice con controlli sugli errori.
3. Estendere `GiocaDadi` aggiungendo statistiche sui risultati.
4. Creare una classe `Studente` con getter, setter e validazione.
5. Completare una gestione di libri usando `List<Book>`.
6. Sviluppare una lista di attività basata sulla classe `Todo`.
7. Realizzare una prenotazione di stanze con una `enum` per lo stato.
8. Creare un downloader sequenziale di pagine web.
9. Trasformarlo prima in una versione con `Thread`, poi con `ExecutorService`.
10. Restituire un `DownloadResult` tramite `Callable` e `Future`.
11. Elaborare i risultati con `CompletionService`.
12. Riscrivere il downloader usando `CompletableFuture`.
13. Esporre i dati tramite una API Spring Boot.
14. Collegare l’API a un database e a un servizio esterno come PokeAPI.