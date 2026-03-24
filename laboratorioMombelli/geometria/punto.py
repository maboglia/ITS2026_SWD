''' Classe punto, rappresenta un punto sul piano cartesiano. '''

class Punto:


    def __init__(self, x: int, y: int): # double under methods
        self.x = x # self indica che mi riferisco alla x di questo oggetto punto, 
        # e gli assegno il valore che gli passo nel momento che inizializzo un oggetto
        self.y = y
    
    def __str__(self):
        return f'({self.x}, {self.y})'