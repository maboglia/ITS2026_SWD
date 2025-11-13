const COUNTER = document.getElementById('counter');
const BTN_PREV = document.querySelector('#btn_prev')
const BTN_NEXT = document.querySelector('#btn_next')



let conta_testi = 5;

let contatore = 0;

function inc() {

    if (contatore == conta_testi - 1) {
        contatore = 0;
    } else {
        contatore++;
    }

    show();
}

function dec() {

    if (contatore == 0) {
        contatore = conta_testi - 1;
    } else {
        contatore--;
    }

    show();
}

function show() {

    const IMMAGINE = document.createElement('img')//creato oggetto img
    IMMAGINE.src = luoghi[contatore].foto
    IMMAGINE.alt = luoghi[contatore].nome

    const TESTO = document.createElement('h2')//creato oggetto h2
    TESTO.textContent = luoghi[contatore].nome

    COUNTER.innerHTML = ''
    COUNTER.append(TESTO, IMMAGINE)
    //COUNTER.textContent = luoghi[contatore];    
}

BTN_PREV.onclick = dec
BTN_NEXT.addEventListener('click', inc)