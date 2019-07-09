produto = float(input("Preço do produto: "))
desconto = float(input("Desconto: "))
produto_desconto = produto * desconto / 100
total_pagar = produto - produto_desconto
print("Preço:R$ %2.f" %total_pagar)
print("Desconto:R$ %2.f" %produto_desconto)
