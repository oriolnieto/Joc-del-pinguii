package model;

import java.util.ArrayList;

public class MotoDeNeu extends Casella{

	public MotoDeNeu(int posicio, ArrayList<Jugador> jugadorsActuals) {
		super(posicio, jugadorsActuals);
		
	}
	

	@Override
	public void realitzarAccio() {	
		/*
		for(int i = super.getPosicio()+1; 50 > i; i++) {
			if(Taulell.getCasillas[i] instanceof Trineu) {
				for(Jugador j : super.jugadorsActuals) {
					j.setPosicio(i);
				}
			}
		}*/
	}
}