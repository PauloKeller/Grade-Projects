#include <stdio.h>

int main()
{
	int contador, vetor[8], novovetor[8],i=0;
	
	for( contador = 0; contador < 8; contador++ )
		{
			printf("Digite o %d da sequencia", contador+1);
			scanf("%d", &vetor[contador]);
		}
	for( contador=4; contador<=7; contador++ )
		{
			novovetor[i] = vetor[contador];
			i++;
		}
	for(contador=0; contador<=3; contador++)
		{
			novovetor[i] = vetor[contador];
			i++;
		}
	for(contador=0; contador<=7; contador++)
		{
			printf("n:%d\n", novovetor[contador]);
		}
	return 0;
}

