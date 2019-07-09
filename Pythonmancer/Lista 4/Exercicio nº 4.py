import random

texto = "The Python Software Foundation and the global Python community welcome and encourage participation by everyone. Our community is based on mutual respect, tolerance, and encouragement, and we are working to help each other live up to these principles. We want our community to be more diverse: whoever you are, and whatever your background, we welcome you.".upper()

x = texto.split(" ")
l = len(x)
lista = []
k = 0

while k < len(x):

    if x[k].endswith("."):
       x[k] = x[k].replace(".","")
       
    k += 1

for y in range(l):

    if x[y].startswith("P") or x[y].startswith("Y") or x[y].startswith("T") or x[y].startswith("H") or x[y].startswith("O") or x[y].startswith("N"):
        lista.append(x[y])
print (lista)
    



