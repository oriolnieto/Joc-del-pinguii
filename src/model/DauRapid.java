package model;

import java.util.ArrayList;

public class DauRapid extends Event{

    public DauRapid(int posicio, ArrayList<Jugador> jugadorsActuals, String tipoEvent, int cantidad) {
        super(posicio, jugadorsActuals, tipoEvent, cantidad);
    }
    
    @Override
    public void realitzarAccio() {
    	if(DauRapid.getCantidad() + DauLent.getCantidad() < 3) {
            setCantidad(getCantidad()+1);
    	}else {
    		System.out.println("Ja tens massa daus!!");
    	}
    }
}