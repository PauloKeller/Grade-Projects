import random

texto = "The Python Software Foundation and the global Python community welcome and encourage participation by everyone. Our community is based on mutual respect, tolerance, and encouragement, and we are working to help each other live up to these principles. We want our community to be more diverse: whoever you are, and whatever your background, we welcome you.".lower()

x = texto.split(" ")
l = len(x)
lista = []
k = 0

while k < len(x):

    if x[k].endswith("."):
       x[k] = x[k].replace(".","")
       
    k += 1

for y in range(l):


    if x[y].startswith("p") or x[y].startswith("y") or x[y].startswith("t") or x[y].startswith("h") or x[y].startswith("o") or x[y].startswith("n"):
          
        if len(x[y]) > 4:
               lista.append(x[y])
print (lista)
    
