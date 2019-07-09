loop = 1
while loop == 1:
    nome = input("Digite um nome: ")
    senha = input("Digite uma senha: ")
    if nome == senha:
        print("Digite uma senha diferente do nome!")
    else:
        print("Senha confirmada!")
        loop = 2
