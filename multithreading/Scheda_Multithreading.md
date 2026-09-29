# Scheda Didattica: Multithreading in Java

**Obiettivo**
Fornire una panoramica pratica e stampabile sui principali modelli di concorrenza in Java (Thread, Runnable, ExecutorService, Callable/Future, CompletionService, CompletableFuture, Virtual Threads) basata sugli esempi presenti nella cartella `multithreading`.

---

## Sommario
- Concetti fondamentali
- Modelli di esecuzione
- Esempi pratici (file di riferimento)
- Flussi operativi consigliati
- Esercizi e domande di verifica

---

## Concetti fondamentali (breve)
- Thread: flusso di esecuzione. Creazione con `new Thread(...)` e avvio con `start()`.
- Runnable: separa il task dall'esecutore; implementa `run()`.
- Callable<T>: task che restituisce un risultato tramite `call()`.
- Future<T>: rappresenta un risultato futuro; `get()` è bloccante.
- ExecutorService: thread pool e gestione dei task (`submit`, `shutdown`, `awaitTermination`).
- CompletionService: recupera i risultati nell'ordine di completamento (`take()`, `poll()`).
- CompletableFuture: programmazione asincrona e composizione (`thenApply`, `thenAccept`, `exceptionally`, `allOf`, timeout).
- Virtual Threads (Java 21): thread leggeri per I/O-bound; usare con attenzione per risorse esterne.

---

## Esempi pratici (file di riferimento)
- lez01 — concetti base `Thread`, `sleep()`: `src/lez01/Main.java`, `src/lez01/MyThread.java`
- lez02 — `Runnable` e daemon thread: `src/lez02/Main.java`, `src/lez02/MyRunnable.java`
- lez03 — concorrenza e `join()`: `src/lez03/Main.java`, `src/lez03/MyRunnable.java`
- lez04 — downloader con un thread per URL (non scalabile): `src/lez04/Main.java`, `src/lez04/WebPageDownloader.java`
- lez05 — `ExecutorService` + `Callable` + `Future`: `src/lez05/Main.java`, `src/lez05/WebPageDownloader.java`, `src/lez05/DownloadResult.java`
- lez06 — `ExecutorCompletionService`: `src/lez06/Main.java`, `src/lez06/WebPageDownloader.java`, `src/lez06/DownloadResult.java`
- lez07 — `CompletableFuture` con `sendAsync`, timeout e gestione errori: `src/lez07/Main.java`, `src/lez07/WebPageDownloader.java`, `src/lez07/DownloadResult.java`
- Appunti generali: `README.md`, `threading_evolution.md`, `virtual_threads.md`

---

## Flusso operativo consigliato (didattico)
1. Introdurre `Thread` e `Runnable` con esempi semplici (lez01, lez02).
2. Mostrare `join()` e problemi di ordine di esecuzione (lez03).
3. Presentare un caso reale I/O-bound (download) con approccio naive (lez04).
4. Introdurre `ExecutorService` e `Callable` per ottenere risultati (lez05).
5. Spiegare il problema di `Future.get()` sequenziale e introdurre `CompletionService` (lez06).
6. Mostrare `CompletableFuture` per pipeline asincrone e `sendAsync` (lez07).
7. Concludere con Virtual Threads come alternativa moderna (virtual_threads.md).

---

## Esercizi proposti
- Modificare `lez04` per gestire timeout e retry nei singoli thread.
- Riscrivere `lez05` per utilizzare `CompletionService` e confrontare l'ordine di completamento con l'implementazione originale.
- Convertire `lez07` per eseguire i task con `Executors.newVirtualThreadPerTaskExecutor()` (JDK 21+) e misurare il comportamento con un numero elevato di task simulati.

---

## Domande di verifica (per studenti)
1. Differenza pratica tra `Runnable` e `Callable`?
2. Perché `Future.get()` può essere un collo di bottiglia e come mitigarne l'effetto?
3. Quando preferire `CompletionService` rispetto a una lista di `Future`?
4. Quali vantaggi offrono i `CompletableFuture`?
5. Quali limiti esterni rimangono anche usando Virtual Threads?

---

## Link rapidi ai file (workspace)
- [README.md](README.md)
- [threading_evolution.md](threading_evolution.md)
- [virtual_threads.md](virtual_threads.md)
- [src/lez01/Main.java](src/lez01/Main.java)
- [src/lez02/Main.java](src/lez02/Main.java)
- [src/lez03/Main.java](src/lez03/Main.java)
- [src/lez04/WebPageDownloader.java](src/lez04/WebPageDownloader.java)
- [src/lez05/Main.java](src/lez05/Main.java)
- [src/lez06/Main.java](src/lez06/Main.java)
- [src/lez07/Main.java](src/lez07/Main.java)

---

*File generato automaticamente dalla panoramica nella cartella `multithreading`. Se desideri modifiche allo stile, più dettagli tecnici, o trasformare questo Markdown in una presentazione, dimmi come preferisci.*
