package dao;

import java.util.List;
import javabean.Employee;

public interface IEmployeeDao extends ICrudGenerico<Employee, Integer>{
	List<Employee> porDepartamento(int departamentId);
	List<Employee> porTrabajo(String jobId);
	double calcularMasaSalarial();
	double masaSalarialPorDepartamento();
	double masaSalarialPorDepartamento(int departamenId);
	List<Employee> fueraSalario();
}
