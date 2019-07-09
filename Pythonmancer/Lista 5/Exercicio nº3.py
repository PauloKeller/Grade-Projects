import random
lista = []
for x in range(1067,3628):
    if x%2 == 0 and x%7 == 0:
        lista.append(x)
print(lista)
print(len(lista))
