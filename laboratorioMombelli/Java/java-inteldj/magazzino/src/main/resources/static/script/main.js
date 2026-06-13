let result = document.querySelector("#result");
let input = document.querySelectorAll(".input");
let button = document.querySelector("#button");
let cat = document.querySelector("#categorie")

button.addEventListener("click", function(e){
    e.preventDefault();
    let prodotto = {
        nome : input[0].value,
        categoria : input[1].value,
        prezzo : input[2].value,
        giacenza : input[3].value
    }
    console.log(prodotto);
    fetch(`http://localhost:9004/api/prodotti/aggiungi`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(prodotto)
    }).then(() => getData());
});

cat.addEventListener("click", function (e){
    e.preventDefault();
    fetch(`http://localhost:9004/api/prodotti/categorie`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to load categories");
            }
            return response.json();
        })
        .then(categorie => {
            const select = document.getElementById("categorie");
            categorie.forEach(cat => {
                const option = document.createElement("option");
                option.value = cat;
                option.textContent = cat;
                select.appendChild(option);



            });
        })
        .catch(error => console.error("Error loading categories:", error));
})

function getProdottiByCategoria(categoria) {
    fetch(`http://localhost:9004/api/prodotti/filtra/${categoria}`)
        .then((response) => response.json())
        .then((data) => {
            result.innerHTML = "";
            data.forEach((item) => {
                result.innerHTML += `
                    <tr>
                        <td>${item.id}</td>
                        <td><input id="nomeUpdate${item.id}" type="text" value="${item.nome}"></td>
                        <td><input id="categoriaUpdate${item.id}" type="text" value="${item.categoria}"></td>
                        <td><input id="prezzoUpdate${item.id}" type="number" value="${item.prezzo}"></td>
                        <td><input id="giacenzaUpdate${item.id}" type="number" value="${item.giacenza}"></td>
                        <td><button onclick="deleteUser('${item.id}')">Delete</button></td>
                        <td><button onclick="updateProdotto('${item.id}')">Update</button></td>
                    </tr>
                    `;
            });
        });
}

function getData() {
    fetch("http://localhost:9004/api/prodotti")
        .then((response) => response.json())
        .then((data) => {
            result.innerHTML = "";
            data.forEach((item) => {
                result.innerHTML += `   
                    <tr>
                        <td>${item.id}</td>
                        <td><input id="nomeUpdate${item.id}" type="text" value="${item.nome}"></td>
                        <td><input id="categoriaUpdate${item.id}" type="text" value="${item.categoria}"></td>
                        <td><input id="prezzoUpdate${item.id}" type="number" value="${item.prezzo}"></td>
                        <td><input id="giacenzaUpdate${item.id}" type="number" value="${item.giacenza}"></td>
                        <td><button onclick="deleteUser('${item.id}')">Delete</button></td>
                        <td><button onclick="updateProdotto('${item.id}')">Update</button></td>
                    </tr>
                `
            });
        });
}


function deleteUser(id) {
    fetch(`http://localhost:9004/api/prodotti/elimina/${id}`, {
        method: "DELETE",
    }).then(() => getData());
}

function updateProdotto(id){

    let n = document.getElementById("nomeUpdate" + id).value;
    let c = document.getElementById("categoriaUpdate" + id).value;
    let p = document.getElementById("prezzoUpdate" + id).value;
    let g = document.getElementById("giacenzaUpdate" + id).value;

    let prodotto = {
        id : id,
        nome : n,
        categoria : c,
        prezzo : p,
        giacenza : g
    }
    console.log(prodotto);
    fetch(`http://localhost:9004/api/prodotti/modifica`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(prodotto)
    }).then(() => getData());
}

document.getElementById("categorie").addEventListener("change", function() {
    const categoria = this.value;
    if (categoria !== "-- Seleziona una Categoria --") {
        getProdottiByCategoria(categoria);
    }
});

getData();

