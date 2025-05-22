package modelo.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Cliente;

public class ClienteDaoImpl extends AbsGenericSQL<Cliente, String> implements IClienteDao {

	String sql;

	@Override
	public List<Cliente> findAll() {

		sql = "SELECT * FROM clientes;";
		Cliente cli = null;
		List<Cliente> aux = new ArrayList<>();
		try {
			ps = absConn.prepareStatement(sql);
			rs = ps.executeQuery();

			/*
			 * Convertir mi 'ResultSet' en un 'ArrayList<>()' Para convertir el 'rs' en un
			 * 'ArrayList<Cliente>()', hay que iterar sobre el ResultSet dentro de un
			 * try-catch, crear un obj Cliente por cada fila (por eso se hace dentro del
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

		sql = "SELECT * FROM clientes WHERE cif = ?;";
		/*
		 * Itera, nuevo Obj por vuelta (RowSet), asignación de los valores de cada campo
		 * en el Obj (setea en 'cli' y recibe de 'rs'. Todo dentro de try-catch y
		 * devolvemos obj
		 */
		Cliente cli = null;
		try {
			ps = absConn.prepareStatement(sql);
			rs = ps.executeQuery();

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

		sql = "INSERT INTO clientes (cif, nombre, apellidos, domicilio, facturacion_anual, numero_empleados) VALUES (?,?,?,?,?,?);";
		/*
		 * Itera, nuevo Obj por vuelta (RowSet), asignación de los valores de cada campo
		 * en el Obj (setea en 'cli' y recibe de 'rs'. Todo dentro de try-catch y
		 * devolvemos obj
		 */
		rowsAffected = 0;
		try {
			ps = absConn.prepareStatement(sql); // No me hace falta iterar el 'rs' porque el valor que se introduce es nuevo

			ps.setString(1, obj.getCif()); // Cada índice (el número) es la referencia de izq a dcha de cada VALUES correspondiente
			ps.setString(2, obj.getNombre());
			ps.setString(3, obj.getApellidos());
			ps.setString(4, obj.getDomicilio());
			ps.setDouble(5, obj.getFacturacionAnual());
			ps.setInt(6, obj.getNumeroEmpledos());

			rowsAffected = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public int updateOne(Cliente obj) {
		String sql = "update clientes set " + "nombre = ?," + "apellidos = ?," + "domicilio = ?,"
				+ "facturacion_anual = ?," + "numero_empleados = ?" + " where cif = ?;";
		rowsAffected = 0;
		try {

			ps = absConn.prepareStatement(sql);

			ps.setString(1, obj.getNombre());
			ps.setString(2, obj.getApellidos());
			ps.setString(3, obj.getDomicilio());
			ps.setDouble(4, obj.getFacturacionAnual());
			ps.setInt(5, obj.getNumeroEmpledos());
			ps.setString(6, obj.getCif());

			rowsAffected = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al actualizar el cliente");
			return -1;
		}

		return rowsAffected;
	}

	@Override
	public int deleteById(String atributoPK) {
		String sql = "DELETE FROM clientes WHERE cif = ?;";

		rowsAffected = 0;
		try {
			ps = absConn.prepareStatement(sql);
			ps.setString(1, atributoPK);

			rowsAffected = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

		return rowsAffected;
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
		File archivo = new File(nombreFichero);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Cliente> aux = new ArrayList<Cliente>();
		Cliente cli = null;

		try {

			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);

			while (true) {
				
				try {
					cli = (Cliente) ois.readObject();
					aux.add(cli);
					
				} catch (EOFException e) {
					break;
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return aux;
	}
}
