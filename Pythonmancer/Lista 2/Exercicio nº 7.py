tamanho = int(input("Digite a area a ser pintada: "))
latas = int(tamanho/54)
if tamanho % 54 > 0:
    latas = latas + 1
preço= latas * 80
print("Total a pagar R$%.2f número de latas %d" %(preço, latas))

     
