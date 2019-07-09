c = int(input("Cigarros por dia: "))
a = int(input("Anos que fumou: "))
cigarros_fumados = 365 * a * c
tempo_perdido = cigarros_fumados / 144
print ("Você perdeu %.2f dias de vida" %tempo_perdido)
