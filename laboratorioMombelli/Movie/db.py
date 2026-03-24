import requests



class DB:
    def getMovies(self):
        response = requests.get("https://raw.githubusercontent.com/maboglia/ProgrammingResources/refs/heads/master/tabelle/film/imdb_top_2000_movies.json") # utilizziamo un API fatta da qualcun altro
        # potevo usare anche gli altri metodi oltre get, quindi post, put, delete, patch
        if response.status_code == 200: # codice di stato 200 indica successo, mentre il not found 404 indica che la risorsa non è stata trovata
            return response.json() # converte il json trovato al link in una lista di dizionari 
        # il json si presenta come una stringa ma è un oggetto
        else:
            print("Error fetching movies:", response.status_code)
            return []
