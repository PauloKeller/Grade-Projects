a=int(input("Digite um numero: "))
b=int(input("Digite um numero: "))
c=int(input("Digite um numero: "))

if a>b and a>c:
    print("O maior é:%d" %a)
if b>a and b>=c:
    print("O maior é:%d" %b)
else:
    print("O maior é:%d" %c)
if a<b and a<c:
    print("O menor é:%d" %a)
elif b<a and b<=c:
    print("O menor é:%d" %b)
else:
    print("O menor é:%d" %c)
    
