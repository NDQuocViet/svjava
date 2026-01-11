package basic.ioExample;

import java.io.FileOutputStream;

public class FileOutputSteamDemo {
	public static void main(String[] args) {

		try {
			FileOutputStream output = new FileOutputStream("TestOuptput.txt");
			String str = "Lap trinh Java";
			output.write(str.getBytes());
			output.flush();
			output.close();
		} catch (Exception r) {
			r.printStackTrace();
		}
	}
}