#include <stdio.h>

int main()
{
	int linha,coluna,n=0,maior=0,matriz[10][10], mlinha, mcoluna;
	
	
	for (linha=0; linha < 10; linha++)
		{
		for(coluna=0; coluna<10; coluna++)
			{
				n++;
				matriz[linha][coluna] = n;
				if(matriz[linha][coluna] > maior)
				{
					maior = matriz[linha][coluna];
					mlinha = linha;
					mcoluna = coluna;
				}
			}
		}
		
	for(linha=0; linha<10; linha++)
	{
		for(coluna=0; coluna<10; coluna++)
		{
			printf("%d ", matriz[linha][coluna]);
		}
		printf("\n");
	}
	
	printf("Maior:%d", matriz[mlinha][mcoluna]);
	return 0;
}

