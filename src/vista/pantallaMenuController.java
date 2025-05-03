package vista;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class pantallaMenuController {
    
    public void botoSortir() {
        Platform.exit();
    }

    public void botoNovaPartida(ActionEvent event) throws IOException {

          Parent root = FXMLLoader.load(getClass().getResource("/pantallaPartida.fxml"));
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          stage.setScene(new Scene(root));
          stage.setTitle("Joc del Pingüí");
          stage.show();
    }
}