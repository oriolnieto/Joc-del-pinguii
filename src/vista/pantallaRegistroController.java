package vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class pantallaRegistroController {

    @FXML private MenuItem newGame;
    @FXML private MenuItem saveGame;
    @FXML private MenuItem loadGame;
    @FXML private MenuItem quitGame;

    @FXML private TextField userField;
    @FXML private PasswordField passField;

    @FXML private Button loginButton;
    @FXML private Button registerButton;


    @FXML
    private void handleRegister(Connection con) {
    	try {
			Statement st = con.createStatement();
			st.execute("INSERT INTO JUGADORS (nickname, contrassenya, num_partida) VALUES (" + userField.getText() + ", " + passField.getText() + ", 0);");
			
			System.out.println("Insert hecho correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
	}
    }