#include <stdio.h>

int main()
{
	int qnta,qntn,contador=0;
	
	printf("Digite a quantidade de alunos:");
	scanf("%d", &qnta);
	printf("Digite a quantidade de notas:");
	scanf("%d", &qntn);
	
	float notas[qnta][qntn];
	float media[qnta];
	 
	for (int cont1=0; cont1 < qnta; cont1++)
		{
		for(int cont2=0; cont2<qntn; cont2++)
			{	
			printf("Digite a nota %d do aluno %d:", cont2, cont1);
			scanf("%f", &notas[cont1][cont2]);	
			media[cont1]= (media[cont1] + notas[cont1][cont2]);
			}
		}
		for(int i=0; i<qnta; i++)
			{
			if(media[i]/qntn>5.0)
				{
					contador++;
				}
			}
		if(contador != 0)
			{
			printf("%d Estao com nota maior que 5.0!", contador);
			}
		else
			printf("Não há nenhum aluno com nota acima de 5.0.");
	return 0;
}

