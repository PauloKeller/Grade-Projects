#include <stdio.h>

int main()
{
	int n=0,i=0,q=0;
	
	do{
		i++;
		printf("Digite o %d numero da sequencia:", i);
		scanf("%d", &n);
		q = n * n;
		printf("O quadrado do numero é %d\n", q);
	}while(n != 0);	
	
	return 0;
}

