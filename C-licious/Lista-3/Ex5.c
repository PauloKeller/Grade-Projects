#include <stdio.h>

int main()
{
	int vetorN[10], vetorM[10], contador, P;
	
	printf("Digite os numeros do vetor A!\n");
	for(contador=0; contador<=9; contador++)
	{
		printf("Digite o %d do vetor A:", contador+1);
		scanf("%d", &vetorN[contador]);
	}
	
	printf("Digite os numero do vetor B!\n");
	for(contador=0; contador<=9; contador++)
	{
		printf("Digite o %d do vetor B:", contador+1);
		scanf("%d", &vetorM[contador]);
	}
	
	for(contador=0; contador<=9; contador++)
	{
		P = P + (vetorN[contador]*vetorM[contador]);
	}
	printf("O produto e: %d", P);
	
	
	return 0;
}

