""" Libreria pitonica """

libri = []

with open('libri.csv', 'r') as f:
    for riga in f:
        riga = riga.replace('\n', '')
        riga = riga.replace('\"', '')
        titolo, autore, editore = riga.split(',')
        # titolo = parole[0]
        # autore = parole[1]
        # editore = parole[2]
        libri.append([titolo, autore, editore])

with open('libreria.html', 'w') as f:
    f.write('<html>\n')
    f.write('<head>\n')
    f.write('<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">')
    f.write('</head>\n')
    
    f.write('<body><div class="container">\n')
    f.write('<table>\n')

    for i, libro in enumerate(libri):

        f.write('<tr>')
        if i == 0:
            f.write('<th>')
            f.write(libro[0])
            f.write('</th>')

            f.write('<th>')
            f.write(libro[1])
            f.write('</th>')

            f.write('<th>')
            f.write(libro[2])
            f.write('</th>')
        else:
            f.write('<td>')
            f.write(libro[0])
            f.write('</td>')

            f.write('<td>')
            f.write(libro[1])
            f.write('</td>')

            f.write('<td>')
            f.write(libro[2])
            f.write('</td>')            

        f.write('</tr>\n')

    f.write('</table>\n')
    f.write('</div></body>\n')

    f.write('</html>\n')
