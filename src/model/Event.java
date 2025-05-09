package model;

import java.util.ArrayList;
import java.util.Random;

public class Event extends Casella {

    public Event(int posicio, ArrayList<Jugador> jugadorsActuals) {
        super(posicio, jugadorsActuals);
    }

    @Override
    public void realitzarAccio() {
        Random rand = new Random();
        int numeroEvent = rand.nextInt(4); // Choose an event type

        int numeroRandom = rand.nextInt(101); // From 0 to 100


            for (Jugador j : this.jugadorsActuals) {
                if (j instanceof Pingui) {
                    Pingui p = (Pingui) j;
                    Inventari i = p.getInv();

                    switch (numeroEvent) {
                        case 0: 
                            i.getLlista().add(new Item("Peix", 1)); 
                            break;
                        case 1: 
                            i.getLlista().add(new Item("Boles", rand.nextInt(3)+1)); 
                            break;
                        case 2:
                            i.getLlista().add(new Item("Dau Ràpid", 1));
                            break;
                        case 3:
                            i.getLlista().add(new Item("Dau Lent", 1));
                            break;
                    }
                }
            }
        }
    
}