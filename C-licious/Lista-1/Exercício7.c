#include <stdio.h>

int main()
{
	int n=0,i=1,k=0;
	printf("Digite o valor de n:");
	scanf("%d", &n);
	k=n;
	
	while(n != 0)
	{
		i = n*i;
		n--;
	}
	
	printf("O fatoria de %d é: %d",k, i);
	
	return 0;
}

