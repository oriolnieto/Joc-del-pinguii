package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class main extends Application  {
	private static String linkBBDD = "jdbc:oracle:thin:@//oracle.ilerna.com:1521/XEPDB2";
	private static String username = "DM2425_PIN_GRUP03";
	private static String password = "AAANT03";
//aa
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//System.out.println(getClass().getResource("/pantallaPrincipal.fxml"));
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaPartida.fxml"));
	    Parent root = loader.load();

	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Joc del Pingüí");
	    primaryStage.show();
	}

	public static Connection conectarBD() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(linkBBDD, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("No s'ha trobat el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credencials o en la URL " + e);
		}

		System.out.println("Connexió efectuada a la base de dades.");

		return con;
	}

    public static void main(String[] args) {
    	launch(args);
    }
}