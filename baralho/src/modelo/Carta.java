package modelo;

public abstract class Carta
{
	final int numero;
	int naipe;
	
	static final String[] numeros =
	{
		"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
	};
	
	public Carta(int numero)
	{
		this.numero = numero;
	}
	
	public int getNumero()
	{
		return this.numero;
	}
	
	public int getNaipe()
	{
		return this.naipe;
	}
}
