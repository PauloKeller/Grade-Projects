salario_hora=float(input("Digite quanto você ganha por hora:R$ "))
hora=int(input("Digite o número de horas: "))
salario_mes=salario_hora*hora

print ("Salário desse mês:R$%.2f" %salario_mes)

imposto_renda = salario_mes * 0.11

print("Imposto de renda:R$%.2f" %imposto_renda)

inss = salario_mes * 0.08

print("INSS:R$%.2f" %inss)

sindicato = salario_mes * 0.05

print("Sindicato:R$%.2f" %sindicato)

liquido = salario_mes - imposto_renda -inss - sindicato

print("Salrio liquido:R$%.2f" %liquido)





