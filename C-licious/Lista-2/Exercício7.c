#include <stdio.h>
int contaDigitos(int n, int d)
{
	int c=0,r;
	
	while (n != 0)
	{
		
		r = n%10;
		n = n/10;
		
		if (r == d)
		c++;
	}
	return c;
}
int main()
{
	int a,b,d,p=1;
	
	printf ("Digite dois intereiros: ");
	scanf ("%d %d", &a,&b);
	
	for (d=1; d <= 9; d++)
		if (contaDigitos(a,d) !=  contaDigitos(b,d))
			p=0;
			
	if (p)
		printf("%d e permutacao de %d\n",a,b);
	else
		printf("Não e permutacao");
	
	return 0;
}

