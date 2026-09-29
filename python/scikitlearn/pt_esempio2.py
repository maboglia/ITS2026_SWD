import torch

# Creiamo un tensore che deve essere seguito da autograd
x = torch.tensor(2.0, requires_grad=True)

# Operazione
y = x ** 2

print("x =", x)
print("y =", y)

# Calcolo automatico del gradiente
y.backward()

# Visualizzazione del gradiente
print("Gradiente di y rispetto a x:")
print(x.grad)