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
        int numeroEvent = rand.nextInt(4);


        for (Jugador j : this.jugadorsActuals) {
            if (j instanceof Pingui) {
                Pingui p = (Pingui) j;
                Inventari i = p.getInv();
                ArrayList<Item> llista = i.getLlista();

                if (numeroEvent == 0) {
                    int count = 0;
                    for (Item it : llista) {
                        if (it.getNom().equals("Peix")) {
                            count = it.getCantitat();
                        }
                    }
                    if (count < 2) 
                    llista.add(new Item("Peix", 1));
                }

                else if (numeroEvent == 1) {
                    int count = 0;
                    for (Item it : llista) {
                        if (it.getNom().equals("Boles")) {
                            count += it.getCantitat();
                        }
                    }
                    int afegir = rand.nextInt(3) + 1;
                    if (count < 6) {
                        llista.add(new Item("Boles", afegir));
                    }
                }

                else if (numeroEvent == 2 || numeroEvent == 3) {
                    int count = 0;
                    for (Item it : llista) {
                        if (it.getNom().equals("Dau Rapid") || it.getNom().equals("Dau Lent")) {
                            count += it.getCantitat();
                        }
                    }

                    if (count < 3) {
                        if (numeroEvent == 2) {
                            llista.add(new Item("Dau Rapid", 1));
                        } else {
                            llista.add(new Item("Dau Lent", 1));
                        }
                    }
                }
            }
        }
    }        
}