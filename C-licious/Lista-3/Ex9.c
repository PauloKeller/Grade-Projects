#include <stdio.h>

int main()
{
	int qntv,mvolta;
	
	printf("Digite a quantidade de voltas:");
	scanf("%d", &qntv);
	
	float voltas[qntv];
	float media=0,melhortemp=1000;
	 
	for (int cont1=0; cont1 < qntv; cont1++)
		{
			printf("Digite o tempo da volta %d:",cont1);
			scanf("%f", &voltas[cont1]);
			
			if(voltas[cont1]<melhortemp)
				{
					melhortemp = voltas[cont1];
					mvolta = cont1;
				}
				
			media += voltas[cont1];
		}
		
	media = media/qntv;
	
	printf("Melhor tempo: %.2f\n", melhortemp);
	printf("Volta em que ocorreu o melhor tempo: %d\n",mvolta);
	printf("Media das voltas: %.2f\n", media);
	
	return 0;
}
