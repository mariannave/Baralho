package modelo;

import aplicação.Jogo;

public class PrimeiraEultima implements Algoritmo
{

	@Override
	public void perform(Baralho baralho, Jogo jogo)
	{
		System.out.println("Algoritmo -> Primeira e ultima");
		
		int tamanho = baralho.getNumCartas();
		int ultimaCarta = tamanho - 1;
		
		Carta carta_jogador1 = baralho.getCarta(0);
		Carta carta_jogador2 = baralho.getCarta(ultimaCarta);
		
		
		if(carta_jogador1.getNaipe() < carta_jogador2.getNaipe()) {
			jogo.addPontos_jog1();
			
		}else if(carta_jogador1.getNaipe() == carta_jogador2.getNaipe()) {
				
			if(carta_jogador1.getNumero() < carta_jogador2.getNumero()){
				jogo.addPontos_jog1();
			}else{
				jogo.addPontos_jog2();
			}
			
		}else{
			jogo.addPontos_jog2();
		}
		
		
		baralho.removeCarta(carta_jogador1);
		baralho.removeCarta(carta_jogador2);
		
		
		//lembrar de tirar os prints 
		System.out.print("CJ1: " + carta_jogador1 + " == CJ2: " + carta_jogador2+"\n");
		System.out.println("PontJog1: " + jogo.getPontos_jog1() + " == PontJog2: " + jogo.getPontos_jog2() + "\n\n");

	}

}
