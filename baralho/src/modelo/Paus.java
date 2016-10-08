package modelo;

public class Paus  extends  Carta
{
	public Paus(int numero)
	{
		super(numero);
		naipe = 1;
	}
	
	@Override
	public String toString()
	{
		return numeros[numero-1] + " de Paus";
	}
}
