#include <stdio.h>

int main()
{
	int somaPrimo(int n);
	int n,v=0;
	
	printf("Digite o numero:");
	scanf("%d", &n);
	
	v = somaPrimo(n);
	printf("%d", v);
	
	return 0;
}
int somaPrimo(int n)
{
	int i=1,soma=0;
	
	while(i<=n){
		if( n%i == 0 )
			{
		    soma = soma + i;
			}
			i++;
		}
	return soma;
}

