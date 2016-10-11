package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho
{
	ArrayList<Carta> cartas;
	
	public Baralho() {
		cartas = new ArrayList<Carta>();
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				cartas.add(new Carta(i, j));

			}
		}
	}
	
	public Carta getCarta(int num) {
		return cartas.get(num);
	}
	
	public void removeCarta(Carta carta)
	{
		cartas.remove(carta);
	}
	
	public int getNumCartas()
	{
		return cartas.size();
	}
	
	public void embaralhar() {
		Collections.shuffle(cartas);
	}
	
	@Override
	public String toString() {
		String lista = "";
		
		for(Carta c : cartas)
			lista += c + "\n";
		
		return lista;
	}
}
