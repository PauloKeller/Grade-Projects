#include <stdio.h> 
#include <string.h> 

int main() { 
   char frase[255], palavra[20], *ponteiro; 
   int cont=0; 
   
   printf("Informe a frase: "); 
   gets(frase); 
   printf("Informe a palavra: "); 
   scanf("%s", palavra); 
   
   ponteiro = frase;
    
   while ((ponteiro = strstr(ponteiro, palavra)) != NULL) 
   { 
      cont++; 
      ponteiro++; 
   }
    
   printf("\n'%s' ocorre %d vezes em '%s'\n", palavra, cont, frase);
    
   return 0; 
}

