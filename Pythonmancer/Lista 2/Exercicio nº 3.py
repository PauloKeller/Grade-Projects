p=float(input("Digite o peso dos peixes: "))
multa=4.00
peso=p-50
if p > 50:
    print("Você foi multado!")
    print("Valor da multa:R$%.2f" %(peso*multa))
    print("Peso excedido %.2f" %(peso))
else:
    multa=0
    peso=0
    print("Voce não foi multado!")
    print("Valor da Multa:R$%.2f" %(multa))
    print("Peso excedido %.2f" %(peso))
          
