#include <stdio.h>

int main()
{
	int n,fant=0,fatual=1,fprox,contador=1;
	printf("Digite o numero:");
	scanf("%d", &n);
	
	if (n < 2)
	{
		printf("%d", n);
	}
	
	else
	
		while (contador < n) {
			fprox = fatual + fant;
			fant = fatual;
			fatual = fprox;
			contador = contador + 1;
			}
			
	printf("O numero fibonacci e %d", fatual);

	return 0;
}

