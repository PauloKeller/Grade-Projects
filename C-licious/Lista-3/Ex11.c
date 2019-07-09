#include <stdio.h>

int main(int argc, char **argv)
{
	char frase[50];
	int contador, espacos=0, contador2;
	
	printf("Digite a frase:");
	gets(frase);
	
	for(contador=0; contador < strlen(frase); contador++)
	{
		if(frase[contador] == ' ')
		{
			espacos++;
			for(contador2 = contador; contador2 < strlen(frase); contador2++)
			{
				frase[contador2] = frase[contador2+1];
			}	
		}
	}
	
	printf("%s\n", frase);
	printf("%d", espacos);
	return 0;
}

