import pandas as pd
import sqlite3

connessione = sqlite3.connect("auto_modificato.db")

df = pd.read_csv("auto.csv")

print(df.head())
print(df.tail(3))
print(df.columns)
print(df[["Marca", "Modello"]])

df = df[["Marca", "Modello"]]

df.to_csv("auto_modificato.csv", index=False)

df.to_json("auto_modificato.json", orient="records", lines=True)

df.to_excel("auto_modificato.xlsx", index=False)

df.to_html("auto_modificato.html", index=False)



df.to_sql("auto_modificato.db", index=False, if_exists="replace", con=connessione)