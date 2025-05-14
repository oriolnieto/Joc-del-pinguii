package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.Casella;
import model.CasellaBuida;
import model.Event;
import model.Forat;
import model.Inventari;
import model.Item;
import model.Jugador;
import model.Os;
import model.Pingui;
import model.Taulell;
import model.Trineu;

public class pantallaPartidaController {

	@FXML
	private Button dado;
	@FXML
	private Button rapido;
	@FXML
	private Button lento;
	@FXML
	private Button peces;
	@FXML
	private Button nieve;
	@FXML
	private Button guardar;

	// Texts
	@FXML
	private Text dadoResultText;
	@FXML
	private Text rapido_t;
	@FXML
	private Text lento_t;
	@FXML
	private Text peces_t;
	@FXML
	private Text nieve_t;
	@FXML
	private Text eventos;

	@FXML
	private GridPane tablero;
	@FXML
	private Circle P1;
	@FXML
	private Circle P2;
	@FXML
	private Circle P3;
	@FXML
	private Circle P4;


	private int p1Position = 0; // Tracks current position (from 0 to 49 in a 5x10 grid)
	private int p2Position = 0;
	public int numTurnos = 0;
	private final int COLUMNS = 5;

	private void generarTaulell(Taulell t) {
		Random rand = new Random();
		t.getCasillas().add(new CasellaBuida(0, new ArrayList<Jugador>()));

		for (int i = 1; i < 49; i++) {
			int numRand = rand.nextInt(4) + 1;
			if (numRand == 1) {
				t.getCasillas().add(new Os(i, new ArrayList<Jugador>()));
			} else if (numRand == 2) {
				t.getCasillas().add(new Forat(i, new ArrayList<Jugador>()));
			} else if (numRand == 3) {
				t.getCasillas().add(new Trineu(i, new ArrayList<Jugador>()));
			} else if (numRand == 4) {
				t.getCasillas().add(new Event(i, new ArrayList<Jugador>()));
			}
		}
		t.getCasillas().add(new CasellaBuida(50, new ArrayList<Jugador>()));

	}
	
	
	private void textTaulell(Taulell t) {
		for (int i = 0; i < t.getCasillas().size(); i++) {
			Casella casella = t.getCasillas().get(i);
			String tipus = casella.getClass().getSimpleName();
			
			if (tipus.equals("CasellaBuida")) {
	            continue;
	        }

			int row = i / COLUMNS;
			int col = i % COLUMNS;

			Text tx = new Text(tipus);
		     tx.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;"); 
		        tx.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
		        tx.setWrappingWidth(250);
		       
			GridPane.setRowIndex(tx, row);
			GridPane.setColumnIndex(tx, col);
			tablero.getChildren().add(tx);

		}
	}
	@FXML
	private void initialize() {
		eventos.setText("Jugador 1 es tu turno!");
		ArrayList<Casella> casillas = new ArrayList<>();
	    ArrayList<Jugador> jugadors = new ArrayList<>();
	    Pingui P1 = new Pingui(p1Position, "Jugador 1", "Blau");
	    Pingui P2 = new Pingui(p2Position, "Jugador 2", "Roig");
	    jugadors.add(P1);
	    jugadors.add(P2);

	    
	    Taulell t = new Taulell(casillas, jugadors, 0);

	    generarTaulell(t);
	    textTaulell(t);
	    
	 
	    
	    if (p1Position == p2Position && p1Position == 0) {
	    	int quantitatBolesP1 = 0;
	   	    int quantitatBolesP2 = 0;
	   	    int diferenciaBoles = 0;
	   	    
	    	for (int i = 0; i < P1.getInv().getLlista().size(); i++) {
				if (P1.getInv().getLlista().get(i).getNom().equals("Boles")) {
					if (P1.getInv().getLlista().get(i).getCantitat() > 0) {
						quantitatBolesP1++;
						P1.getInv().getLlista().remove(i);
					}
				}
	    	}
	    	
	    	for (int i = 0; i < P2.getInv().getLlista().size(); i++) {
				if (P2.getInv().getLlista().get(i).getNom().equals("Boles")) {
					if (P2.getInv().getLlista().get(i).getCantitat() > 0) {
						quantitatBolesP2++;
						P2.getInv().getLlista().remove(i);
					}
				}
	    	}
	    	
	    	if(quantitatBolesP1 > quantitatBolesP2) {
	    		eventos.setText("Ha ganado la batalla el Jugador 1!");
	    		diferenciaBoles = quantitatBolesP1 - quantitatBolesP2;
	    		moveP1(diferenciaBoles);
	    	}
	    	else {
	    		eventos.setText("Ha ganado la batalla el Jugador 2!");
	    		diferenciaBoles = quantitatBolesP2 - quantitatBolesP1;
	    		moveP2(diferenciaBoles);
	    	}
	    	}
	}
	
