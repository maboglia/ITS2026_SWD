from sklearn.tree import DecisionTreeClassifier 

# Dati: [lunghezza petalo, larghezza petalo] 
X = [[1.4, 0.2], [1.5, 0.2], [4.5, 1.5], [4.7, 1.4]] 

# Classe del fiore 
 
y = ["setosa", "setosa", "versicolor", "versicolor"] 

# Creazione e addestramento del modello 

modello = DecisionTreeClassifier() 
modello.fit(X, y) 


# Nuovo fiore da classificare 

print(modello.predict([[1.6, 0.3]]))