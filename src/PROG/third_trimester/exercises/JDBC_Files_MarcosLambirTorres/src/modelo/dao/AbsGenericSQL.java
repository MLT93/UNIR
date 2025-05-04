package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbsGenericSQL<T, ID> {
	
	// Attributes para manejar el SQL y la info en la BBDD
    protected Connection conn; // Conexión a la BBDD
    protected PreparedStatement ps; // Quien prepara la sentencia y la ejecuta en el motor de la BBDD
    protected ResultSet rs; // Lee el fichero secuencial generado por el motor de la BBDD
    protected String sql; // La consulta SQL (opcional)
    protected int rowsAffected; // Las filas afectadas por la consulta. Esto me ayuda a determinar si ha sido exitosa o menos

    // Constructor
    public AbsGenericSQL() {
        try {
            this.conn = Singleton.getInstance().getConn(); // Acá me conecto con el Singleton

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
