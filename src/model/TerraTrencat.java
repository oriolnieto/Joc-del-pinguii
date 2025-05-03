package model;

import java.util.ArrayList;

public class TerraTrencat extends Casella {

	public TerraTrencat(int posicio, ArrayList<Jugador> jugadorsActuals) {
		super(posicio, jugadorsActuals);
		
	}

	@Override
	public void realitzarAccio() {
		int cantidadInv = 0;
		
		for(Jugador j : this.jugadorsActuals) {
			if(j instanceof Pingui) {
				Pingui p = (Pingui)j;
				cantidadInv = p.getInv().getLlista().size();
		
			}
		}
		if(cantidadInv >= 1 || 5 >= cantidadInv) {
			for(Jugador j : this.jugadorsActuals) {
				j.setTorn(false);
				
			}
		}
		else if (cantidadInv > 5) {
			for(Jugador j : this.jugadorsActuals) {
				j.setPosicio(0);
			}
		}
		
	}
}
