import random
numero=[]
for x in range(10):
    numero.append(random.randint(1,100))
maior = menor = numero[0]
for k in range(1,10):
    if numero[k] < menor:
        menor = numero[k]
    if numero[k] > maior:
        maior = numero [k]
print('menor', menor)
print('maior', maior)
print("lista", numero)
    
