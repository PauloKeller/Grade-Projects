#include <stdio.h>

int main()
{
	int contador, vetor[10], sequencia, x, ocorrencias[10], na=0,cont=0;
	
	printf("Digite o valor de X:");
	scanf("%d", &x);
	printf("Digite o tamanho da seqeuncia:");
	scanf("%d", &sequencia);
	
	for (contador=0; contador<=sequencia-1; contador++) 
		{
			printf("Digite o %d numero da sequencia:", contador+1);
			scanf("%d", &vetor[contador]);
			if (vetor[contador] == x)
				{
					ocorrencias[cont] = contador+1;
					cont++;
				}
			else
				na++;
		}
	if (na==sequencia)
	{
		printf("Não ancoteceu nenhuma ocorrencia!");
	}
	else
	{
		printf("O numero x ocorreu em:");
		
		for(contador = 0; contador <= cont-1; contador++)
		{
			printf("%d.", ocorrencias[contador]);
		}
	}
	return 0;
}

