import requests
import json

response = requests.get("https://www.bogliaccino.it/api/public/film.php?type=top250_imdb")

with open("film.json", "w", encoding="utf-8") as file:
    json.dump(response.json(), file, indent=4)
