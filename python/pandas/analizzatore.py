import pandas as pd
import sqlite3

connessione = sqlite3.connect("auto_modificato.db")

df = pd.read_csv("auto.csv")
df_moto = pd.read_csv("moto.csv")

print(df.head())
print(df.tail(3))
print(df.columns)
print(df[["Marca", "Modello"]])

df = pd.concat([df, df_moto], ignore_index=True)

print(df.groupby("Marca")["Marca"].count())


# df = df[["Marca", "Modello"]]

# df.to_csv("auto_modificato.csv", index=False)

# df.to_json("auto_modificato.json", orient="records", lines=True)

# df.to_excel("auto_modificato.xlsx", index=False)

# df.to_html("auto_modificato.html", index=False)



# df.to_sql("auto_modificato.db", index=False, if_exists="replace", con=connessione)