#include <stdio.h>

int main()
{
	int n=0,x=0,k=1;
	
	printf("Digite o valor de N:");
	scanf("%d", &n);
	printf("\nDigite o valor de X:");
	scanf("%d", &x);
	k = n;
	x = x-1;
	
	do{
		x--;
		k = k * n;
		}while(x != 0);
		
	printf("Valor de n: %d", k);
	
	return 0;
}

