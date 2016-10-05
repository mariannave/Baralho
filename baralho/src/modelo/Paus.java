package modelo;

public class Paus  extends  Carta
{
	int naipe = 1;
	public Paus(int numero)
	{
		super(numero);
	}
	
	@Override
	public String toString()
	{
		return numeros[numero-1] + " de Paus";
	}
	
	public int getNaipe()
	{
		return this.naipe;
	}
}
