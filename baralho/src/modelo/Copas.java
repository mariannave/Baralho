package modelo;

public class Copas  extends  Carta
{
	public Copas(int numero)
	{
		super(numero);
		naipe = 3;
	}
	
	@Override
	public String toString()
	{
		return numeros[numero-1] + " de Copas";
	}
}
