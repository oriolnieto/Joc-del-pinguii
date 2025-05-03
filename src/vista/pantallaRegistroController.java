package vista;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private void handleRegister() {
        String usuario = userField.getText();
        String contrasena = passField.getText();

        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@//oracle.ilerna.com:1521/XEPDB2", "DM2425_PIN_GRUP03", "AAANT03");

            Statement st = con.createStatement();
            String sql = "INSERT INTO JUGADORS (nickname, contrasenya, num_partida) " + "VALUES ('" + usuario + "', '" + contrasena + "', 0)";
            st.execute(sql);

            System.out.println("Registro realizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Ha habido un error en el Insert: " + e.getMessage());
        } 
    }
}