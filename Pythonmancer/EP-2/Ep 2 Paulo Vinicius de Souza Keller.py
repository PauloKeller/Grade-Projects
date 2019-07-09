import urllib.request
import random
#Url do site e lista das palavras
Site= urllib.request.urlopen('http://www.ime.usp.br/~pf/dicios/br')
listapalavras = Site.read().decode('iso8859').split()
forca = [
'''   +-----+
   |     |
         |
         |
         |
         |
============
''',
'''   +-----+
   |     |
   O     |
         |
         |
         |
============
''',
'''   +-----+
   |     |
   O     |
   |     |
         |
         |
============
''',
'''   +-----+
   |     |
   O     |
   |\    |
         |
         |
============
''',
'''   +-----+
   |     |
   O     |
  /|\    |
         |
         |
============
''',
'''   +-----+
   |     |
   O     |
  /|\    |
  /      |
         |
============
''',
'''   +-----+
   |     |
   O     |
  /|\    |
  / \    |
         |
============
''']
a = ['á', 'â', 'ã','à']
i = ['í','ì']
e = ['é', 'ê', 'è']
o = ['ô','ó','ò','õ']
u = ['ú','ù']
c = ['ç']
global numero
global tentativas
global certas
global erradas
global palavrachave
tentativas = ''
certas = ''
erradas = ''
numero = ''
palavrachave = ''
erros = 0
traços = []
acentos = []
tela = ''
#Sorteia uma palavra aleatoria no dicionário
def sorteia():
    while True:
        #valida a palavra do dicionario
        aleatorio = random.randint(0,len(listapalavras))
        palavraselct = listapalavras[aleatorio]
        if len(palavraselct) < 5:
            continue
        else:
            break
    return palavraselct

palavrachave = sorteia()
tela = palavrachave
for x in palavrachave:
    acentos.append(x)
#Verifica se a palavra tem algum acento.
for x in range(len(acentos)):
    if acentos[x] in a:
        acentos[x] = 'a'
    if acentos[x] in e:
        acentos[x] = 'e'
    if acentos[x] in i:
        acentos[x] = 'i'
    if acentos[x] in o:
        acentos[x] = 'o'
    if acentos[x] in u:
        acentos[x] = 'u'
    if acentos[x] in c:
        acentos[x] = 'c'
palavrachave = ''.join(acentos)
for letra in palavrachave:
    traços.append('_')
#Mostra o desenho da forca
def desenha ():
    print(forca[erros])
    print('Certas:',certas)
    print('Erradas:',erradas)
    for x in traços:
        print(x,end = ' ')
desenha()

def valida(s):
    #Valida o palpite
    global numero
    global erradas
    global certas
    numero = str(s)
    s = str(s)
    #E uma letra?
    if not 'a' <= s <= 'z':
        return False
    #Apenas uma letra?
    elif len(s) != 1:
        return False
    #Já fui utilizada?
    elif s in certas or s in erradas:
        return False
    else:
        return True
    
def palpite(palpite):
    global erradas
    global certas
    global erros
    global tentativas
    global palavrachave
    #Palpite valido!
    if valida(palpite):
        tentativas = tentativas + palpite
        #Letra errada!
        if palpite not in palavrachave:
            erros += 1
            erradas = erradas + palpite
            if erros >= 6:
                print('GAME OVER!!!')
                print("Para reiniciar digite:again('sim')")
            else:
                print('Para um chute digite chute(tentativas)')
        #Letra Correta!
        else:
            for x in range(len(palavrachave)):
                if palpite in palavrachave[x]:
                    traços[x] = tela[x]
            certas = certas + palpite
            h = 0
            for j in palavrachave:
                if j in certas:
                    h += 1
            if h == len(palavrachave):
                print('Você ganhou!')
                print("Para reiniciar digite:again('sim')")
    #Palpite não Valido!
    else:
        print('Digite uma letra valida!')
        print("Exemplo:palpite('a')")
    desenha()
#Chuta uma aleatoria que nao foi tentada.
def chute (tentativas):
    aleatoria = ''
    alfabeto =['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'w', 'y', 'z']
    global erradas
    global certas
    #Verifica se a letra ja foi tentada
    while True:
        aleatoria = random.choice(alfabeto)
        if aleatoria in tentativas:
            continue
        else:
            return aleatoria
#Função para reiniciar o jogo
def again (simnao):
    simnao = simnao.lower()
    global tentativas
    global certas
    global erradas
    global palavrachave
    global traços
    global erros
    global tela
    #Se sim reinicia o jogo
    if simnao == 'sim':
        tela = ''
        traços = []
        palavrachave = sorteia()
        tela = palavrachave
        for letra in palavrachave:
            traços.append('_')
        certas = ''
        erradas = ''
        erros = 0
        desenha()
    #Se não continua o jogo normal
    else:
        return desenha()
#Função para quando ganhar o jogo 
def win ():
    global certas
    global palavrachave
    k = 0
    for x in palavrachave:
        if x in certas:
            k += 1
    if k == len(palavrachave):
        return True
    else:
        return False
            
            
    
  
        
       
    
        
    
    

    
    












                            
