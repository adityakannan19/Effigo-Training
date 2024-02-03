package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {
	public static void main(String[] args) {

		//Array List

		List<String> fruits = new ArrayList<>();

		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");

		for (String fruit : fruits) {
			System.out.println(fruit);
		}

		//Linked-List

		List<String> animals = new LinkedList<>();

		animals.add("Dog");
		animals.add("Cat");
		animals.add("Elephant");

		for (String animal : animals) {
			System.out.println(animal);
		}
	}
}
