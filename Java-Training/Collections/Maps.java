package Collections;

import java.util.HashMap;
import java.util.Map;

public class Maps {
	public static void main(String[] args) {

		Map<String, Integer> studentScores = new HashMap<>();

		studentScores.put("Aditya", 100);
		studentScores.put("John", 85);
		studentScores.put("Bob", 95);

		for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
