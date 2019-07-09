import random

lista1 = []
lista2 = []
lista3 = []

for x in range(10):

    lista1.append(random.randint(1,100))
    lista2.append(random.randint(1,100))
    lista3.append(lista1[x])
    lista3.append(lista2[x])
print("Primeiro vetor: ",lista1)
print("Segundo vetor: ",lista2)
print("Os dois juntos: ",lista3)


    
