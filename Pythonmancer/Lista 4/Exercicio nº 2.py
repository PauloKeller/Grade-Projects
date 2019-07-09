import random
impar = []
par = []
lista = []

for x in range(20):

    lista.append(random.randint(1,100))
    if lista [x] % 2 == 0:

        par.append(lista[x])

    else:
        impar.append(lista[x])

print(impar)
print(par)
print(lista)
