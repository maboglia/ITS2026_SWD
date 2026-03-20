class Movie:
    def __init__(self, title, director, year, genre, raiting):
        self.title = title
        self.director = director
        self.year = year
        self.genre = genre
        self.raiting = raiting

    def __str__(self):
        return f"{self.title} ({self.year}), directed by {self.director}, Genre: {self.genre}, Raiting: {self.raiting}"
    
    def __repr__(self):
        return self.__str__()