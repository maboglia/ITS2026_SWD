import pandas as pd

film = pd.read_json("film.json")

print(film[["title", "year"]][100:110])