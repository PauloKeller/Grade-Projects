#include <stdio.h>

int main()
{
	int n=0;
	printf("Digite o numero:");
	scanf("%d", &n);
	printf("A sequência de impares é:");
	do{
		if(n%2 != 0)
		{
			printf("%d,", n);
		}
		n--;
	}while(n != 0);
	
	return 0;
}

