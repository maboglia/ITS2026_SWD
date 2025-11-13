const URL = 'https://raw.githubusercontent.com/maboglia/ProgrammingResources/refs/heads/master/tabelle/film/top-100-super-hero-films-rt.json'

fetch(URL)
    .then(filmJson => filmJson.json())
    .then(filmJs => {

        for(film of filmJs){
            console.log(film);
            
            const LI = document.createElement('li')
            LI.textContent = film.titolo
            document.getElementById('lista').append(LI)

        }


    })

