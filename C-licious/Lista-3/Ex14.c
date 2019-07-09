#include <stdio.h>
#include <string.h>

int main(int argc, char **argv)
{
	char caractere;
	
	printf("Digite o caractere: ");
	scanf("%c", &caractere);
	
	if ( (caractere >= 33 && caractere <= 47) || (caractere >= 58 && caractere <= 64) ||
	     (caractere >= 91 && caractere <= 96) || (caractere >= 123 && caractere <= 127) )
	{
		printf("Simbolo!");
	}
	
	if (caractere >= 48 && caractere <= 57)
	{
		printf("Numero!");
	}
	
	if (caractere >= 65 && caractere <= 90)
	{
		printf("Letra maiscula!");
	}
	
	if (caractere >= 92 && caractere <= 122)
	{
		printf("Letra minuscula!");
	}
	
	printf("%d", caractere);
	
	return 0;
}

