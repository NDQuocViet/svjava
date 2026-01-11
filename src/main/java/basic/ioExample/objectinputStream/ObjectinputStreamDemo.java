package basic.ioExample.objectinputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectinputStreamDemo {
	public static void main(String[] args) {

		FileInputStream input;

		FileOutputStream output;

		try {

			output = new FileOutputStream("employee.dat");

			ObjectOutputStream objectOutput = new ObjectOutputStream(output);

			Employee employee = new Employee("Loptruong", 15, 300);

			objectOutput.writeObject(employee);

			input = new FileInputStream("employee.dat");

			ObjectInputStream objectInput = new ObjectInputStream(input);

			Employee employeel = (Employee) objectInput.readObject();

			System.out.println(employeel.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
