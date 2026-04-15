import csv

with open('studenti.csv', 'r') as file:
    reader = csv.reader(file)
    studenti = list(reader)  # è un tipo di contenitore di dati 

print(type(studenti)) # <class 'list'> 


for studente in studenti:
    print(type(studente))