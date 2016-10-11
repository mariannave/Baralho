package modelo;

import java.util.Random;

import aplicaÁ„o.Jogo;

public class CartasAleatorias implements Algoritmo
{

	@Override
	public void perform(Baralho baralho, Jogo jogo)
	{
		System.out.println("Algoritmo -> Cartas Aleatorias");
		
		Random r = new Random();
	
		int tamanho = baralho.getNumCartas(); 
		
		int num1 = r.nextInt(tamanho);
		int num2 = r.nextInt(tamanho);
		
		//Testando se os numeros aleat√≥rios s√£o iguais.
		if(num1 == num2){
			num2 = r.nextInt(tamanho);
		}
		
		Carta carta_jogador1 = baralho.getCarta(num1);
		
		Carta carta_jogador2 = baralho.getCarta(num2);
		
		
		if(carta_jogador1.getNaipe() < carta_jogador2.getNaipe()) {
			jogo.addPontos_jog1();
			
		}else if(carta_jogador1.getNaipe() == carta_jogador2.getNaipe()) {
				
			if(carta_jogador1.getNumero() < carta_jogador2.getNumero()){
				jogo.addPontos_jog1();
			}else	{
				jogo.addPontos_jog2();
			}
			
		}else{
			jogo.addPontos_jog2();
		}
		
		baralho.removeCarta(carta_jogador1);
		baralho.removeCarta(carta_jogador2);
		
		//print so pra depuracao
		System.out.print("CJ1: " + carta_jogador1 + " == CJ2: " + carta_jogador2+"\n");
		System.out.println("PontJog1: " + jogo.getPontos_jog1() + " == PontJog2: " + jogo.getPontos_jog2() + "\n\n");
	}

}
