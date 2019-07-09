import random
lista = []
for x in range(18644,33088):
    if '2' in str(x) and '7' not in str(x):
        lista.append(x)
print(lista)
print(len(lista))
