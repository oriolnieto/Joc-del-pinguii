package vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class pantallaLoginController {

    @FXML private MenuItem newGame;
    @FXML private MenuItem saveGame;
    @FXML private MenuItem loadGame;
    @FXML private MenuItem quitGame;

    @FXML private TextField userField;
    @FXML private PasswordField passField;

    @FXML private Button loginButton;
    @FXML private Button registerButton;

    @FXML
    public void switchRegistro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/pantallaRegistro.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Joc del Pingüí");
        stage.show();
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
    	String usuario = userField.getText();
    	String contrasena = passField.getText();

    	Connection con = null;
    	Statement st = null;
    	ResultSet rs = null;

    	try {
    	    con = DriverManager.getConnection( "jdbc:oracle:thin:@//oracle.ilerna.com:1521/XEPDB2", "DM2425_PIN_GRUP03", "AAANT03");

    	    st = con.createStatement();
    	    String sql = "SELECT * FROM JUGADORS WHERE NICKNAME = '" + usuario + "' AND CONTRASENYA = '" + contrasena + "'";
    	    rs = st.executeQuery(sql);

    	    if (rs.next()) {
    	    	Parent root = FXMLLoader.load(getClass().getResource("/pantallaMenu.fxml"));
    	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	        stage.setScene(new Scene(root));
    	        stage.setTitle("Joc del Pingüí");
    	        stage.show();
    	        System.out.println("Acceso Garantido");
    	    } else {
    	        System.out.println("Credenciales Incorrectas");
    	    }

    	} catch (SQLException e) {
    	    System.out.println("Ha habido un error en el acceso " + e.getMessage());
    	}
}
}