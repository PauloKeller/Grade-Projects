#include <stdio.h>

int main()
{
	int n,i;
	printf("Digite o numero:");
	scanf("%d", &n);
	
	for(i=1; i*(i+1)*(i+2) < n; i++)
		;
		
		if(i*(i+1)*(i+2) == n)
			printf("Numero triangular!");
		else
			printf("Nao é triangular!");
	
	return 0;
}

