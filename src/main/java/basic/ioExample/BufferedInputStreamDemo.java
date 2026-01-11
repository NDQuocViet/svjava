package basic.ioExample;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

public class BufferedInputStreamDemo {

	public static void main(String arg[]) {
		String string = " this is a BufferedInputStreamDemo Demo program";
		byte buf[] = string.getBytes();

		try (ByteArrayInputStream in = new ByteArrayInputStream(buf);
				BufferedInputStream f = new BufferedInputStream(in)) {

			int c;
			while ((c = f.read()) != -1) {
				System.out.print((char) c);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}