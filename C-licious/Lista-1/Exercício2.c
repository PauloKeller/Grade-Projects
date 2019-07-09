#include <stdio.h>

int main()
{
	int n=0,k=0,i=1;
	
	printf("Digite o numero natural:");
	scanf("%d", &n);
	
	do{
		k = k + n;
		n = n - i;
		}while(n!=0);
		
	printf("A soma dos naturais é:%d", k);
	return 0;
}

