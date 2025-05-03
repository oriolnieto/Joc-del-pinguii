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
        String username = userField.getText();
        String password = passField.getText();


        Parent root = FXMLLoader.load(getClass().getResource("/pantallaMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Joc del Pingüí");
        stage.show();
    }

}