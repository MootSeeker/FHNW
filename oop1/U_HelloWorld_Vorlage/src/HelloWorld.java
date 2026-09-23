public class HelloWorld {
	public static void main(String[] args) {
		/* --- Hello World Output to Console --- */
		System.out.println("Hello World! Yelling from Java.");

		/* --- Variables and simple loop --- */
		int a = 5;
		int result = 0;

		for (int i = 0; i < 5; i++) {
			System.out.println("Part result: " + (result += a));
		}
		System.out.println("The final Result is: " + result);

		/* --- Scientific Number written in Java Code --- */
		float scientificNumbers = (float) 42.42e-3;
		System.out.printf("Float Number in Scientific: %.3f%n", scientificNumbers);
		scientificNumbers = (float) 424.42e-3;
		System.out.printf("Float Number in Scientific: %.3f%n", scientificNumbers);

		/* --- Special Java rules --- */
		final double G = 9.81; // final is the same as const in C variable can not change it's value

		/* --- Type Casting in Java --- */
		// Generally the same as in C/C++
		float fNumber = a; // int into float
		double dNumber = fNumber; // Compiler doesn't like that one
		fNumber = (float) 12.25;
		fNumber = (float) 12.12e-3;
		a = (int) fNumber; // Type cast from float into in (cuts everything after ',')

		/* --- Simple loop --- */
		int n = 0;
		while (n < 10) {
			System.out.println("Simple loop: " + (n++));
		}

		for (n = 0; n < 10; n++) {
			System.out.println("Simple loop: " + n);
		}
	}
}
