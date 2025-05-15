package model;

import java.util.ArrayList;

public class Inventari {

	private ArrayList<Item> llista;

	public Inventari(ArrayList<Item> llista) {
		this.llista = llista;
	}

	public ArrayList<Item> getLlista() {
		return llista;
	}

	public void setLlista(ArrayList<Item> llista) {
		this.llista = llista;
	}
}