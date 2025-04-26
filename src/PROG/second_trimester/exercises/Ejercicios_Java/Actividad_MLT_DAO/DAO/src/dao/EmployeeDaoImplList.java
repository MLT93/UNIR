package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javabean.Employee;

public class EmployeeDaoImplList implements IEmployeeDao {

	private List<Employee> lista;
	private IDepartmentDao iDepartmentDao;
	private IJobDao iJobDao;

	public EmployeeDaoImplList() {
		lista = new ArrayList<Employee>();
		iDepartmentDao = new DepartmentDaoImplList();
		iJobDao = new JobDaoImplList();

		cargarDatos();
	}

	private void cargarDatos() {
		lista.add(new Employee(114, "Esteban", "Raphaelly", "est@fp.com", "678678678", LocalDate.of(1996, 7, 7),
				iJobDao.findById("IT_PROG"), 35_000, 0.2, iDepartmentDao.findById(30)));
		lista.add(new Employee(115, "Ana", "Koo", "ana@fp.com", "678678678", LocalDate.of(1996, 7, 7),
				iJobDao.findById("IT_PROG"), 35_000, 0.2, iDepartmentDao.findById(30)));
		lista.add(new Employee(116, "carlos", "Colmenares", "carlos@fp.com", "678678678", LocalDate.of(1996, 7, 7),
				iJobDao.findById("AD_PRESS"), 135_000, 0.2, iDepartmentDao.findById(20)));

	}

	@Override
	public Employee findById(Integer atributoPk) {

		/*
		 * Por cada empleado en la lista (FOR OF en JS porque devuelve el valor en vez
		 * que el index) que sea igual al ID buscado, devuélve el empleado
		 */
		for (Employee e : lista) {
			if (e.getEmployeeId() == atributoPk)
				return e;
		}

		return null;
	}

	@Override
	public int insertOne(Employee objeto) {
		// False // Busco el ID, si es distinto a `null`, significa que existe
		if (findById(objeto.getEmployeeId()) != null) {
			return 0;
		}
		lista.add(objeto);
		// True
		return 1;
	}

	@Override
	public int updateOne(Employee objeto) {
		// Recorro la lista y donde se hacen match ambos ID, modifico el obj
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getEmployeeId() == objeto.getEmployeeId()) {
				lista.set(i, objeto);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int deleteById(Integer atributoPk) {
		/*
		 * Se usa el método que borra sólo si existe el ID específico, devolvíendo un
		 * boolean
		 */
		return lista.removeIf(e -> e.getEmployeeId() == atributoPk) ? 1 : 0;
	}

	@Override
	public int deleteObj(Employee objeto) {
		// Se usa el método que borra sólo si existe el Empleado específico
		return lista.removeIf(e -> e.equals(objeto)) ? 1 : 0;
	}

	@Override
	public List<Employee> findAll() {
		// Devuelvo un Array a partir de la lista con el tipo Employee
		return new ArrayList<Employee>(lista);
	}

	@Override
	public List<Employee> porDepartamento(int departamentId) {
		// Creo un Array para devolver los empleados que sean iguales al ID buscado
		List<Employee> aux = new ArrayList<>();

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getDepartment().getDepartmentId() != departamentId) {
				// Sigo iterando si el ID encontrado es distinto al ID buscado
				continue;
			}
			// Añado el empleado sólo si es del departamento buscado (a causa del IF)
			aux.add(lista.get(i));
		}

		return aux;
	}

	@Override
	public List<Employee> porTrabajo(String jobId) {
		// Creo un Array para devolver los empleados que sean iguales al ID buscado
		List<Employee> aux = new ArrayList<>();

		/*
		 * Por cada (FOR OF en JS porque devuelve el valor en vez que el index) empleado
		 * en la lista, Compruebo que el ID del empleado sea igual al ID buscado y lo
		 * añado al `aux` para devolver un Array
		 */
		for (Employee e : lista) {
			if (e.getJob().getJobId().equals(jobId)) {
				aux.add(e);
			}
		}

		return aux;
	}

	@Override
	public double calcularMasaSalarial() {
		/*
		 * Devuelvo una variable provisional que por cada (FOR OF en JS porque devuelve
		 * el valor en vez que el index) empleado en la lista, suma sus salarios y
		 * actualiza la variable
		 */
		double doubleVar = 0.0;

		for (Employee e : lista)
			doubleVar += e.getSalary();

		return doubleVar;
	}

	@Override
	/*
	 * No supe hacerlo sin referencia en argumento, o no entendí bien cómo devolver
	 * el dato, ya que se debería devolver un array de datos, un dato por
	 * departamento
	 */
	public double masaSalarialPorDepartamento() {
		List<Double> aux = new ArrayList<>();

		/*
		 * Por cada empleado en la lista (FOR OF en JS porque devuelve el valor en vez
		 * que el index) creo una variable del nombre del departamento y una variable
		 * para el salario del departamento
		 */
		for (Employee e : lista) {
			String strVar = e.getDepartment().getDepartmentName();
			double doubleVar = 0;

			/*
			 * Por cada empleado en la lista (FOR OF en JS porque devuelve el valor en vez
			 * que el index) si tienen el mismo departamento sumo los salarios
			 */
			/*
			 * En pocas palabras, creo 2 índices: uno para buscar (sin argumentos en la
			 * función), y el otro para ejecutar la suma dependiendo de lo que se haya
			 * encontrado en la búsqueda
			 */
			for (Employee element : lista) {
				if (element.getDepartment().getDepartmentName().equals(strVar)) {
					doubleVar += element.getSalary();
				}
			}

			aux.add(doubleVar);
		}

		return aux.stream().mapToDouble(e -> e.doubleValue()).sum();
	}

	@Override
	public double masaSalarialPorDepartamento(int departamenId) {
		/*
		 * Devuelvo la suma de los salarios después de aplicarle un filtro a un flujo
		 * stream (lo mismo que en JS)
		 */
		return lista.stream().filter(e -> e.getDepartment().getDepartmentId() == departamenId)
				.mapToDouble(e -> e.getSalary()).sum();
	}

	@Override
	public List<Employee> fueraSalario() {
		List<Employee> aux = new ArrayList<>();

		/*
		 * Por cada empleado en la lista (FOR OF en JS porque devuelve el valor en vez
		 * que el index), si el sueldo del empleado es menor al rango de sueldo sueldo
		 * mínimo, o mayor al rango de sueldo máximo, ese sueldo será un rango fuera de
		 * salario
		 */
		for (Employee e : lista) {
			if (e.getSalary() < e.getJob().getMinSalary() || e.getSalary() > e.getJob().getMaxSalary()) {
				aux.add(e);
			}
		}

		return aux;
	}

}
