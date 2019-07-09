a = int(input("Digite o ano: "))
if a%4==0:
    if (a%100!=0 or a%400==0):
            print("O ano é bissexto!")
else:
    print("O ano não é bissexto!")
