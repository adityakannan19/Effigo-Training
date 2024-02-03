package Collections;

import java.util.HashSet;
import java.util.Set;

public class Sets {
	public static void main(String[] args) {

		Set<String> colors = new HashSet<>();

		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");

		for (String color : colors) {
			System.out.println(color);
		}
	}
}
