import requests
import time
import json
import csv


cabeçalho = {
    'Host': 'www.cnj.jus.br',
    'Connection': 'keep-alive',
    'Content-Length': '213',
    'Accept': 'application/json, text/plain, */*',
    'Origin': 'http://www.cnj.jus.br',
    'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36',
    'Content-Type': 'application/json;charset=UTF-8',
    'Referer': 'http://www.cnj.jus.br/bnmp/',
    'Accept-Encoding': 'gzip, deflate',
    'Accept-Language': 'pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6'
}


def faz_req(url, payload, headers):
    requests.adapters.DEFAULT_RETRIES = 100
    while True:
        try:
            p = requests.post(url, data = payload, headers = headers)
            return p.text #return significa que vou devolver o que está depois para quem chamou// no faz_req, há 3 chamadas: pág, mandados, detalhe. pra cada um, devolvo o texto que o servidor do cnj me devolveu. nele, consigo pegar e transformar num dicionário e, sabendo os campos, pegar a info que eu quero
        except:
            print ('Conexão caiu')
            time.sleep(10)


pesquisa = 'http://www.cnj.jus.br/bnmp/rest/pesquisar'
detalhes = 'http://www.cnj.jus.br/bnmp/rest/detalhar'


def bnmp(UF):
    # monta o cabeçalho do CSV
    f = open('mandados_%s.csv' % UF, 'a', encoding='UTF-8', newline="")
    w = csv.writer(f)
    rotulos = '''num_mandado situacao data validade num_processo classe boletim_ocorrencias assuntos
                 magistrado orgao_expedidor municipio nomes sexos documentos
                 pais maes nacionalidades
                 naturalidades dt_nascimentos enderecos data_delitos profissoes enderecos motivo recaptura
                 sintese pena regime'''.split()  # é o cabeçalho do csv
    w.writerow(rotulos)
    f.close()

    payload_ini = '''{"criterio":{"orgaoJulgador":{"uf":"%s",
        "municipio":"","descricao":""},"orgaoJTR":{},
        "parte":{"documentos":[{"identificacao":null}]}},
        "paginador":{},"fonetica":"true","ordenacao":{"porNome":false,"porData":false}}''' % UF

    print('Baixando %s' % UF)
    resp = faz_req(pesquisa, payload_ini, cabeçalho)
    dic = json.loads(resp)
    n_paginas = dic['paginador']['totalPaginas']
    print(n_paginas)

    for k in range(1, n_paginas + 1):
        print('Página', k)
        f = open('mandados_%s.csv' % UF, 'a', encoding='UTF-8', newline="")
        w = csv.writer(f)
        s = open('sem_permisso_%s.txt' % UF, 'a')
        payload_pag = '''{"criterio":{"orgaoJulgador":{"uf":"%s",
            "municipio":"","descricao":""},"orgaoJTR":{},
            "parte":{"documentos":[{"identificacao":null}]}},
            "paginador":{"paginaAtual":"%d"},"fonetica":"true","ordenacao":{"porNome":false,"porData":false}}''' % (
        UF, k)

        # o que vem abaixo, diz respeito à "url" no network de *detalhes*
        resp = faz_req(pesquisa, payload_pag, cabeçalho)
        if resp == None: continue
        dic = json.loads(resp)
        mandados = dic['mandados']
        if mandados == None: continue
        cabeçalho['Content-Lenght'] = '13'
        # para o detalhamento o tamanho é só para enviar o id
        for m in mandados:
            payload_d = '{"id": %d}' % m['id']
            resp = faz_req(detalhes, payload_d, cabeçalho)
            dic = json.loads(resp)

            if dic['sucesso'] == False:  # sem permissão
                print('Sem permissão', m['id'])
                s.write(str(m['id']) + '\n')
                continue  # significa "volte pro começo pra pegar o próximo"
            campos = dic['mandado']
            for x in campos:
                if campos[x] == None:  # None significa vazio
                    campos[x] = 'vazio'
                if type(campos[x]) is list:
                    for z in range(len(campos[x])):
                        if campos[x][z] == None:
                            campos[x][z] = 'vazio'
            ident = str(m['id'])
            num_mandado = campos['numero']
            situacao = campos['situacao']
            data = campos['data']
            validade = campos['validade']
            num_processo = campos["processo"]
            classe = campos["classe"]
            boletim_ocorrencias = '/'.join(campos["procedimentos"])
            assuntos = '/'.join(campos['assuntos'])  # podem ser vários assuntos. preciso montar uma string com todos juntos. uso / qd tem espaço no meio
            magistrado = campos["magistrado"]
            orgao_expedidor = campos["orgao"]
            municipio = campos["municipio"]
            nomes = '/'.join(campos["nomes"])
            documentos = "|".join(campos["documentos"])
            sexos = ' '.join(campos['sexos'])
            pais = ' '.join(campos['genitores'])
            maes = ' '.join(campos['genitoras'])
            nacionalidades = ' '.join(campos['naturalidades'])
            dt_nascimentos = ' '.join(campos['datasNascimentos'])
            profissoes = ' '.join(campos['profissoes'])
            enderecos = '/'.join(campos['enderecos'])
            data_delitos = campos["dataDelito"]
            motivo = campos['motivo']
            recaptura = campos['recaptura']
            sintese = campos['sintese']
            pena = campos['pena']
            regime = campos['regime']

            row = [ident, num_mandado, situacao, data, validade, num_processo, classe, boletim_ocorrencias,
                   assuntos, magistrado, orgao_expedidor, municipio, nomes, documentos, sexos, pais, maes,
                   nacionalidades,
                   dt_nascimentos, profissoes, enderecos, data_delitos, motivo,
                   recaptura, sintese, pena, regime]
            w.writerow(row)
        f.close()
        s.close()
        # agora que pegou os detalhes, volta para o cabeçalho geral
        cabeçalho['Content-Lenght'] = '213'


ufs = '''SP SE TO'''.split()
# ufs = '''AC AL AP AM BA CE DF ES GO MA MT MS MG PA PB PR'''.split()
for uf in ufs:
    bnmp(uf)