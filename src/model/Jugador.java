package model;

public abstract class Jugador {

	private int posicio;
	private String nom;
	private String color;
	private boolean torn;
	
	public Jugador(int posicio, String nom, String color) {
		this.posicio = posicio;
		this.nom = nom;
		this.color = color;
		this.torn = true;
	}

	
	public boolean isTorn() {
		return torn;
	}
	public void setTorn(boolean torn) {
		this.torn = torn;
	}
	public int getPosicio() {
		return posicio;
	}
	public void setPosicio(int posicio) {
		this.posicio = posicio;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
