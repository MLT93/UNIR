package principales;

import java.util.List;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jdbc;
import modelo.javabeans.Cliente;

public class GestionClientes {

	private static Scanner sc;
	private static ClienteDao cliDao;

	static {
		sc = new Scanner(System.in);
		cliDao = new ClienteDaoImplMy8Jdbc();
	}

	public static void main(String[] args) {
		int opcion = 0;

		do {
			opcion = pintarMenu();

			switch (opcion) {
			case 1:
				altaCliente();
				break;
			case 2:
				buscarCliente();
				break;
			case 3:
				mostrarTodos();
				break;
			case 4:
				eliminarCliente();
				break;
			case 5:
				exportarClienteFichero();
				break;
			case 6:
				importarClienteFichero();
				break;
			}

		} while (opcion != 7);

		System.out.println("Fin del programa");

		sc.close();
	}

	public static int pintarMenu() {
		int opcion;

		System.out.println(" 1.- Alta del Cliente");
		System.out.println(" 2.- Buscar un Cliente");
		System.out.println(" 3.- Mostrar Todos");
		System.out.println(" 4.- Eliminar un cliente");
		System.out.println(" 5.- Exportar a fichero");
		System.out.println(" 6.- Importar desde fichero");
		System.out.println(" 7.- Salir");

		System.out.print("Introduce una opción, 7 para salir: ");
		opcion = sc.nextInt();

		while (opcion < 1 || opcion > 7) {
			System.out.println("Opción incorrecta, validos valores de 1 a 7");
			System.out.print("Introduce una opción: ");
			opcion = sc.nextInt();
		}

		return opcion;
	}

	public static void altaCliente() {
		Cliente cli = new Cliente();

		System.out.print("Introduce el CIF del cliente: ");
		cli.setCif(sc.next());
		System.out.print("Introduce el nombre del cliente: ");
		cli.setNombre(sc.next());
		System.out.print("Introduce los apellidos del cliente: ");
		cli.setApellidos(sc.next());
		System.out.print("Introduce el domicilio del cliente: ");
		cli.setDomicilio(sc.next());
		System.out.print("Introduce la facturacion anual del cliente: ");
		cli.setFacturacionAnual(sc.nextDouble());
		System.out.print("Introduce el numero de empleados del cliente: ");
		cli.setNumeroEmpledos(sc.nextInt());

		if (cliDao.insertOne(cli) == 1)
			System.out.println("Cliente dado de alta correctamente");
		else
			System.out.println("Error al dar de alta el cliente");

	}

	public static void buscarCliente() {
		System.out.println("Inserte el CIF del cliente a buscar: ");

		Cliente cli = cliDao.findById(sc.next());

		if (cli != null)
			System.out.println("Cliente encontrado: " + cli);
		else
			System.out.println("No se ha encontrado el cliente");
	}

	public static void mostrarTodos() {
		System.out.println("Lista de todos los clientes: ");
		List<Cliente> lista = cliDao.findAll();

		if (!lista.isEmpty()) {
			for (Cliente ele : cliDao.findAll()) {
				System.out.println(ele);
			}
		} else
			System.out.println("No hay clientes");
	}

	public static void eliminarCliente() {
		System.out.println("Inserte el CIF del cliente a eliminar: ");

		int res = cliDao.deleteById(sc.next());

		switch (res) {
			case 0 -> System.out.println("No se ha encontrado el cliente");
			case 1 -> System.out.println("Cliente eliminado correctamente");
			case -1 -> System.out.println("Error al eliminar el cliente");
		}
	}

	public static void exportarClienteFichero() {
		System.out.println("Introduce el nombre del fichero para exportar:");
		
		System.out.println(cliDao.exportar(sc.next()));
	}

	public static void importarClienteFichero() {
		System.out.println("Introduce el nombre del fichero para importar:");
		
		List<Cliente> lista = cliDao.importar(sc.next());
		
		System.out.println("Clientes importados: ");
		
		if (lista.isEmpty()) {
			
			System.out.println("No se han importado clientes");
			
		} else {
			
			for (Cliente ele : lista) {
				System.out.println(ele);
			}

		}
		
	}

}
