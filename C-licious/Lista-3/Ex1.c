#include <stdio.h>
int main()
{
	int j=0, sequencia=0, contador, vetor[99];
	
	printf("Digite o tamanho da sequencia:");
	scanf("%d", &sequencia);
	
	for(contador = 0; contador < sequencia; contador++)
		{
			printf("Digite o %d numero da sequencia:", contador+1);
			scanf("%d", &vetor[contador]);
		}
	for(j = sequencia-1 ; j >= 0; j--){
			printf("n:%d\n", vetor[j]);
		}
	return 0;
}

