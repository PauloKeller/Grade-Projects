import csv
import pymongo
import sys
import threading
import re
import time

def mongodb_conn():
    try:
        client = pymongo.MongoClient("mongodb://localhost:27017/")
        database = client['BNMP']
        collection = database['mandados-sp']
        return collection
    except pymongo.errors.ConnectionFailure as e:
        print("Could not connect to server: %s" % e)
        logfile.write("%s\n" % e)


collection = mongodb_conn()
logfile = open('database_log.txt', 'w')

mandado_dict = {
    "numero_mandado": None,
    "numero_processo": None,
    "situacao": None,
    "data": None,
    "validade": None,
    "boletim_ocorrencias": None,
    "classe": None,
    "magistrado": None, #?
    "assuntos": None, #?
    "orgao_expedidor": None, #magistrado
    "municipio": None, #orgao_expedidor
    "nome": None, #?
    "sexo": None, # municipio
    "documentos": None, #nome
    "pai": None, #documentos
    "mae": None, #sexo
    "nacionalidade": None, #pai
    "naturalidade": None, #mae
    "data_nascimento": None, #naturalidades
    "enderecos": None, #data_nascimento
    "data_delitos": None, #?
    "profissoes": None, #enderecos
    "motivo": None, #enderecos
    "recaptura": None, #?
    "sintese": None, #pena
    "pena": None,
    "regime": None,
}

numero_mandado = ""
mandados_list = []

def save_mandado(mandado):
    try:      
        collection.insert_one(mandado)
    except pymongo.errors.PyMongoError as e:
        print(e)
        print("fail to save: ", mandado["numero_mandado"])
        logfile.write("fail to save: %s\n" % mandado["numero_mandado"])


def read_file(file):
    with open(file, 'r', encoding='UTF-8') as csvfile:
        spamreader = csv.reader(csvfile, quotechar = '|')
        mandados = 0
        for mandado in spamreader:
            concat(mandado)
            print("---------------------MANDADO---------------------", mandados)
            mandados += 1
            
def concat(mandado):
    index = 0
    new_mandado = []
    for item in mandado:
        if item is not "" and item is not "v a z i o":
            has_assuntos = False
            item = item.lower()
            if item == "sim" or item == "não" and not has_assuntos:
                has_assuntos = True
                new_index = index + 1
                assuntos = mandado[new_index]
                while new_index < len(mandado):
                    if mandado[new_index] is not "":
                        string = mandado[new_index] 
                        assuntos = string + assuntos
                        if "..." in assuntos:
                            new_mandado.append(assuntos.lower())
                            index = new_index + 1
                            break
                    new_index += 1
            new_mandado.append(item.lower())
        index += 1
    return clear_mandado(new_mandado)


def clear_mandado(mandado):
    index = 0 
    new_mandado = []
    string = ""
    for value in mandado:
        if index > 22: 
            if len(value) > 12:
                string += value
            else:
                new_mandado.append(mandado[index])
        else:
            if index > 22:
                new_mandado.append(mandado[index]) 
            new_mandado.append(mandado[index])
        index += 1
    new_mandado.append(string)
    clear_mandado_wrong_index(new_mandado)
    return new_mandado

def clear_mandado_wrong_index(mandado):
    index = 0 
    string = ""
    for item in mandado:
        if index == 10:
            if index+1 < len (mandado):
                string = item + mandado[index+1]
                mandado.pop(index+1)
                mandado[index] = ""
                mandado[index] = (string)
        index += 1
    first_view(mandado)

def pena(string):
    index = 0 
    for s in string:
        if " " not in s:
            index += 1
            if index > 20:
                return string


def first_view(mandado):
    index = 0
    for item in mandado:
        if index == 0:
            mandado_dict["numero_mandado"] = item
        if index == 1:
            mandado_dict["numero_processo"] = item
        if index == 2:
            mandado_dict["situacao"] = item
        if index == 3:
            mandado_dict["data"] = item
        if index == 4:
            mandado_dict["validade"] = item
        if index == 5:
            mandado_dict["boletim_ocorrencias"] = item
        if index == 6:
            mandado_dict["classe"] = item
        if index == 7:
            mandado_dict["motivo"] = item
        if index == 8:
            mandado_dict["assuntos"] = item
        if index == 9:
            mandado_dict["magistrado"] = item
        if index == 10:
            mandado_dict["orgao_expedidor"] = item
        if index == 11:
            mandado_dict["municipio"] = item
        if index == 12:
            mandado_dict["nome"] = item
        if index == 13:
            mandado_dict["documentos"] = item
        if index == 14:
            mandado_dict["sexo"] = item
        if index == 15:
            mandado_dict["pai"] = item
        if index == 16:
            mandado_dict["mae"] = item
        if index == 17:
            mandado_dict["naturalidade"] = item
        if index == 18:
            mandado_dict["data_nascimento"] = item
        if index == 19:
            mandado_dict["profissoes"] = item
        if index == 20:
            mandado_dict["enderecos"] = item
        if index == 21:
            if "/" in item:
                if len(item) > 6 and len(item) < 12:
                    mandado_dict["data_delitos"] = item
                else:
                    mandado_dict["enderecos"] += item
            else:
                if len(item) > 9 and len(item) < 15:
                    mandado_dict["sintese"] = item
        if index == 22:
            if len(item) > 3:
                mandado_dict["sintese"] = item
            else:
                mandado_dict["recaptura"] = item
        if index == 23:
            if len(item) < 4:
                mandado_dict["recaptura"] = item
            if "preventiva" in item or "definitiva" in item:
                mandado_dict["sintese"] = item
            else:
                if "fechado" in item or "aberto" in item:
                    mandado_dict["regime"] = item
        if index == 24:
            if len(item) < 4:
                mandado_dict["recaptura"] = item
            else:
                if "fechado" in item or "aberto" in item:
                    mandado_dict["regime"] = item
                if len(item) > 7 :
                    if '"' in item:
                        item
            if len(item) > 10:
                mandado_dict["pena"] = pena(item)
        if index == 25:
            mandado_dict["pena"] = pena(item)
        if index == 26:
            mandado_dict["pena"] = pena(item)
        if index == 27:
            mandado_dict["pena"] = pena(item)
        if index == 28:
            mandado_dict["pena"] = pena(item)
        if index == 29:
            mandado_dict["pena"] = pena(item)
        index += 1 
    remove_null(mandado_dict)
    return mandado_dict

def remove_null(mandado):
    for key, val in mandado.items():
        if val != None:
            if "vazio" in val or "v/a/z/i/o" in val or "v a z i o" in val:
                mandado[key] = None
    save_mandado(mandado_dict.copy())
        
        
file = './.csv/mandados_SP.csv'    
read_file(file)





