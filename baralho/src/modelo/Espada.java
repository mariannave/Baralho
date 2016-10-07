package modelo;

public class Espada  extends  Carta
{
	public Espada(int numero)
	{
		super(numero);
		naipe = 2;
	}
	
	@Override
	public String toString()
	{
		return numeros[numero-1] + " de Espada";
	}
}
