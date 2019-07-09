#include <stdio.h>

int main()
{
	int soma=0,n,divisor;
	printf("Digite o numero:");
	scanf("%d", &n);
	
	for(divisor = 1; divisor < n; divisor++)
	{
	if(n % divisor == 0)
		soma += divisor;
	}
	if(n==soma)
		printf("O numero e perfeito");
	else
		printf("O numero nao e perfeito");
	return 0;
}

