package model;

public class TicTacToe {
	
	private int contadorDeJogadas = 0;
	
	private Jogada proximoJogador;
	
	private Jogada[][] tabuleiro;
	
	private Boolean empate = false;
	
	public TicTacToe(){
		resetTabuleiro();
	}
	public Jogada getProximoJodador() {
		return proximoJogador;
	}
	public Jogada[][] getTabuleiro() {

		return tabuleiro;
	}
	public Boolean getEmpate(){

		return empate;
	}
	
	
	
	private void resetTabuleiro(){
		
		proximoJogador= Jogada.X;
		contadorDeJogadas = 0;
		
		tabuleiro = new Jogada[3][3];
		
		for(int l=0; l<3; l++){
			for(int c=0; c<3; c++){
				tabuleiro[l][c] = Jogada.EMPTY;
			}
		}
		
		
	}
	public Boolean registraJogada(int linha, int coluna){
		
		if(!verificaJogada(linha, coluna)){
			return false;
		}
		if(proximoJogador == Jogada.X)
			jogadaX(linha,coluna);
		else
			jogadaO(linha,coluna);
		
		definirProximoJogador();
		
		contadorDeJogadas++;
		
		return true;
		
	}
	private void definirProximoJogador(){
		if(proximoJogador == Jogada.X)
			proximoJogador = Jogada.O;
		else
			proximoJogador = Jogada.X;
			
	}
	private Boolean verificaJogada(int linha, int coluna){

		
		if (tabuleiro[linha][coluna] == Jogada.EMPTY)
			return true;
		
		return false;
		
	}
	
	
	
	private void jogadaX(int linha, int coluna){
		tabuleiro[linha][coluna] = Jogada.X;
	}
	private void jogadaO(int linha, int coluna){
		tabuleiro[linha][coluna] = Jogada.O;
	}
	
	
	public Boolean verificaGanhador()
{
		if(verificaGanhadorLinha())
			return true;
		
		if(verificaGanhadorColuna())
			return true;
		
		if(verificaGanhadorDiagonal())
			return true;
		
		if (this.contadorDeJogadas <= 9)
		{
			this.empate = true;
			return true;
		}
		return false;
		
	}
	private Boolean verificaGanhadorLinha()
{
		Boolean retorno = false;
		for(int l=0; l<3; l++)
		{
			if( (tabuleiro[l][0] != Jogada.EMPTY ||
			     tabuleiro[l][1] != Jogada.EMPTY ||
			     tabuleiro[l][2] != Jogada.EMPTY) && 
				tabuleiro[l][0] == tabuleiro[l][1] && tabuleiro[l][1] == tabuleiro[l][2] )
			{
				retorno = true;
				break;
			}
				
		}
		return retorno;
	}
	private Boolean verificaGanhadorColuna()
{
		Boolean retorno = false;
		for(int c=0; c<3; c++)
		{
			if ( (tabuleiro[0][c] != Jogada.EMPTY ||
				  tabuleiro[1][c] != Jogada.EMPTY ||
				  tabuleiro[2][c] != Jogada.EMPTY) &&
				tabuleiro[0][c] == tabuleiro [1][c] && tabuleiro[1][c] == tabuleiro[2][c])
			{
				retorno = true;
				break;
			}
		}
		return retorno;
	}
	private Boolean verificaGanhadorDiagonal()
{
		if (tabuleiro[0][0] != Jogada.EMPTY ||
			tabuleiro[1][1] != Jogada.EMPTY ||
			tabuleiro[2][2] != Jogada.EMPTY)
		{
			return (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro [2][2]);
		}
		if(tabuleiro[0][2] != Jogada.EMPTY ||
		   tabuleiro[1][1] != Jogada.EMPTY ||
	       tabuleiro[2][0] != Jogada.EMPTY)
		{
			return(tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]);
		}
		
		return false;
		
	}
}
