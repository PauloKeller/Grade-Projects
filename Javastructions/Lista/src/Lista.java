
public class Lista {
	
	No inicio;
	No fim;
	
	Lista() {
		/* Inicia a lista vazia */
		inicio = null;
	}
	
	void inserir(int valor) {
		/* criar um nó */
		No no = new No();
		no.conteudo = valor;
		no.proximo = null;/* este sera o ultimo no da lista*/
		
		/* checa se a lista esta vazia */
		if (inicio == null) {
			inicio = no;
		} else {
			/* percorrer a lista ate encontrar o ultimo no */
			fim = inicio;
			while(fim.proximo != null) {
				fim = fim.proximo;
			}
			/* altera o proximo do ultimo para o endereco do no */
			fim.proximo = no;
		}
	}
	
	void imprimir(){
		/* checa se a lista esta vazia */
		if(inicio == null) {
			System.out.println("Lista vazia \n");
		} else {
			/* perorrer a lista ate encontrar o ultimo no */
			No ultimo  = inicio;
			while(ultimo != null) {
				System.out.println(ultimo.conteudo + " ");
				ultimo = ultimo.proximo;
			}
		}
	}
	
	/* ira retornar o no que possui o valor ou null caso contrario */
	No buscar(int valor) {
		No atual = inicio;
		/* percorre ate encontrar valor ou o fim  da lista*/
		while(atual != null && atual.conteudo != valor) {
			atual = atual.proximo;
		}
		return atual;
	}
	
	/* ira retornar o no que possui o valor ou null caso contrario */
	/* A busca sera pro recursividade*/
	No buscar(int valor, No no) {
		if(no == null) {
			return null;
		} else if (no.conteudo == valor) {
			return no;
		} else {
			return buscar(valor, no.proximo);
		}
	}
	
	void remover(int valor) {
		No anterior = null; /* ponteiro para o elemento anterior */
		No atual = inicio; /* ponteiro para o elemento atual */
		
		/* procura o no que possui o valor */
		while(atual != null && atual.conteudo != valor) {
			anterior = atual;
			atual = atual.proximo; 
		}
		
		if(anterior == null && atual != null) {
			/* o valor esta no 1º no */
			inicio = atual.proximo;
		}
		/* atual sera null quando o valor nao existir */
		else if(atual != null) {
			/* remove do meio ou final da sequencia*/
			anterior.proximo = atual.proximo;
		}
	}
	
	No ulimo() {
		if (inicio == null) {
			return null;
		} else {
			/* percorrer a lista ate encontrar o ultimo no */
			while(fim.proximo != null) {
				fim = fim.proximo;
			}
			return fim;
		}
	}
	
	int contar() {
		int count = 0;
		No anterior = null; /* ponteiro para o elemento anterior */
		No atual = inicio; /* ponteiro para o elemento atual */
		
		/* percorrer a lista ate encontrar o ultimo no */
		while(atual != null) {
			count += 1;
			anterior = atual;
			atual = atual.proximo; 
		}
		return count;
	}
	
	int soma() {
		int soma = 0;
		No anterior = null; /* ponteiro para o elemento anterior */
		No atual = inicio; /* ponteiro para o elemento atual */
		
		/* percorrer a lista ate encontrar o ultimo no */
		while(atual != null) {
			soma += atual.conteudo;
			anterior = atual;
			atual = atual.proximo;
		}
		return soma;
	}
	
	int altura(int valor){
		No atual = inicio;
		int i = 0;
		int altura = 0;

		/* percorre ate encontrar valor ou o fim  da lista*/
		while(atual != null) {
			atual = atual.proximo;
			if(atual != null){
				if(atual.conteudo == valor) {
					while(atual != null){
						i +=1;
						atual = atual.proximo;
					}
				}
			}
		}
		
		altura = i - 1;
		return altura;
	}
	
	int profundidade(int valor) {
		No atual = inicio;
		int profundidade = 0;
		int i = 1;
		boolean flag = false; 
		
		/* percorre ate encontrar valor ou o fim  da lista*/
		while(atual != null && atual.conteudo != valor) {
			i += 1;
			atual = atual.proximo;
			if (atual != null) {
				if (atual.conteudo == valor) {
					flag = true;
				}	
			}
		}
		
		if (flag) {
			profundidade = i;	
		}
		return profundidade;
	}
	
	int[] toArray(){
		No atual = inicio;
		int vetor[] = new int[contar()];
		int index = 0;
		while(atual != null) {
			vetor[index] = atual.conteudo;
			atual = atual.proximo;
			index += 1;
		}
		return vetor;
	}
	
	void inserir(int[] vetor){
		for (int index = 0; index < vetor.length; index ++) {
			/* criar um nó */
			No no = new No();
			no.conteudo = vetor[index];
			no.proximo = null;/* este sera o ultimo no da lista*/
			
			/* checa se a lista esta vazia */
			if (inicio == null) {
				inicio = no;
			} else {
				/* percorrer a lista ate encontrar o ultimo no */
				fim = inicio;
				while(fim.proximo != null) {
					fim = fim.proximo;
				}
				/* altera o proximo do ultimo para o endereco do no */
				fim.proximo = no;
			}
		}
	}
}
