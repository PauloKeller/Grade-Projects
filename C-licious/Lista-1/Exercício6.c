#include <stdio.h>

int main()
{
	int n=0,s=0,i=1,c=0;
	printf("Digite o tamanho da sequencia:");
	scanf("%d",&s);
	
	do{
		printf("Digite o %d da sequencia:", i);
		i++;
		scanf("%d",&n);
		if(n%2 == 0)
		{
			c += n;	
		}
		s--;
	}while(s != 0);
	
	printf("A soma dos pares é: %d", c);
	
	return 0;
}

