package modelo;

public class Espada  extends  Carta
{
	int naipe = 2;
	public Espada(int numero)
	{
		super(numero);
		
	}
	
	@Override
	public String toString()
	{
		return numeros[numero-1] + " de Espada";
	}
	
	public int getNaipe()
	{
		return this.naipe;
	}
}
