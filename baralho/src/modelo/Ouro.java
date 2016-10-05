package modelo;

public class Ouro extends Carta
{
	int naipe = 4;
	public Ouro(int numero)
	{
		super(numero);
		
	}

	@Override
	public String toString()
	{
		return numeros[numero-1] + " de Ouro";
	}

	@Override
	public int getNaipe() {
		
		return this.naipe;
	}

}
