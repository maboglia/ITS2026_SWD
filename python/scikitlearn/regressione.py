from sklearn.linear_model import LinearRegression

# Superficie delle case (m²)
X = [[50], [70], [90], [110], [130]]

# Prezzo delle case (€)
y = [100000, 140000, 180000, 220000, 260000]

# Creazione e addestramento del modello
modello = LinearRegression()
modello.fit(X, y)

# Previsione del prezzo di una casa di 100 m²
prezzo = modello.predict([[100]])

print(prezzo)