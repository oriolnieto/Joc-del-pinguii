package model;

import java.util.ArrayList;
import java.util.Random;

public class Event extends Casella {

    private String tipoEvent;

    public String getTipoEvent() {
        return tipoEvent;
    }

    public void setTipoEvent(String tipoEvent) {
        this.tipoEvent = tipoEvent;
    }

    public Event(int posicio, ArrayList<Jugador> jugadorsActuals, String tipoEvent) {
        super(posicio, jugadorsActuals);
        this.tipoEvent = tipoEvent;
    }

    @Override
    public void realitzarAccio() {
        Random rand = new Random();
        int numeroEvent = rand.nextInt(4); // Choose an event type
        int probabilitat;
        
        // Set event type and probability
        switch (numeroEvent) {
            case 0:
                tipoEvent = "Peix";
                probabilitat = 100;
                break;
            case 1:
                tipoEvent = "Boles";
                probabilitat = 100;
                break;
            case 2:
                tipoEvent = "Dau R"; // Random dice event
                probabilitat = 10;
                break;
            case 3:
                tipoEvent = "Dau L"; // Slow dice event
                probabilitat = 100;
                break;
            default:
                tipoEvent = "Unknown";
                probabilitat = 0;
        }

        int numeroRandom = rand.nextInt(101); // From 0 to 100


            for (Jugador j : this.jugadorsActuals) {
                if (j instanceof Pingui) {
                    Pingui p = (Pingui) j;
                    Inventari i = p.getInv();

                    switch (numeroEvent) {
                        case 0: // Peix
                            i.getLlista().add(new Item("Peix", 1)); 
                            break;
                        case 1: // Boles
                            i.getLlista().add(new Item("Boles", 1)); 
                            break;
                        case 2: // Dau R (Dau Ràpid)
                            i.getLlista().add(new Item("Dau Ràpid", 1));
                            break;
                        case 3: // Dau L (Dau Lent)
                            i.getLlista().add(new Item("Dau Lent", 1));
                            break;
                    }
                }
            }
        }
    
}