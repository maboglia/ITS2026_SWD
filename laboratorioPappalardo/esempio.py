import json

game = {
    'nome' : 'Minecraft Java Edition',
    'platform' : 'pc',
    'publisher' : 'Mojang',
    'year' : 2011
}

game_json = json.dumps(game)

print(game_json)

with open('game.json', 'w', encoding='utf-8') as f :
    json.dump(game_json, f, indent=4)


with open('game.json', 'r') as f:
    oggetto = json.load(f)
    print(type(oggetto))