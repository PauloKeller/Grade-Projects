#include <stdio.h>

int main()
{
	int vetorA[5], vetorB[8], contador, contador2;
	
	printf("Digite os numeros do vetor A!\n");
	for(contador=0; contador<=4; contador++)
	{
		printf("Digite o %d do vetor A:", contador+1);
		scanf("%d", &vetorA[contador]);
	}
	
	printf("Digite os numero do vetor B!\n");
	for(contador=0; contador<=7; contador++)
	{
		printf("Digite o %d do vetor B:", contador+1);
		scanf("%d", &vetorB[contador]);
	}
	
	for(contador=0; contador<5; contador++)
	{
		for(contador2=0; contador2<8; contador2++)
		{
			if(vetorA[contador]==vetorB[contador2])
				printf("%d", vetorB[contador2]);
		}
	}
	
	return 0;
}

