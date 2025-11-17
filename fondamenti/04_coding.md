# Slide 9: Introduzione allo Sviluppo Web 🌐

L’HTML (HyperText Markup Language) è il linguaggio che descrive la **struttura** di una pagina web.
È composto da **tag**, cioè etichette che indicano al browser come mostrare i contenuti.

---

## Cos'è lo Sviluppo Web?

Lo **sviluppo web** è la creazione di siti web e applicazioni web che girano nel browser.

### I 3 Pilastri del Web

```
┌─────────────────────────────────────────┐
│   🏗️ HTML (Struttura)                   │
│   🎨 CSS (Stile)                        │
│   ⚡ JavaScript (Interattività)         │
└─────────────────────────────────────────┘
```

**Analogia Casa:**

- **HTML** = Struttura (muri, stanze, porte)
- **CSS** = Design (colori, mobili, decorazioni)
- **JavaScript** = Funzionalità (luci, riscaldamento, elettrodomestici)

### 1. HTML (HyperText Markup Language) 🏗️

#### Cos'è HTML?

Il **linguaggio di markup** che definisce la struttura e il contenuto delle pagine web.

Ecco una **scheda chiara, sintetica e adatta agli studenti** con i **principali elementi HTML**, organizzata per categorie e con esempi.

---

## 🧱 **1. Struttura di base di un documento HTML**

```html
<!DOCTYPE html>
<html>
<head>
    <title>Titolo della Pagina</title>
</head>
<body>
    Contenuto della pagina
</body>
</html>
```

* `<!DOCTYPE html>` → indica che usiamo HTML5
* `<html>` → contiene tutta la pagina
* `<head>` → informazioni non visibili (titolo, stili, meta-tag)
* `<title>` → titolo della pagina (compare nella scheda del browser)
* `<body>` → contenuto visibile (testi, immagini, link, ecc.)

---

## 📝 **2. Testo**

### Titoli (Heading)

```html
<h1>Titolo principale</h1>
<h2>Sottotitolo</h2>
<h6>Titolo più piccolo</h6>
```

### Paragrafi

```html
<p>Questo è un paragrafo di testo.</p>
```

### Testo in grassetto e corsivo

```html
<b>Grassetto</b>
<i>Corsivo</i>
<strong>Importante</strong>
<em>Enfasi</em>
```

### Linea di divisione

```html
<hr>
```

---

## 🔗 **3. Link**

```html
<a href="https://www.example.com">Visita il sito</a>
```

* `href` contiene la destinazione del link.

---

## 🖼️ **4. Immagini**

```html
<img src="foto.jpg" alt="Descrizione dell'immagine">
```

* `src` → percorso dell’immagine
* `alt` → testo alternativo (accessibilità)

---

## 📦 **5. Liste**

### Lista puntata

```html
<ul>
    <li>Elemento 1</li>
    <li>Elemento 2</li>
</ul>
```

### Lista numerata

```html
<ol>
    <li>Primo</li>
    <li>Secondo</li>
</ol>
```

---

## 📌 **6. Tabelle**

```html
<table>
    <tr>
        <th>Nome</th>
        <th>Età</th>
    </tr>
    <tr>
        <td>Marco</td>
        <td>14</td>
    </tr>
</table>
```

* `<table>` → tabella
* `<tr>` → riga
* `<th>` → intestazione
* `<td>` → cella

---

## 🧩 **7. Div e Span**

* **Elementi di contenitore** per organizzare la pagina.

```html
<div>Blocco di contenuto</div>
<span>Contenuto in linea</span>
```

`div` → blocco grande
`span` → piccolo contenitore in linea

---

## 🎛️ **8. Form e Input**

```html
<form>
    <label>Nome:</label>
    <input type="text">
    <input type="submit" value="Invia">
</form>
```

Tipi comuni di input:

```html
<input type="text">
<input type="number">
<input type="email">
<input type="password">
<input type="checkbox">
<input type="radio">
```

---

## 🎨 **9. Elementi per stile (da usare con CSS)**

```html
<style>
    p { color: blue; }
</style>
```

Oppure collegando un file CSS:

```html
<link rel="stylesheet" href="stile.css">
```

---

## 🎬 **10. Elementi multimediali**

```html
<video controls src="video.mp4"></video>
<audio controls src="musica.mp3"></audio>
```

---

## 🧪 **11. Commenti**

```html
<!-- Questo è un commento -->
```

---

## 📚 **Riepilogo dei principali tag**

| Categoria   | Tag principali                                       |
| ----------- | ---------------------------------------------------- |
| Struttura   | `html`, `head`, `body`, `title`                      |
| Testo       | `h1`…`h6`, `p`, `b`, `i`, `strong`, `em`, `br`, `hr` |
| Link        | `a`                                                  |
| Immagini    | `img`                                                |
| Liste       | `ul`, `ol`, `li`                                     |
| Tabelle     | `table`, `tr`, `th`, `td`                            |
| Contenitori | `div`, `span`                                        |
| Form        | `form`, `input`, `label`, `textarea`, `button`       |
| Multimedia  | `video`, `audio`                                     |
| Stili       | `style`, `link`                                      |
| Commenti    | `<!-- ... -->`                                       |

