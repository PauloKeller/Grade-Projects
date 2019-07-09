#include <stdio.h>
int main()
{
	int k=1,n=0,nmax=0,nmin=10,i=1,na=0,notamax=10,notamin=0;
	printf("Digite o numero de alunos:");
	scanf("%d", &n);
	
	
	do{
		printf("Digite a nota do %d aluno:", k);
		k++;
		
		
		do{
			scanf("%d", &na);
			
			if(na > notamax || na < notamin)
			{
			  printf("Nota invalidada, digite novamente!");
			}
			
			else
			{
				
			  if(na > nmax)
			  {
				  nmax = na;
			  }
			  if(na < nmin)
			  {
				nmin = na;  
			  }
			  
			  break;
			}
			
		}while(i);
		n--;
		
	}while(n != 0);
	
	printf("Maior nota %d, menor nota %d", nmax, nmin);
	
	return 0;
}

