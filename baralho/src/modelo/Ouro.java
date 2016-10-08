package modelo;

public class Ouro extends Carta
{
	public Ouro(int numero)
	{
		super(numero);
		naipe = 4;
	}

	@Override
	public String toString()
	{
		return numeros[numero-1] + " de Ouro";
	}
}
