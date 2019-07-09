#include <stdio.h>


int main()
{
	int elevado(int x, int z);
	
	int x,z;;
	
	printf ("Digite o valor de X:");
	scanf ("%d", &x);
	printf ("Digite o valor Z:");
	
	scanf ("%d", &z);
	
	printf ("Resultado: %d", elevado(x,z));
	
	return 0;
}

int elevado(int x, int z)
{
	int i,p=1;
	
	for(i=0; i<z; i++)
	{
		p = p*x;
	}
	
	return p;
}
