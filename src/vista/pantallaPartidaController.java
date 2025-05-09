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
import model.DauLent;
import model.DauRapid;
import model.Event;
import model.Forat;
import model.Jugador;
import model.Os;
import model.Taulell;
import model.Trineu;
 


public class pantallaPartidaController {


    @FXML private Button dado;
    @FXML private Button rapido;
    @FXML private Button lento;
    @FXML private Button peces;
    @FXML private Button nieve;
    @FXML private Button guardar;

    // Texts
    @FXML private Text dadoResultText;
    @FXML private Text rapido_t;
    @FXML private Text lento_t;
    @FXML private Text peces_t;
    @FXML private Text nieve_t;
    @FXML private Text eventos;

    @FXML private GridPane tablero;
    @FXML private Circle P1;
    @FXML private Circle P2;
    @FXML private Circle P3;
    @FXML private Circle P4;
    
    private int p1Position = 0; // Tracks current position (from 0 to 49 in a 5x10 grid)
    private final int COLUMNS = 5;
    
    
    private void generarTaulell (Taulell t) {
    	Random rand = new Random();
    	t.getCasillas().add(new CasellaBuida (0, new ArrayList<Jugador>()));
   
    	for(int i = 1; i < 48; i++) {
    		int numRand = rand.nextInt(4)+1;
    		if(numRand == 1) {
    			t.getCasillas().add(new Os (i, new ArrayList<Jugador>()));
    			
    		}
    		else if(numRand == 2) {
    			t.getCasillas().add(new Forat (i, new ArrayList<Jugador>()));
    		}
    		else if(numRand == 3) {
    			t.getCasillas().add(new Trineu (i, new ArrayList<Jugador>()));
    		}
    		else if(numRand == 4) {
    			t.getCasillas().add(new Event (i, new ArrayList<Jugador>(), "Peix"));
    		}
    	}
    	t.getCasillas().add(new CasellaBuida (49, new ArrayList<Jugador>()));
    	
    }
    
    @FXML
    private void initialize() {
        eventos.setText("Empezo el Juego!");
        
    }

    private void botoGuardar() {
    	Random rand = new Random();
    	int diceResult = rand.nextInt(3)+1;  
    	
    	moveP1(diceResult);
    	eventos.setText("Se ha usado un dado lento! Ha salido: " + diceResult);
    }

    @FXML
    private void handleDado(ActionEvent event) {
        Random rand = new Random();
        int diceResult = rand.nextInt(6) + 1;

        // Update the Text 
        dadoResultText.setText("Ha salido: " + diceResult);

        // Update the position
        moveP1(diceResult);
    }

    private void moveP1(int steps) {
        p1Position += steps;

        //Bound player
        if (p1Position >= 50) {
            p1Position = 49; // 5 columns * 10 rows = 50 cells (index 0 to 49)
        }

        //Check row and column
        int row = p1Position / COLUMNS;
        int col = p1Position % COLUMNS;

        //Change P1 property to match row and column
        GridPane.setRowIndex(P1, row);
        GridPane.setColumnIndex(P1, col);
    }
    
    
    
    
    
    

    @FXML
    private int handleRapido(DauRapid dr) {
    	
    	int valor = dr.getCantidad();
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	if(valor > 0) {
    	Random rand = new Random();
        int diceResult = rand.nextInt(6) + 5;
        moveP1(diceResult);
    	eventos.setText("Se ha usado un dado rápido! Ha salido: " + diceResult);
    	dr.setCantidad(valor-1);
    	}
    	else {
    		eventos.setText("No tienes suficientes dados rápidos!");
    	}
    	try {
    		conn = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.ilerna.com:1521/XEPDB2", "DM2425_PIN_GRUP03", "AAANT03");
    		
    		stmt = conn.createStatement();
    		String sql = "SELECT DAUS_RAPIDS FROM INVENTARI";
    	}
    	catch {
    		
    	}
    	
    	return valor;
    }
    

    @FXML
    private void handleLento(DauLent dl) {
    	int valor = dl.getCantidad(); 
    	
    	if(valor > 0) {
    	Random rand = new Random();
    	int diceResult = rand.nextInt(3)+1;  
    	moveP1(diceResult);
    	eventos.setText("Se ha usado un dado lento! Ha salido: " + diceResult);
    	dl.setCantidad(valor-1);
    	}
    	else {
    		eventos.setText("No tienes suficientes dados lentos!");
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
    
    private void handleGuardar() {
    	

    	
    }
}