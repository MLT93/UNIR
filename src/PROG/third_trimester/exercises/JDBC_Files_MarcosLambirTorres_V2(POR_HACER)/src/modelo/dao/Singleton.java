package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	
	static Singleton instance; // La única instancia de la conexión porque el constructor es privado
	
	private Connection conn; // Sirve para establecer la conexión con DriverManager a la BBDD
	private final String HTTP = "jdbc:mysql://localhost:3306/mi_db"; // Dirección de la BBDD
	private final String USER = "user"; // Usuario de la BBDD
	private final String PASS = "password"; // Pass del usuario de la BBDD
	
	// Constructor privado
    private Singleton() {
    	super();
    	
        try {
            conn = DriverManager.getConnection(HTTP, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	if (conn != null) {
        		System.out.println("Conexión establecida");
        	}
        }
    }

	public static Singleton getInstance() throws SQLException { // Función encargada de entregar el objeto con la conexión a la BBDD
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public Connection getConn() {
		return conn;
	}

	public String getHTTP() {
		return HTTP;
	}

	public String getUSER() {
		return USER;
	}

	public String getPASS() {
		return PASS;
	}
}
