a=int(input("Digite um número: "))
b=int(input("Digite um número: "))
d = a/b
r = a%b
while True:
    if r > 0:
        a,b = b,r
        d = a/b
        r = a%b
    else:
        print("O máximo divisor comum é %d." %d)
        break
        
        
