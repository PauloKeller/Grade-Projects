public class ListaCircular {
	No inicio;
	
	ListaCircular() {
		inicio = null;
	}
	
	void inserir(int valor) {
		No no = new No();
		no.conteudo = valor;
		
		if (inicio == null) {
			no.proximo = no;
			inicio = no;
		} else {
			No ultimo = inicio;
			while(ultimo.proximo != inicio) {
				ultimo = ultimo.proximo;
			}
			
			no.proximo = ultimo.proximo;
			ultimo.proximo = no;
		}
	}
	
	void imprimir() {
		if (inicio == null) {
			System.out.println("Lista vazia\n");
		} else {
			No ultimo = inicio;
			
			do {
				System.out.println(ultimo.conteudo + " ");
				ultimo = ultimo.proximo;
			}while(ultimo != inicio);
		}
	}
	
	No buscar(int valor) {
		if(inicio == null) {
			return null;
		} else {
			No atual = inicio;
			
			while(atual.proximo != inicio && atual.conteudo != valor){
				atual = atual.proximo;
			}
			
			return atual.conteudo == valor?	atual : null;
		}
	}
	
	void remover(int valor) {
		if (inicio != null) {
			No anterior = inicio;
			No atual = inicio.proximo;
			
			while(atual != inicio && atual.conteudo != valor) {
				anterior = atual;
				atual = atual.proximo;
			}
			
			if(atual == anterior) {
				inicio = null;
			}
			
			else if (atual == inicio) {
				inicio = inicio.proximo;
				anterior.proximo = inicio;
			} else {
				anterior.proximo = atual.proximo;
			}
		}
	}
	
}
