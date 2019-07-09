#include <stdio.h>

int main()
{
	int maxDivisor(int n);
	
	int n;
	 
	printf("Digite o valor:");
	scanf("%d", &n);
	
	printf("%d", maxDivisor(n));
	
	return 0;
}
int maxDivisor(int n)
{
	int i,soma=0;
	
	for(i=1; i<= n; i++){
		if(n%i == 0)
			{
				soma += 1;
			}
		}
	return soma;
}
