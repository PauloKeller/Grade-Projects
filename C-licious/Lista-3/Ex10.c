#include <stdio.h>
#define A 1
#define B 2
#define C 3
#define D 4
#define E 5
int main(int argc, char **argv)
{
	int gabarito[30],contador, alunos, contador2;
	
	printf("Digite o gabarito da prova\n 1-A\n 2-B\n 3-C\n 4-D\n 5-E\n");
	
	for(contador=0; contador<30; contador++)
	{
		printf("Pergunta %d: ", contador);
		scanf("%d", &gabarito[contador]);
	}
	
	printf("Digite a quantidade de alunos na sala:");
	scanf("%d", &alunos);
	
	int respostas[alunos][30];
	
	printf("------------Gabarito------------\n");
	
	for(contador=0; contador<30; contador++)
	{
		printf("Pergunta %d: %d\n", contador, gabarito[contador]);
	}
	
	for(contador=0; contador<alunos; contador++)
	{
		for(contador2=0; contador2<30; contador2++)
		{
			printf("Resposta %d, do aluno %d:", contador2, contador);
			scanf("%d", &respostas[contador][contador2]);
		}
	}
	
	for(contador=0; contador<alunos; contador++)
	{
		for(contador2=0; contador2<30; contador2++)
		{
			printf("Aluno %d - Resposta %d: %d\n", contador, contador2, respostas[contador][contador2]);
		}
		printf("\n");
	}
	
	return 0;
}

