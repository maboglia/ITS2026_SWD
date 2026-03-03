let game = {
    nome : 'Minecraft Java Edition',
    platform : 'pc',
    publisher : 'Mojang',
    year : 2011
};

let game_json  = JSON.stringify(game);

console.log(game);
console.log(game_json);

let game2 = JSON.parse(game_json);

console.log(game2);