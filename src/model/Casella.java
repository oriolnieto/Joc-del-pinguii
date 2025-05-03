package model;

import java.util.ArrayList;

public abstract class Casella {

	private int posicio;
	protected ArrayList<Jugador> jugadorsActuals;
	
	public Casella(int posicio, ArrayList<Jugador> jugadorsActuals) {
		super();
		this.posicio = posicio;
		this.jugadorsActuals = jugadorsActuals;
	}
	public int getPosicio() {
		return posicio;
	}
	public void setPosicio(int posicio) {
		this.posicio = posicio;
	}
	public ArrayList<Jugador> getJugadorsActuals() {
		return jugadorsActuals;
	}
	public void setJugadorsActuals(ArrayList<Jugador> jugadorsActuals) {
		this.jugadorsActuals = jugadorsActuals;
	}
	public abstract void realitzarAccio();
	
	public void afegirJugador(Jugador j) {
		
	}
	public void treureJugador(Jugador j) {
		
	}
}
