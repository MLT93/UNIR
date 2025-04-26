package test;

import java.time.LocalDate;

import javabean.Country;
import javabean.Department;
import javabean.Employee;
import javabean.Job;
import javabean.Location;
import javabean.Region;

public class TestEmpresa {

	public static void main(String[] args) {
		Region region1 = new Region(1, "Europa");
		Country esp = new Country("SP", "España", region1);
		Location loc1500 = new Location(1500, "Pez 3", "28007", "Madrid", "28", esp);
		Job job1 = new Job("IT_PROG", "Analista Programador", 19000, 35000);
		Department dep30 = new Department(30, "Ventas", null, 110, loc1500);

		Employee emp117 = new Employee(117, "Marquitos", "El Bueno", "melbueno@test.com", "602349987",
				LocalDate.of(2000, 4, 12), job1, 40000, 0.5, dep30);
		Employee emp116 = new Employee(116, "Eva", "baida", "eva@fp.com", "678667777", LocalDate.of(1995, 3, 15), job1,
				25000, 0.3, dep30);
		dep30.setManager(emp117);


		System.out.println("*************** *********** *****************");
		System.out.println("DESDE EMP116 : mi apellido, mi trabajo y nombre de mi departamento");

		System.out.println(emp116.getLastName());
		System.out.println(emp116.getJob().getJobTitle());
		System.out.println(emp116.getDepartment().getDepartmentName().toUpperCase());

		System.out.println("*************** *********** *****************");
		System.out.println(
				"DESDE EMP116 : mi apellido y el apellido de mi manager");
		System.out.println(emp116.getLastName());
		System.out.println(emp116.getDepartment().getManager().getLastName());

		System.out.println("*************** *********** *****************");
		System.out.println("DESDE EMP116 : mi nombre de region");
		System.out.println(emp116.getDepartment().getLocation().getCountry().getRegion().getRegionName());

		System.out.println("*************** *********** *****************");
		System.out.println("DESDE EMP116 : la region del departamento");
		System.out.println(emp116.getDepartment().getLocation().getCountry().getRegion().getRegionName());
		System.out.println("a partir del empleado 114 sacar el apellido de su jefe");

		System.out.println("*************** *********** *****************");
		System.out.println(job1);
		System.out.println(loc1500);
		System.out.println(emp116);

	}

}
