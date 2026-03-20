# sarebbe il DAO, e dovrebbe accedere al db
from db import DB
from movie import Movie

class MovieRepo:
    def __init__(self):
        self.movies = [] # è il contenitore
        self.database = DB()

    def add_movie(self, movie):
        self.movies.append(movie)

    def get_all_movies(self):
        for movie_data in self.database.getMovies():
            movie = Movie(
                title=movie_data.get("Movie Name"),
                director=movie_data.get("Director"),
                year=movie_data.get("Release Year"),
                genre=movie_data.get("Genre"),
                raiting=movie_data.get("IMDB Rating")
            )
            # poco ottimizzato perché ogni volta svuoto tutto il contenitore
            # e lo riempo con i nuovi dati ma mettendo anche quelli vecchi
            self.add_movie(movie)
        return self.movies
    
    def reset_movies(self):
        self.movies.clear() # svuota la lista dei film
        # prima di aggiungere quelli nuovi, in modo da evitare duplicati

'''
  {
    "Movie Name": "The Godfather",
    "Release Year": "1972",
    "Duration": "175",
    "IMDB Rating": "9.2",
    "Metascore": "100.0",
    "Votes": "2,002,655",
    "Genre": "Crime, Drama",
    "Director": "Francis Ford Coppola",
    "Cast": "Marlon Brando",
    "Gross": "$134.97M"
  }
'''