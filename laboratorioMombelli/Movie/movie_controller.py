# pip install flask ==> gestisce il server, le richieste
from flask import Flask, jsonify, render_template
from movie_repo import MovieRepo


app = Flask(__name__) # dunder propoerty -- sarà eseguito il file corrente
# praticamente si differenzia tra eseguire qualcosa dirrettamente
# dove l'ho scritta o importarla da un altro file
@app.route('/')
def home():
    return "Welcome to the Movie API!"

@app.route('/movies')
def movies():
    return render_template('movies.html', pagetitle="Movies", movies=MovieRepo().get_all_movies())



app.run(debug=True)

