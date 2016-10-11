package aplicação;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import modelo.Algoritmo;
import modelo.Baralho;
import modelo.CartasAleatorias;
import modelo.PrimeiraEultima;
import modelo.PrimeirasCartas;

public class Jogo {
	
	//Instanciando o baralho
	Baralho baralho;
	int pontos_jog1;
	int pontos_jog2;
	ArrayList<Algoritmo> algoritmos;
	
	Jogo() {
		novoBaralho();
		
		algoritmos = new ArrayList<Algoritmo>();
		
		addAlgoritmo(new PrimeirasCartas());
		addAlgoritmo(new PrimeiraEultima());
		addAlgoritmo(new CartasAleatorias());
	}
	
	public void novoBaralho()
	{
		baralho = new Baralho();
		baralho.embaralhar();
	}
	
	public int getPontos_jog1() {
		return pontos_jog1;
	}

	public int getPontos_jog2() {
		return pontos_jog2;
	}
	
	public void addPontos_jog1() {
		pontos_jog1++;
	}
	
	public void addPontos_jog2() {
		pontos_jog2++;
	}
	
	public void jogar() {
		Random r = new Random();
		int n = r.nextInt(algoritmos.size());
		
		jogar(n);
	}
	
	public void jogar(int n) {
		algoritmos.get(n).perform(baralho, this);
	}
	
	private void addAlgoritmo(Algoritmo alg) {
		algoritmos.add(alg);
	}
	
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		Scanner teclado = new Scanner(System.in);
			
		int entrada = -1;
		
		while(entrada != 0){
			System.out.println("============ GAME ============\n");
			System.out.println("- 0: Sair do jogo");
			System.out.println("- 1: Algoritmo aleatorio");
			System.out.println("- 2: Algoritmo selecionado");	
			System.out.print("- Digite uma opcao: ");
			System.out.println("");
			entrada = Integer.parseInt(teclado.nextLine());

			if(entrada == 1){
				jogo.novoBaralho();
				
				for(int i = 1; i <= 10; i++) {
					System.out.println("**** " + i + "ª Rodada ****");
					jogo.jogar(); /*se quiser escolher um único algoritmo só é passar um int de 0 à 2
								 	nesse parâmetro jogar(int x), sendo 0 para o algoritmo
								 	PrimeirasCartas, 1 para Primeira e utima e 2 para Cartas aleatórias */
					
				}
				if(jogo.getPontos_jog1() == jogo.getPontos_jog2()) {
					System.out.println("***** 11ª Rodada *****");
					jogo.jogar();
				}
			}else if(entrada == 2){
				System.out.println("============ OPCOES DE ALGORITMOS ============\n");
				System.out.println("Selecione o algoritmo.");
				System.out.println("- 1: Retirar as cartas do inicio");
				System.out.println("- 2: Retirar as cartas do inicio e do fim");
				System.out.println("- 3: Retirar as cartas aleatoriamente");
				System.out.print("- Digite uma opcao: ");
				System.out.println("");
				int novaEntrada = Integer.parseInt(teclado.nextLine());
				
				novaEntrada = novaEntrada - 1;
				
				jogo.novoBaralho();
				
				for(int i = 1; i <= 10; i++) {
					System.out.println("**** " + i + "ª Rodada ****");
					jogo.jogar(novaEntrada); /*se quiser escolher um único algoritmo só é passar um int de 0 à 2
								 	nesse parâmetro jogar(int x), sendo 0 para o algoritmo
								 	PrimeirasCartas, 1 para Primeira e utima e 2 para Cartas aleatórias */
					
				}
				if(jogo.getPontos_jog1() == jogo.getPontos_jog2()) {
					System.out.println("***** 11ª Rodada *****");
					jogo.jogar();
				}

			}
		}
		
		System.out.println("Você saiu do jogo.");		
	}
}
