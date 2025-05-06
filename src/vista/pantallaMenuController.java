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
          Parent root = FXMLLoader.load(getClass().getResource("/pantallaPartida.fxml"));
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          stage.setScene(new Scene(root));
          stage.setTitle("Joc del Pingüí");
          stage.show();
    }
}