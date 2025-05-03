package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;

import model.Taulell;

public class gestorPartides {
	private static String linkBBDD = "jdbc:oracle:thin:@//192.168.3.26:1521/XEPDB2";
	private static String username = "DM2425_PIN_GRUP03";
	private static String password = "AAANT03";
	
	public gestorPartides(String linkBBDD, String username, String password) {
		gestorPartides.linkBBDD=linkBBDD;
		gestorPartides.username=username;
		gestorPartides.password=password;
	}
	public String getLinkBBDD() {
		return linkBBDD;
	}
	public void setLinkBBDD(String linkBBDD) {
		gestorPartides.linkBBDD = linkBBDD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		gestorPartides.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		gestorPartides.password = password;
	}
	
	public Taulell carregarPartida() {
		return null;
	}
	public void guardarPartida(Taulell t) {
		
	}
	
	private static Connection conectarBD() {
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

}