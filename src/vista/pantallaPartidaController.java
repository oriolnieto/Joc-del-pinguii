package vista;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Casella;
import model.CasellaBuida;
import model.Event;
import model.Foca;
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
	
	public int getP1Position() {
		return p1Position;
	}

	public void setP1Position(int p1Position) {
		this.p1Position = p1Position;
	}

	@FXML
	private Circle P3;
	@FXML
	private Circle P4;


	private int p1Position = 0;
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
		ArrayList<Casella> casillas = new ArrayList<>();
	    ArrayList<Jugador> jugadors = new ArrayList<>();
	    Pingui P1 = new Pingui(p1Position, "Jugador 1", "Blau");
	    
	    jugadors.add(P1);
	    
	    Taulell t = new Taulell(casillas, jugadors, 0);

	    generarTaulell(t);
	    textTaulell(t);    
	}
	
    @FXML
	private void botoGuardar(ActionEvent event) throws IOException {

	}

	@FXML
	private void handleDado(ActionEvent event) {
		Random rand = new Random();
		
		int diceResult = rand.nextInt(6) + 1;

		dadoResultText.setText("Jugador 1 ha sacado: " + diceResult);

		moveP1(diceResult);
		
	}

	private void moveP1(int steps) {
		p1Position += steps;

		if (p1Position >= 50) {
			p1Position = 49;
		}
		
		int row = p1Position / COLUMNS;
		int col = p1Position % COLUMNS;

		GridPane.setRowIndex(P1, row);
		GridPane.setColumnIndex(P1, col);
		
	    if(p1Position == 49) {
	    	eventos.setText("Jugador 1 ha Ganado!");
	    }
	
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