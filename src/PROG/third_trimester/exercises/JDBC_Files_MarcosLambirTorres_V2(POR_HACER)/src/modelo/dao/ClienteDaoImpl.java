package modelo.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Cliente;

public class ClienteDaoImpl extends AbsGenericSQL<Cliente, String> implements IClienteDao {

	String sql;

	@Override
	public List<Cliente> findAll() {

		sql = "SELECT * FROM clientes";
		Cliente cli = null;
		List<Cliente> aux = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			/*
			 * Convertir mi 'ResultSet' en un 'ArrayList<>()' Para convertir el 'rs' en un
			 * 'ArrayList<Cliente>()', hay que iterar sobre el ResultSet dentro de un
			 * try-catch, crear un objeto Cliente por cada fila (por eso se hace dentro del
			 * bucle) y añadirlo a la lista. Luego recibimos el valor de cada columna dentro
			 * del ResultSet o RowSet, se agrega al 'aux' y se devuelve
			 */
			while (rs.next()) {
				cli = new Cliente();

				cli.setCif(rs.getString("cif"));
				cli.setNombre(rs.getString("nombre"));
				cli.setApellidos(rs.getString("apellidos"));
				cli.setDomicilio(rs.getString("domicilio"));
				cli.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cli.setNumeroEmpledos(rs.getInt("numero_empleados"));

				aux.add(cli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public Cliente findById(String atributoPK) {
		
		sql = "SELECT * FROM clientes WHERE cif = ?";
			/*
			 * Itera, nuevo Obj por vuelta (RowSet), asignación de los valores de cada campo
			 * en el Obj (setea en 'cli' y recibe de 'rs'. Todo dentro de try-catch y
			 * devolvemos obj
			 */
		Cliente cli = null;
		rs = executeR(sql, atributoPK);
		
		try {
			while (rs.next()) {
				cli = new Cliente();

				cli.setCif(rs.getString("cif"));
				cli.setNombre(rs.getString("nombre"));
				cli.setApellidos(rs.getString("apellidos"));
				cli.setDomicilio(rs.getString("domicilio"));
				cli.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cli.setNumeroEmpledos(rs.getInt("numero_empleados"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}

	@Override
	public int insertOne(Cliente obj) {

		sql = "INSERT INTO clientes () VALUES (?,?,?,?,?,?)";
			/*
			 * Itera, nuevo Obj por vuelta (RowSet), asignación de los valores de cada campo
			 * en el Obj (setea en 'cli' y recibe de 'rs'. Todo dentro de try-catch y
			 * devolvemos obj
			 */
			rowsAffected = executeCUD(sql, obj);
			
		return rowsAffected;
	}

	@Override
	public int updateOne(Cliente obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(String atributoPK) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String exportar(String nombreFichero) {
		File archivo = new File(nombreFichero);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		String msj = null;

		try {
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);

			for (Cliente ele : findAll()) {
				oos.writeObject(ele);
			}

			msj = "Clientes bien exportados";

		} catch (Exception e) {
			e.printStackTrace();
			msj = "Fichero no existe";
		}

		return msj;
	}

	@Override
	public List<Cliente> importar(String nombreFichero) {
		// TODO Auto-generated method stub
		return null;
	}

}
