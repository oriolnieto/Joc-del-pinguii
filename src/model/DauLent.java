package model;

import java.util.ArrayList;

public class DauLent extends Event{

	public DauLent(int posicio, ArrayList<Jugador> jugadorsActuals, String tipoEvent, int cantidad) {
		super(posicio, jugadorsActuals, tipoEvent,cantidad);
		
	}
	
	@Override
	public void realitzarAccio() {
		setCantidad(getCantidad()+1);
	}
	}