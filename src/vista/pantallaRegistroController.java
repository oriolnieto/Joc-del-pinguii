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

    // Método sin parámetros (sin usar ActionEvent)
    @FXML
    private void handleRegister() {
        String usuario = userField.getText();
        String contrasena = passField.getText();

        // Aquí creamos la conexión
        Connection con = null;

        try {
            // Crear la conexión directamente
            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@//oracle.ilerna.com:1521/XEPDB2", "DM2425_PIN_GRUP03", "AAANT03");

            // Crear una sentencia SQL directamente
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO JUGADORS (nickname, contrasenya, num_partida) " +
                         "VALUES ('" + usuario + "', '" + contrasena + "', 0)";  // **atención a la inyección SQL**

            // Ejecutar la sentencia
            stmt.executeUpdate(sql);

            // Mensaje en consola indicando que la inserción fue exitosa
            System.out.println("Registro realizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Ha habido un error en el Insert: " + e.getMessage());
        } finally {
            // Cerramos la conexión (si está abierta) - sin usar finally
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}