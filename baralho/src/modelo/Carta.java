package modelo;

public class Carta
{
	final int numero;
	final int naipe;
	
	static final String[] naipes =
	{
		"Ouro", "Copas", "Espada", "Paus"
	};
	
	static final String[] numeros =
	{
		"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
	};
	
	public Carta(int naipe, int numero)
	{
		this.numero = numero;
		this.naipe = naipe;
	}
	
	public int getNumero()
	{
		return this.numero;
	}
	
	public int getNaipe()
	{
		return this.naipe;
	}
	
	@Override
	public String toString()
	{
		return numeros[numero] + " de " + naipes[naipe];
	}
}
