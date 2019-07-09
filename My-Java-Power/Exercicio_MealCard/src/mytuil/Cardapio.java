package mytuil;

public enum Cardapio {
	
	SALGADO(5),SOBREMESA(7),ALMOCO(10),JANTAR(10),SORVETE(3);
	
	public int valorCardapio;
	
	Cardapio(int valor)
		{
		
			valorCardapio = valor;
		}
	
	public int getValor()
	{
		return this.valorCardapio;
	}
	
	

}
