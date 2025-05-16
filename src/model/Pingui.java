package model;

public class Pingui extends Jugador {

	private Inventari inv;

	public Pingui(int posicio, String nom, String color) {
		super(posicio, nom, color);
	}
	
	public Inventari getInv() {
		return inv;
	}
	public void setInv(Inventari inv) {
		this.inv = inv;
	}
	public void gestioBatalla() {
		int totalBolas  = 0;
		
		while(inv.getLlista().contains(null)) {
			totalBolas += + 1;
		}
		
	}
	public void utilitzarObjecte(Item i) {
		treureItem(i);
	}
	public void afegirItem(Item i) {
		inv.getLlista().add(i);
	}
	public void treureItem(Item i) {
		inv.getLlista().remove(i);
	}
}