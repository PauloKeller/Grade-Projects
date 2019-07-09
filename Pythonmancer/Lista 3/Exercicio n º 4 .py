n = int(input("Digite um valor: "))
a = 1
b = 1
c = 0
while c < n-2:
    a,b = b,a+b
    c += 1
print("O numero Fibonacci é:%d" %b)
