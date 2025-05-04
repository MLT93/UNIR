package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbsGenericSQL<T, ID> {
	
	// Attributes para manejar el SQL y la info en la BBDD
    protected Connection conn;    
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
    
    /*  
     * Evita la inyección SQL asignando a cada '?' (que según su asignación se le atribuye un número como índice, 
     * empezando por el 1, luego el 2, el 3, 4, 5, etc...). Entonces, recorre los parámetros y los asigna a 'ps' 
     * usando un 'setObject' que permite la asignación genérica para varios interrogantes
    */
    private void setValueInterroganteQuery(PreparedStatement ps, Object... valueInterroganteQuery) throws SQLException {
        for (int i = 0; i < valueInterroganteQuery.length; i++) {
            ps.setObject(i + 1, valueInterroganteQuery[i]);
        }
    }

    // Ejecutar queries SQL, devolver resultados para SELECT (GET + WHERE)
    public ResultSet executeR(String sql, Object... valueInterroganteQuery) {
        try {
            ps = conn.prepareStatement(sql);
            setValueInterroganteQuery(ps, valueInterroganteQuery);
            rs = ps.executeQuery(); // Devuelve el rs listo para iterar con 'executeQuery'
            return rs;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
     
    // Ejecutar queries SQL, devolver resultados para INSERT, UPDATE, DELETE (POST, PUT, DELETE)
    public int executeCUD(String sql, Object... valueInterroganteQuery) {
        try {
            ps = conn.prepareStatement(sql);
            setValueInterroganteQuery(ps, valueInterroganteQuery);
            rowsAffected = ps.executeUpdate(); // Devuelvo las filas afectadas con 'executeUpdate'
            return rowsAffected;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
