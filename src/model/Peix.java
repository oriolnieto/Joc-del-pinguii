package model;

import java.util.ArrayList;

public class Peix extends Event{

    public Peix(int posicio, ArrayList<Jugador> jugadorsActuals, String tipoEvent, int cantidad) {
        super(posicio, jugadorsActuals, tipoEvent, cantidad);
    }

    public void realitzarAccio() {
        setCantidad(getCantidad()+1);
    }

}