let game = {
    nome : 'Minecraft Java Edition',
    platform : 'PC',
    publisher: 'Mojang Studios',
    year : 2011
};

let gameJSON = JSON.stringify(game); // converte l'oggetto in una stringa JSON
console.log(game);
console.log(gameJSON); 

let game2 = JSON.parse(gameJSON); // converte la stringa JSON in un oggetto JavaScript
console.log(game2);