package model;

import java.util.ArrayList;

public class Peix extends Event{

    public Peix(int posicio, ArrayList<Jugador> jugadorsActuals, String tipoEvent, int cantidad) {
        super(posicio, jugadorsActuals, tipoEvent, cantidad);
    }

    @Override
    public void realitzarAccio() {
    	if(getCantidad() < 2) {
            setCantidad(getCantidad()+1);
    	}else {
    		System.out.println("Ja tens massa peixos!!");
    	}
    }

}