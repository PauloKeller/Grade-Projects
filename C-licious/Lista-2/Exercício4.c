#include <stdio.h>

int main()
{
	int verifTriangulo (int l1, int l2, int l3);
	
	int l1,l2,l3,I=1;
	
	printf ("Digite os lados do triangulo:");
	
	do{
		
	scanf ("%d %d %d", &l1, &l2, &l3);
	
	if ( l1 < (l2+ l3) && l2 < (l1+l3) && l3 < (l1+l2))
		break;
		
	else
		printf ("Formato invalido!");
		
	} while (I);
	
	
	switch (verifTriangulo(l1,l2,l3)) {
		
		case 1:
			printf ("Triangulo Equilatero!");
			break;
		case 2:
			printf("Triangulo Isosceles!");
			break;
		case 3:
			printf("Triangulo Escaleno!");
		}
		
		
	return 0;
}
int verifTriangulo (int l1, int l2, int l3)
{ 
	if ( l1 == l2 && l2 == l3)
		return 1;
	else if (l1 == l2 || l2 == l3 || l1 == l3)
		return 2;
	else
		return 3;
}
