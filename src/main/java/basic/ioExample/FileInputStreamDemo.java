package basic.ioExample;

import java.io.FileInputStream;

public class FileInputStreamDemo {

	public static void main(String arg[]) {
		int i;
		char c;
//		File file = new File("test.txt");
//		System.out.println(file.getPath());
		
		try (FileInputStream f = new FileInputStream("/Users/hamai/Documents/My Projects/JavaBasicClass/JWF0825/src/test.txt")) {
			while ((i = f.read()) != -1) {
				c = (char) i;
				System.out.print(c);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
