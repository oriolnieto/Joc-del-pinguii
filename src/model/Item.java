package model;

public class Item {

	private String nom;
	private int cantitat;
	
	public Item(String nom, int cantitat) {
		super();
		this.nom = nom;
		this.cantitat = cantitat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCantitat() {
		return cantitat;
	}
	public void setCantitat(int cantitat) {
		this.cantitat = cantitat;
	}
	
}
