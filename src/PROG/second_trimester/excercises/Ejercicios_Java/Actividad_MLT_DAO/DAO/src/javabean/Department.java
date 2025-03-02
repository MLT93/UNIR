package javabean;

public class Department {

	private int departmentId;
	private String departmentName;
	private Employee manager;
	private int cuantityEmployees;
	private Location location;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getCuantityEmployees() {
		return cuantityEmployees;
	}

	public void setCuantityEmployees(int cuantityEmployees) {
		this.cuantityEmployees = cuantityEmployees;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Department)) {
			return false;
		}
		Department other = (Department) obj;
		if (departmentId != other.departmentId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", manager="
				+ manager + ", cuantityEmployees=" + cuantityEmployees + ", location=" + location + "]";
	}

	public Department(int departmentId, String departmentName, Employee manager, int cuantityEmployees,
			Location location) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.manager = manager;
		this.cuantityEmployees = cuantityEmployees;
		this.location = location;
	}

	public Department() {
		super();
	}
}