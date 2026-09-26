
public class Fibonacci {

	public static void main(String[] args) {

		// Simple loop output:
		for (int i = 0; i < 255; i++) {
			if (0 == (i % 2)) {
				System.out.printf("Number is: %d%n", i);
			}
		}

		// Calculation with Fibonacci algorithm: 
		int result =  0; 
		int a = 0, b= 1; 
		while( 144 > result ) {
			result = a + b;
			a = b; 
			b = result; 
			
			if(0 == (result % 2)) {
				System.out.printf("Number is: %d%n", result);
			}
		}
	}
}
