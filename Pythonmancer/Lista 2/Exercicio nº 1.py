l1=int(input("Lado do triângulo: "))
l2=int(input("Lado do triângulo: "))
l3=int(input("Lado do triângulo: "))
if l1>l2+l3 or l2>l1+l3 or l3>l1+l2:
    print("Não é um triângulo")
    print("Um lado é mairo que a soma dos outros 2")
elif l1==l2==l3:
    print("Seu triângulo é Equilátero!")
elif l1==l2 or l2==l3  or l1==l3:
    print("Seu triângulo é Isósceles!")
else:
    print("Seu triângulo é Escaleno!")
