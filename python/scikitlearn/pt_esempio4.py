import torch
import torch.nn as nn
import torch.optim as optim


# -------------------------
# 1. DATI
# -------------------------

X = torch.tensor([
    [1.0, 1.0],
    [1.0, 2.0],
    [2.0, 1.0],
    [2.0, 2.0],

    [5.0, 5.0],
    [6.0, 5.0],
    [5.0, 6.0],
    [6.0, 6.0]
])

# Classe di appartenenza
y = torch.tensor([
    0,
    0,
    0,
    0,

    1,
    1,
    1,
    1
])


# -------------------------
# 2. MODELLO
# -------------------------

model = nn.Linear(2, 2)


# -------------------------
# 3. FUNZIONE DI LOSS
# -------------------------

criterion = nn.CrossEntropyLoss()


# -------------------------
# 4. OTTIMIZZATORE
# -------------------------

optimizer = optim.SGD(
    model.parameters(),
    lr=0.05
)


# -------------------------
# 5. ADDESTRAMENTO
# -------------------------

for epoch in range(1000):

    # Forward
    output = model(X)

    # Loss
    loss = criterion(output, y)

    # Azzera i gradienti
    optimizer.zero_grad()

    # Calcola i gradienti
    loss.backward()

    # Aggiorna i pesi
    optimizer.step()

    if (epoch + 1) % 100 == 0:
        print(
            f"Epoca {epoch + 1}, "
            f"Loss: {loss.item():.4f}"
        )


# -------------------------
# 6. TEST
# -------------------------

test = torch.tensor([
    [1.5, 1.5],
    [5.5, 5.5],
    [2.0, 1.0],
    [6.0, 6.0]
])

output = model(test)

# Trova la classe con il valore maggiore
predictions = torch.argmax(output, dim=1)

print("\nPredizioni:")
print(predictions)