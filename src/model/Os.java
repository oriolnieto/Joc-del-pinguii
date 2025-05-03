package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Os extends Casella {

	public Os(int posicio, ArrayList<Jugador> jugadorsActuals) {
		super(posicio, jugadorsActuals);
		
	}

	@Override
	public void realitzarAccio( ) {
		for(Jugador j : this.jugadorsActuals) {
			j.setPosicio(0);
		}
	}
}
