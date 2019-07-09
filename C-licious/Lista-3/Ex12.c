#include<stdio.h>
#include<string.h>
main(){

	int cont=0,i,j,tam1,tam2;   
	char palavra1[50],palavra2[50];  
 
	printf("Digite a primeira palavra: ");
	gets(palavra1); 
	printf("\nDigite a segunda palavra: ");
	gets(palavra2);  
	
	tam1=strlen(palavra1);  
	tam2=strlen(palavra2); 
 
	if(tam1==tam2)
	{
		
		for(i=0;i<tam1;i++)
		{
			   
			for(j=0;j<tam2;j++)
			{
				  
				if(palavra1[i]==palavra2[j])
				{   
					cont++;
					palavra2[j]=0; 
					break;
				}
			}
		}
		if(cont==tam1)
		{
			printf("As palavras são anagramas.");
		}
		else
		{
		printf("Não são anagramas.");
		}
	}
	else
	{
	printf("Não são anagramas.");
	}
 return 0;
 getch();
}

