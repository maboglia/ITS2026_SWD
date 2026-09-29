import torch
import torch.nn as nn
import torch.optim as optim

# -------------------------
# 1. DATI
# -------------------------

x = torch.tensor([
    [1.0],
    [2.0],
    [3.0],
    [4.0],
    [5.0]
])

y = torch.tensor([
    [2.0],
    [4.0],
    [6.0],
    [8.0],
    [10.0]
])


# -------------------------
# 2. MODELLO
# -------------------------

model = nn.Linear(1, 1)


# -------------------------
# 3. FUNZIONE DI LOSS
# -------------------------

criterion = nn.MSELoss()


# -------------------------
# 4. OTTIMIZZATORE
# -------------------------

optimizer = optim.SGD(
    model.parameters(),
    lr=0.01
)


# -------------------------
# 5. ADDESTRAMENTO
# -------------------------

for epoch in range(3000):

    # Forward pass
    prediction = model(x)

    # Calcolo dell'errore
    loss = criterion(prediction, y)

    # Azzera i gradienti precedenti
    optimizer.zero_grad()

    # Calcola i nuovi gradienti
    loss.backward()

    # Aggiorna i parametri
    optimizer.step()

    # Mostra l'errore ogni 100 epoche
    if (epoch + 1) % 100 == 0:
        print(
            f"Epoca {epoch + 1}, "
            f"Loss: {loss.item():.6f}"
        )


# -------------------------
# 6. TEST DEL MODELLO
# -------------------------

test = torch.tensor([[6.0]])

prediction = model(test)

print("\nPredizione per x = 6:")
print(prediction.item())


# -------------------------
# 7. PARAMETRI IMPARATI
# -------------------------

print("\nPeso imparato:")
print(model.weight.item())

print("\nBias imparato:")
print(model.bias.item())