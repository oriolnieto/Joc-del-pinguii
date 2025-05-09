package model;

import java.util.ArrayList;
import java.util.Random;

public class Event extends Casella{

	private String tipoEvent;
	private Inventari inv;
	private static int cantidad;
	
	public String getTipoEvent() {
		return tipoEvent;
	}

	public void setTipoEvent(String tipoEvent) {
		this.tipoEvent = tipoEvent;
	}

	public static int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Event(int posicio, ArrayList<Jugador> jugadorsActuals, String tipoEvent, int cantidad) {
		super(posicio, jugadorsActuals);
		this.tipoEvent = tipoEvent;
	}

	@Override
	public void realitzarAccio() {
		Random rand = new Random();
		
		int probabilitat;
		int numeroEvent = rand.nextInt(4);
		
		switch(numeroEvent) {
		case 0:
		    tipoEvent = "Peix";
		    probabilitat = 100;
		    break;
		  case 1:
			tipoEvent = "Boles";
			probabilitat = 100;
		    break;
		  case 2:
			probabilitat = 10;
			tipoEvent = "Dau R";
		    break;
		  case 3:
			probabilitat = 100;
			tipoEvent = "Dau L";
		    break;
		}
		
		int numeroRandom = rand.nextInt(100+1);
		
		if(numeroRandom > 10) {
			int numeroRandom2 = rand.nextInt(3);
			switch(numeroRandom2) {
			case 0:
				inv.getLlista().add(new Item ("", Peix.getCantidad())); // Afegir Peix
			    break;
			  case 1:
				  inv.getLlista().add(new Item ("Boles", Boles.getCantidad()));
			    break;
			  case 2:
				  inv.getLlista().add(new Item ("Dau Lent", DauLent.getCantidad())); // Afegir Dau Lent
			  break;
			}
		}
		else {
		inv.getLlista().add(new Item ("Dau Rapid", DauLent.getCantidad())); // Afegir Dau Ràpid.
		}
		
		
	}
	}
