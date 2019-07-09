#include <stdio.h>

int main()
{
	int fat(int n);
	
	int n;
	
	printf ("Digite o valor:");
	scanf("%d", &n);
	printf("%d", fat(n));
	
	return 0;
}

int fat(int n)
{
	if (n)
	return n*fat(n-1);
	else 
	return 1;
}

