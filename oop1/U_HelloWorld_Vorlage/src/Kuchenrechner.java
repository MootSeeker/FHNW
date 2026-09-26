import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kuchenrechner {

	public static void main(String[] args) {
		// Ausgabe in der Console
		System.out.println("Kuchenrechner");

		// Aufgabe 3: Eingabe
		System.out.println("Wie viele Personen möchten Kuchen?");
		int personen = readNumber( ); 
		System.out.println("Wir brauchen Kuchen für:  " + personen);
		
		// Aufgabe 1: Kuchengewicht ermitteln
		int kuchenGewichtProPerson = 60;
		int anzahlPersonen = personen;
		float kuchenGewicht = (float) (kuchenGewichtProPerson * anzahlPersonen);

		System.out.println("Kuchengewicht [g]: " + kuchenGewicht);
		
		// Aufgabe 2: Berechnung
		int butter = 250; 
		int zucker = 250; 
		int eier = 4; 
		int mehl = 500; 
		double milch = 125e-3; 
		float backpulver = (float)16.5; 
		
		// Konstanten
		final double REFERENZ_GEWICHT = 1000.00; 
		final double rechenFaktor = kuchenGewicht / REFERENZ_GEWICHT;  
		
		float mengeButter = (float)(rechenFaktor * butter);
		float mengeZucker = (float)(rechenFaktor * zucker);
		float mengeEier = (float)((int)(rechenFaktor * eier));
		float mengeMehl = (float)(rechenFaktor * mehl);
		float mengeMilch = (float)(rechenFaktor * milch);
		float mengeBackpulver = (float)(rechenFaktor * backpulver);
		
		// Ausgabe
		System.out.println("Butter [g]: " + mengeButter);
		System.out.println("Zucker [g]: " + mengeZucker);
		System.out.println("Eier [Stk.]: " + mengeEier);
		System.out.println("Mehl [g]: " + mengeMehl);
		System.out.println("Milch [l]: " + mengeMilch);
		System.out.println("Backpulver [g]: " + mengeBackpulver);
		
	}
	
	public static int readNumber( ) {
		BufferedReader buffer = new BufferedReader( new InputStreamReader( System.in )); 
		try {
			return Integer.valueOf(buffer.readLine( )); 
		} catch ( NumberFormatException e) {
			e.printStackTrace( );
		} catch (IOException e) {
			e.printStackTrace( );
		}
		return 0; 
	}
}