    @FXML
	private void botoGuardar() {

	}

	@FXML
	private void handleDado(ActionEvent event) {
		Random rand = new Random();
		
		if(numTurnos % 2 == 0) {
		int diceResult = rand.nextInt(6) + 1;

		// Update the Text-
		dadoResultText.setText("Jugador 1 ha sacado: " + diceResult);
		eventos.setText("Jugador 1 es tu turno!");

		// Update the position
		moveP1(diceResult);
		}
		else {
			int diceResult = rand.nextInt(6) + 1;

			// Update the Text
			dadoResultText.setText("Jugador 2 ha sacado: " + diceResult);
			eventos.setText("Jugador 2 es tu turno!");

			// Update the position
			moveP2(diceResult);
		}
		numTurnos++;
	}

	private void moveP1(int steps) {
		p1Position += steps;

		// Bound player
		if (p1Position >= 50) {
			p1Position = 49; // 5 columns * 10 rows = 50 cells (index 0 to 49)
		}

		// Check row and column
		int row = p1Position / COLUMNS;
		int col = p1Position % COLUMNS;

		// Change P1 property to match row and column
		GridPane.setRowIndex(P1, row);
		GridPane.setColumnIndex(P1, col);
	}
	
	private void moveP2(int steps) {
		p2Position += steps;

		// Bound player
		if (p2Position >= 50) {
			p2Position = 49; // 5 columns * 10 rows = 50 cells (index 0 to 49)
		}

		// Check row and column
		int row = p2Position / COLUMNS;
		int col = p2Position % COLUMNS;

		// Change P1 property to match row and column
		GridPane.setRowIndex(P2, row);
		GridPane.setColumnIndex(P2, col);
	}

	@FXML
	private void handleRapido(Inventari inv) {
		for (int i = 0; i < inv.getLlista().size(); i++) {
			if (inv.getLlista().get(i).getNom().equals("Dau Rapid")) {
				if (inv.getLlista().get(i).getCantitat() > 0) {
					Random rand = new Random();
					int diceResult = rand.nextInt(6) + 5;
					moveP1(diceResult);
					eventos.setText("Se ha usado un dado rápido! Ha salido: " + diceResult);
					inv.getLlista().get(i).setCantitat(inv.getLlista().get(i).getCantitat() - 1);
				} else {
					eventos.setText("No tienes suficientes dados rápidos!");
				}

			}
		}
	}

	@FXML
	private void handleLento(Inventari inv) {
		for(int i = 0; i < inv.getLlista().size(); i++) {
			if (inv.getLlista().get(i).getNom().equals("Dau Lent")) {
				if (inv.getLlista().get(i).getCantitat() > 0) {
					Random rand = new Random();
					int diceResult = rand.nextInt(3) + 1;
					moveP1(diceResult);
					eventos.setText("Se ha usado un dado lento! Ha salido: " + diceResult);
					inv.getLlista().get(i).setCantitat(inv.getLlista().get(i).getCantitat() - 1);
				} else {
					eventos.setText("No tienes suficientes dados lentos!");
			}
		}
	}
}

	@FXML
	private void handlePeces() {
		System.out.println("Fish.");

	}

	@FXML
	private void handleNieve() {
		System.out.println("Snow.");
		// TODO
	}
}