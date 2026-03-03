import json

game = {
    "nome" : 'Minecraft Java Edition',
    "platform" : 'PC',
    "publisher": 'Mojang Studios',
    "year" : 2011
}

game_json = json.dumps(game)

print(game_json)

with open('game.json',encoding= 'utf-8', mode='w') as f:
    json.dump(game_json, f, indent=4)

with open('game.json', encoding='utf-8', mode='r') as f:
    object = json.load(f)

print(object)