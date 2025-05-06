package vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class pantallaRegistroController {

    @FXML
    private TextField userField;
    @FXML
    private PasswordField passField;

    @FXML
    public void switchAtras(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/pantallaLogin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Joc del Pingüí");
        stage.show();
    }
    @FXML
    private void handleRegister() {
        String usuario = userField.getText();
        String contrasena = passField.getText();

        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.ilerna.com:1521/XEPDB2", "DM2425_PIN_GRUP03", "AAANT03");

            Statement st = con.createStatement();
            String jugadors = "INSERT INTO JUGADORS (nickname, contrasenya, num_partida) " + "VALUES ('" + usuario + "', '" + contrasena + "', 0)";
            st.execute(jugadors);

            System.out.println("Registro realizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Ha habido un error en el Insert: " + e.getMessage());
        } 
    }
}