a = 80000
b = 200000
ano = 0
while a <= b:
    a += (a * 0.03)
    b += (b * 0.015)
    ano += 1
print("Total de anos:%.d" %ano)
