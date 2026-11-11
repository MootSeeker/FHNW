import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DemoArrayPanel extends JPanel {

	// 1. 8 Bilder vom Typ Image anlegen

	private Image[] bild = new Image[8]; 
	private int[] tabelle = new int[10];

	int[][] dim2Array = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
	

	public void init() {
		setLayout(null);
		// 2. Image Objekte mit Utility.LoadResourceImage laden

		for(int i = 0; i < bild.length; i++)
		{
			bild[i] = Utility.loadResourceImage("image_" + (i + 1) + ".png"); 
		}
		
		// 3. --> Methode tabelle fuellen erstellen
		fillarray(tabelle);

		// 4. Tabelle anzeigen
		for(int i = 0; i < tabelle.length; i++) {
			System.out.println(tabelle[i]); 
		}
		
		// 5. 2dim Array als Matrix darstellen

		for(int i = 0; i < dim2Array.length; i++) {
			for(int j = 0; j < dim2Array[0].length; j++) {
				System.out.print(dim2Array[i][j] + " ");
			}
			System.out.println( ); 
		}
		
		double[] extract = getData()[0];

		System.out.println();
		
	
		

	}

	// 3. Methode fuellen erstellen
	
	private void fillarray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = 42; 
		}
	}

	private double[][] getData() {
		double[][] retval = { { 1, 2, 3, 4 }, { 0.1, 0.2, 0.3, 0.4 }, { 2, 1, 5, 3 } };
		return retval;
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		// 2. Bilder malen
		
		for(int i = 0; i < bild.length; i++)
		{
			g.drawImage(bild[i], 10 + i * 100, 200, null); 
		}
	}
}

public class DemoArrayFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private DemoArrayPanel view = new DemoArrayPanel();

	public DemoArrayFrame() {
		setTitle("Array Demo");
		view.setPreferredSize(new Dimension(1000, 600));
		add(view);
		pack();
		view.init();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DemoArrayFrame frame = new DemoArrayFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}
