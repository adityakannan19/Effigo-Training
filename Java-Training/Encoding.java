package Others;

import java.util.Arrays;

public class Encoding {
	public static void main(String[] args) {
		String str = "Hello, World!";

		byte[] byteArray = str.getBytes();

		System.out.println("Byte array: " + Arrays.toString(byteArray));
	}
}
