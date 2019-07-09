#include <stdio.h>

int main()
{
	int primo(int m);
	int m,v;
	
	printf("Digite um numero:");
	scanf("%d", &m);
	
	v = primo(m);
	printf("%d",v);
	
	return 0;
}

int primo(int m)
{
	int c=0,i;
	for(i=1; i <= m; i++){
		if( m%i == 0 ) 
		{
			c++;
		}
	}
	if (c == 2)
	return 1;
	
	else
	return 0;
}
