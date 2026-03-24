from punto import Punto
from segmento import Segmento
from triangolo import Triangolo

A = Punto(2,2)
B = Punto(6,2)
C = Punto(2,5)

print(A)
print(B)
print(C)

AB = Segmento(A, B)
AC = Segmento(A, C)
BC = Segmento(B, C)

t = Triangolo(A, B, C)


print(AB)
print(AC)
print(BC)

print(t.perimetro())

print(t)
