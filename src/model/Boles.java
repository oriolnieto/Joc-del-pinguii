package model;

import java.util.ArrayList;
import java.util.Random;

public class Boles extends Event {

    public Boles(int posicio, ArrayList<Jugador> jugadorsActuals, String tipoEvent, int cantidad) {
        super(posicio, jugadorsActuals, tipoEvent, cantidad);
    }

    @Override
    public void realitzarAccio() {
        Random rand = new Random();
        // Incrementa la cantidad entre 1 i 3 de manera aleatòria
        setCantidad(getCantidad() + (rand.nextInt(3) + 1));
    }
}
