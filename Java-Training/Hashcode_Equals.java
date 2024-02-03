package Others;

public class Hashcode_Equals {
	public static void main(String[] args) {
		String a = "EffiGO";
		String b = "EffiGO";

		if (a.equals(b)) {
			System.out.println(a + " & " + b + " are equal variables, and their respective hash-values are:" + " "
					+ a.hashCode() + " & " + b.hashCode());

		}

		String c = "Tata";
		String d = "TCS";

		if (!c.equals(d)) {
			System.out.println("\n" + c + " & " + d + " are unequal variables, and their respective hash-values are:"
					+ " " + c.hashCode() + " & " + d.hashCode());

		}
	}
}
