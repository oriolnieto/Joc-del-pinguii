package model;

import java.util.ArrayList;

public class Taulell {

	ArrayList<Casella> casillas;
	ArrayList<Jugador> jugadors;
	private int rondas;
	private Jugador jugadorActual;
	
	
	public Taulell(ArrayList<Casella> casillas, ArrayList<Jugador> jugadors, int rondas, Jugador jugadorActual) {
		this.casillas = casillas;
		this.jugadors = jugadors;
		this.rondas = rondas;
		this.jugadorActual = jugadorActual;
	}
	public ArrayList<Casella> getCasillas() {
		return casillas;
	}
	public void setCasillas(ArrayList<Casella> casillas) {
		this.casillas = casillas;
	}
	public ArrayList<Jugador> getJugadors() {
		return jugadors;
	}
	public void setJugadors(ArrayList<Jugador> jugadors) {
		this.jugadors = jugadors;
	}
	public int getRondas() {
		return rondas;
	}
	public void setRondas(int rondas) {
		this.rondas = rondas;
	}
	public Jugador getJugadorActual() {
		return jugadorActual;
	}
	public void setJugadorActual(Jugador jugadorActual) {
		this.jugadorActual = jugadorActual;
	}
	
	public void actualitzarTaulell () {
		
	}
	
	
	public void actualitzarJugador (Jugador j) {
		
	}
	
}
