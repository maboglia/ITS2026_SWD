import torch
import torch.nn as nn
import torch.optim as optim
from torch.utils.data import Dataset, DataLoader


# ==================================================
# 1. DATASET PERSONALIZZATO
# ==================================================

class MyDataset(Dataset):

    def __init__(self):

        self.X = torch.tensor([
            [1.0, 1.0],
            [1.0, 2.0],
            [2.0, 1.0],
            [2.0, 2.0],

            [5.0, 5.0],
            [6.0, 5.0],
            [5.0, 6.0],
            [6.0, 6.0]
        ])

        self.y = torch.tensor([
            0,
            0,
            0,
            0,

            1,
            1,
            1,
            1
        ])

    def __len__(self):
        return len(self.X)

    def __getitem__(self, index):
        return self.X[index], self.y[index]


# ==================================================
# 2. CREAZIONE DEL DATASET
# ==================================================

dataset = MyDataset()

print("Numero di elementi:")
print(len(dataset))


# ==================================================
# 3. DATA LOADER
# ==================================================

loader = DataLoader(
    dataset,
    batch_size=4,
    shuffle=True
)


# ==================================================
# 4. MODELLO
# ==================================================

model = nn.Linear(2, 2)


# ==================================================
# 5. LOSS
# ==================================================

criterion = nn.CrossEntropyLoss()


# ==================================================
# 6. OTTIMIZZATORE
# ==================================================

optimizer = optim.SGD(
    model.parameters(),
    lr=0.05
)


# ==================================================
# 7. ADDESTRAMENTO
# ==================================================

for epoch in range(100):

    for X_batch, y_batch in loader:

        # -------------------------
        # Forward
        # -------------------------

        output = model(X_batch)

        # -------------------------
        # Loss
        # -------------------------

        loss = criterion(output, y_batch)

        # -------------------------
        # Azzera gradienti
        # -------------------------

        optimizer.zero_grad()

        # -------------------------
        # Backpropagation
        # -------------------------

        loss.backward()

        # -------------------------
        # Aggiornamento parametri
        # -------------------------

        optimizer.step()

    if (epoch + 1) % 10 == 0:
        print(
            f"Epoca {epoch + 1}, "
            f"Loss: {loss.item():.4f}"
        )


# ==================================================
# 8. TEST
# ==================================================

test = torch.tensor([
    [1.5, 1.5],
    [5.5, 5.5],
    [2.0, 1.0],
    [6.0, 6.0]
])


output = model(test)

predictions = torch.argmax(
    output,
    dim=1
)


print("\nPredizioni:")
print(predictions)