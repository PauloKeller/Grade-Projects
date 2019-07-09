#include <stdio.h>

int main()
{
	int n,soma,divisor;
	printf("Digite um numero:");
	scanf("%d", &n);
	
	soma = 0;
	
	for (divisor=1; divisor < n; divisor++)
	{	
		if (n%divisor == 0)
			soma = soma+divisor;
	}
	
	if (n==soma)
		printf("O numero %d e perfeito", n);
	else
		printf("O numero %d nao e pefeito", n);
	return 0;
}

