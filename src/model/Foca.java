package model;

public class Foca extends Jugador {
	
	private boolean soborn;

	public Foca(int posicio, String nom, String color, boolean soborn) {
		super(posicio, nom, color);
		this.soborn = soborn;
	}

	public boolean isSoborn() {
		return soborn;
	}

	public void setSoborn(boolean soborn) {
		this.soborn = soborn;
	}
	
	public void aplastarJugador(Pingui p) {		
		for (int i = 0; i < p.getInv().getLlista().size()/2; i++) {
			p.getInv().getLlista().remove(i);
		}
	}
	public void pegarJugador(Pingui p) {
		p.setPosicio(p.getPosicio() - 1);
	}
	public void esSoborn() {
		soborn = true;
	}
}