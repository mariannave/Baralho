package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Jogo
{

	public static void main(String[] args)
	{
		Jogo jogo = new Jogo();
		
		System.out.println(jogo);
	}
	
	private ArrayList<Carta> baralho;
	int pontos_jog1 ;
	int pontos_jog2 ;
	
	Jogo()
	{
		baralho = new ArrayList<Carta>();
		
		criar_cartas();
		embaralhar();
		primeirasCartas();
	}
	
	public void embaralhar()
	{
		Collections.shuffle(baralho);
	}
	
	private void criar_cartas()
	{
		baralho.clear();
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 1; j <= 13; j++)
			{
				switch(i)
				{
				case 0:
					baralho.add(new Ouro(j));
					break;
				case 1:
					baralho.add(new Paus(j));
					break;
				case 2:
					baralho.add(new Copas(j));
					break;
				case 3:
					baralho.add(new Espada(j));
					break;
				}
				
			}
		}
	}
	
	public void primeirasCartas()
	{
		embaralhar();
		Carta carta_jogador1 = baralho.get(0);
		Carta carta_jogador2 = baralho.get(1);
		
		
		if(carta_jogador1.getNaipe() > carta_jogador2.getNaipe())
		{
			pontos_jog1++;
			
		}
		else
			if(carta_jogador1.getNaipe() == carta_jogador2.getNaipe())
			{
				if(carta_jogador1.getNumero() < carta_jogador2.getNumero())
					pontos_jog1++;
				else
					pontos_jog2++;
			}
			else
			{
				pontos_jog2++;
			}
		
		baralho.remove(carta_jogador1);
		baralho.remove(carta_jogador2);
		
		//print só pra depuração
		System.out.print("CJ1: " + carta_jogador1 + " CJ2: " + carta_jogador2+"\nPontJog1: " +
		pontos_jog1 + "\nPontJog2: " + pontos_jog2 + "\n");
	
		
	}

	@Override
	public String toString()
	{
		String cartas = "";
		
		for(Carta c : baralho)
			cartas += c + "\n";
		
		return cartas;
	}
}
