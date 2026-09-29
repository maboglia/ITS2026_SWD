import torch

# Creazione di un tensore
x = torch.tensor([1, 2, 3, 4, 5])

print("Tensore:")
print(x)

# Tipo di dato
print("\nTipo:")
print(x.dtype)

# Dimensione
print("\nDimensione:")
print(x.shape)

# Numero di elementi
print("\nNumero di elementi:")
print(x.numel())

# Operazioni matematiche
print("\nSomma:")
print(x.sum())

print("\nMedia:")
print(x.float().mean())

print("\nMoltiplicazione per 2:")
print(x * 2)

print("\nQuadrato:")
print(x ** 2)


# tensore 2D: matrice

m = torch.tensor([
    [1, 2, 3],
    [4, 5, 6]
])

print(m)

print("Shape:", m.shape)

print("Prima riga:", m[0])

print("Seconda colonna:", m[:, 1])