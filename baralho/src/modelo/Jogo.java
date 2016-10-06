package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Jogo {
	
	//Instanciando o baralho
	private ArrayList<Carta> baralho;
	int pontos_jog1 ;
	int pontos_jog2 ;
	int jogadas = 0;
		
	Jogo() {
		baralho = new ArrayList<Carta>();
		
		criar_cartas();
		embaralhar();
//		primeirasCartas();
		primeiraEultima();
//		cartasAleatorias();
	}
	
	
	public void embaralhar() {
		Collections.shuffle(baralho);
	}
	
	
	private void criar_cartas() {
		baralho.clear();
		
		for(int i = 0; i < 4; i++) {
			
			for(int j = 1; j <= 13; j++) {
				switch(i) {
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
	
	
	// Metodo que retira as cartas do inicio do baralho 
	public void primeirasCartas() {
		embaralhar();
		Carta carta_jogador1 = baralho.get(0);
		Carta carta_jogador2 = baralho.get(1);
		
		
		if(carta_jogador1.getNaipe() > carta_jogador2.getNaipe()) {
			pontos_jog1++;
			
		}else if(carta_jogador1.getNaipe() == carta_jogador2.getNaipe()) {
				
			if(carta_jogador1.getNumero() < carta_jogador2.getNumero()){
				pontos_jog1++;
			}else{
				pontos_jog2++;
			}
			
		}else{
				pontos_jog2++;
		}
		
		baralho.remove(carta_jogador1);
		baralho.remove(carta_jogador2);
		
		//print so pra depuracao
//		System.out.print("CJ1: " + carta_jogador1 + " \n\n\nCJ2: " + carta_jogador2+"\n\n\nPontJog1: " +
//		pontos_jog1 + "\n\n\nPontJog2: " + pontos_jog2 + "\n\n\n");
	
		
	}
	
	
	//Metodo que retira a primeira e a ultima carta do baralho
	public void primeiraEultima() {
		
		embaralhar();
		
		int tamanho = baralho.size();
		int ultimaCarta = tamanho - 1;
		
		Carta carta_jogador1 = baralho.get(0);
		Carta carta_jogador2 = baralho.get(ultimaCarta);
		
		
		if(carta_jogador1.getNaipe() > carta_jogador2.getNaipe()) {
			pontos_jog1++;
			
		}else if(carta_jogador1.getNaipe() == carta_jogador2.getNaipe()) {
				
			if(carta_jogador1.getNumero() < carta_jogador2.getNumero()){
				pontos_jog1++;
			}else{
				pontos_jog2++;
			}
			
		}else{
				pontos_jog2++;
		}
		
		
		baralho.remove(carta_jogador1);
		baralho.remove(carta_jogador2);
		
		
		// Print pra debug
		System.out.print("CJ1: " + carta_jogador1 + " \n\n\nCJ2: " + carta_jogador2+"\n\n\nPontJog1: " +
				pontos_jog1 + "\n\n\nPontJog2: " + pontos_jog2 + "\n\n\n");
		
	}
	
	
	// Metodo que retira cartas do baralho aleatoriamente
	public void cartasAleatorias(){
		embaralhar();
		
		Random r = new Random();
	
		int tamanho = baralho.size(); 
		
		int num1 = r.nextInt(tamanho);
		int num2 = r.nextInt(tamanho);
		
		//Testando se os numeros aleatórios são iguais.
		if(num1 == num2){
			num2 = r.nextInt(tamanho);
		}
		
		Carta carta_jogador1 = baralho.get(num1);
		
		Carta carta_jogador2 = baralho.get(num2);
		
		
		if(carta_jogador1.getNaipe() > carta_jogador2.getNaipe()) {
			pontos_jog1++;
			
		}else if(carta_jogador1.getNaipe() == carta_jogador2.getNaipe()) {
				
			if(carta_jogador1.getNumero() < carta_jogador2.getNumero()){
				pontos_jog1++;
			}else	{
				pontos_jog2++;
			}
			
		}else{
				pontos_jog2++;
		}
		
		baralho.remove(carta_jogador1);
		baralho.remove(carta_jogador2);
		
		//print so pra depuracao
//		System.out.print("CJ1: " + carta_jogador1 + " \n\n\nCJ2: " + carta_jogador2+"\n\n\nPontJog1: " +
//		pontos_jog1 + "\n\n\nPontJog2: " + pontos_jog2 + "\n\n\n");
		
		
	}
	
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		
		System.out.println(jogo);
	}
	
	
	@Override
	public String toString() {
		String cartas = "";
		
		for(Carta c : baralho)
			cartas += c + "\n";
		
		return cartas;
	}
}