package aplicação;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.function.Consumer;

import modelo.Carta;
import modelo.Copas;
import modelo.Espada;
import modelo.Ouro;
import modelo.Paus;

public class Jogo {
	
	//Instanciando o baralho
	ArrayList<Carta> baralho;
	static int pontos_jog1 ;
	static int pontos_jog2 ;
	
	int jogadas = 0;
	ArrayList<Consumer<String>> metodos;
		
	Jogo() {
		baralho = new ArrayList<Carta>();
		metodos = new ArrayList<Consumer<String>>();
		
		criar_cartas();
		embaralhar();
		
		addMetodo(f -> primeirasCartas());
		addMetodo(f -> primeiraEultima());
		addMetodo(f -> cartasAleatorias());
		

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
	public void primeirasCartas() {System.out.println("Algoritmo -> Primeiras Cartas");
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
		System.out.print("CJ1: " + carta_jogador1 + " \n\n\nCJ2: " + carta_jogador2+"\n\n\nPontJog1: " +
		pontos_jog1 + "\n\n\nPontJog2: " + pontos_jog2 + "\n\n\n");
	
		
	}
	
	
	//Metodo que retira a primeira e a ultima carta do baralho
	public void primeiraEultima() {System.out.println("Algoritmo -> Primeira e ultima");
		
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
		
		
		//lembrar de tirar os prints 
		System.out.print("CJ1: " + carta_jogador1 + " \n\n\nCJ2: " + carta_jogador2+"\n\n\nPontJog1: " +
				pontos_jog1 + "\n\n\nPontJog2: " + pontos_jog2 + "\n\n\n");
		
	}
	
	
	// Metodo que retira cartas do baralho aleatoriamente
	public void cartasAleatorias(){System.out.println("Algoritmo -> Cartas Aleatorias");
		embaralhar();
		
		Random r = new Random();
	
		int tamanho = baralho.size(); 
		
		int num1 = r.nextInt(tamanho);
		int num2 = r.nextInt(tamanho);
		
		//Testando se os numeros aleatÃ³rios sÃ£o iguais.
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
		System.out.print("CJ1: " + carta_jogador1 + " \n\n\nCJ2: " + carta_jogador2+"\n\n\nPontJog1: " +
		pontos_jog1 + "\n\n\nPontJog2: " + pontos_jog2 + "\n\n\n");
		
		
	}
	
	/// o main vai pra aplicação
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		
		System.out.println(jogo);
		
		for(int i = 1; i <= 10; i++){
			System.out.println("**** " + i + "ª Rodada ****\n");
			jogo.jogar(); /*se quiser escolher um único algoritmo só é passar um int de 0 à 2
						 	nesse parâmetro jogar(int x), sendo 0 para o algoritmo
						 	PrimeirasCartas, 1 para Primeira e utima e 2 para Cartas aleatórias */
			
		}
		if(pontos_jog1 == pontos_jog2)
		{
			System.out.println("**** 11 Rodada ****\n");
			jogo.jogar();
		}
		
	}
	
	
	@Override
	public String toString() {
		String cartas = "";
		
		for(Carta c : baralho)
			cartas += c + "\n";
		
		return cartas;
	}
	
	public void jogar() {
		Random r = new Random();
		int f = r.nextInt(metodos.size());
		
		jogar(f);
	}
	
	public void jogar(int f) {
		metodos.get(f).accept("");
	}
	
	private void addMetodo(Consumer<String> f) {
		metodos.add(f);
	}
}
