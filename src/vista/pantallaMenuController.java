package vista;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class pantallaMenuController {
    
	 public void botoSortir(ActionEvent event) throws IOException {

         Parent root = FXMLLoader.load(getClass().getResource("/pantallaLogin.fxml"));
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(new Scene(root));
         stage.setTitle("Joc del Pingüí");
         stage.show();
   }

    public void botoNovaPartida(ActionEvent event) throws IOException {
    	Connection con = null;
    	Statement st = null;
    	ResultSet rs = null;

    	try {
    	    con = DriverManager.getConnection( "jdbc:oracle:thin:@//oracle.ilerna.com:1521/XEPDB2", "DM2425_PIN_GRUP03", "AAANT03");
       	 String inventari = "INSERT INTO INVENTARI (id_inventari, peixos, boles_neu, daus_rapids, daus_lents, nickname_inventari, id_partida_inventari) " + "VALUES ('id_inventari.NEXTVAL', 0, 0, 0, 0, nickname_inventari, id_partida_inventari)";
       	 String partida = "INSERT INTO PARTIDES (id_partida, data_partida, hora_partida) " + "VALUES ('id_partida.NEXTVAL,TRUNC(SYSDATE), TO_CHAR(SYSDATE, 'HH24:MI:SS'))";
    	    st = con.createStatement();
    	    rs = st.executeQuery(inventari);
    	    rs = st.executeQuery(partida);
    	} catch (SQLException e) {
    	    System.out.println("Ha habido un error en el acceso " + e.getMessage());
    	}
          Parent root = FXMLLoader.load(getClass().getResource("/pantallaPartida.fxml"));
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          stage.setScene(new Scene(root));
          stage.setTitle("Joc del Pingüí");
          stage.show();
    }
}