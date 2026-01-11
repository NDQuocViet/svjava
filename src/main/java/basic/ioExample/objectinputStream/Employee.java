package basic.ioExample.objectinputStream;

import java.io.Serializable;

public class Employee implements Serializable {
	private String name;
	private int experience;
	private double salary;

	@Override
	public String toString() {
		return "name=" + name + ", experience=" + experience + ", salary=" + salary;
	}

	public Employee(String name, int experience, double salary) {

		this.name = name;
		this.experience = experience;
		this.salary = salary;
	}

	public Employee() {

	}

}
