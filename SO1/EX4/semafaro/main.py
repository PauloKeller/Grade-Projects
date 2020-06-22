from threading import Thread,Semaphore
import time

s = Semaphore()

def regiaoCritica():
    time.sleep(1)

numeros = [1,2,3,4,5,6,7,8,9,10]

def verifica_primo():
  for numero in numeros:
    if (numero == 0 or numero % 2 == 0):
      print("é primo")

def verifica_par():
  for numero in numeros:
    if (numero % 2 == 0):
      print("é par")

def processamentoA(times, delay):
    for x in range(times):
        print ("Secao de Entrada A - ",x+1)        
        s.acquire()
        print ("Regiao Critica A") 
        verifica_par()       
        regiaoCritica()
        print ("Secao de Saida A")
        s.release()
        print ("Regiao nao critica A\n")
        time.sleep(delay)    

def processamentoB(times, delay):
    for x in range(times):
        print ("Secao de Entrada B - ",x+1)
        s.acquire()
        print ("Regiao Critica B")  
        verifica_primo()      
        regiaoCritica()
        print ("Secao de Saida B")
        s.release()
        print ("Regiao nao critica B\n")
        time.sleep(delay)


print ("Exemplo de Semafaro")
execTimes = 5

#no processamento você pode passar quantas vezes que a exec e
#qual o tempo de delay para simular o efeito comboi
tA = Thread(target=processamentoA, args=(execTimes,1,))
tA.start()
tB = Thread(target=processamentoB, args=(execTimes,5,))
tB.start()