package modelo;

public class Copas  extends  Carta
{
	int naipe = 3;

	public Copas(int numero)
	{
		super(numero);
		
	}
	
	@Override
	public String toString()
	{
		return numeros[numero-1] + " de Copas";
	}
	

	@Override
	public int getNaipe() {
	
		return this.naipe;
	}

}
