#include <stdio.h>

int main()
{
	int n=0,j=0,i=0,c=0,k=0;
	
	printf("Digite o valor de n:");
	scanf("%d", &n);
	printf("Digite o valor de i:");
	scanf("%d", &i);
	printf("Digite o valor de j:");
	scanf("%d", &j);
	
	do{
		if(k%i == 0 || k%j ==0)
			{
				printf("%d", k);
				c = c+1;
			}
		k = k+1;	
	}while(k<n);
	
	return 0;
}

