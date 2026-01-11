package basic.ioExample;

import java.io.FileReader;

public class FileReaderDemo {

	public static void main(String args[]) {
		try (FileReader fileReader = new FileReader("/Users/hamai/Documents/My Projects/JavaBasicClass/JWF0825/src/test.txt")) {
			char[] a = new char[50];
			fileReader.read(a);
			for (char c : a) {
				System.out.print(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}