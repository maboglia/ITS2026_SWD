from sklearn.cluster import KMeans

# Dati: [spesa annuale, numero di acquisti]
X = [
    [100, 2],
    [120, 3],
    [150, 2],
    [800, 15],
    [850, 17],
    [900, 16]
]

# Creazione del modello
modello = KMeans(n_clusters=2, random_state=42)

# Addestramento
modello.fit(X)

# Gruppo assegnato a ciascun cliente
print(modello.labels_)

#  Possiamo anche chiedere a sklearn dove si trovano i "centri" dei due gruppi:
print(modello.cluster_centers_)

#I due valori rappresentano i centroidi: il "cliente medio" di ciascun gruppo.
# [[123.33333333   2.33333333]
#  [850.          16.        ]]