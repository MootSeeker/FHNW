import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

class ArrayPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextArea data = new JTextArea();
	private final int DIM = 3;
	private int[][] matrixA;
	private int[][] matrixB;
	private int[][] matrixResult;

	public void init() {
		setLayout(null);

		data.setFont(new Font("monospaced", Font.BOLD, 16));
		add(data).setBounds(5, 5, 300, 300);

	}

	public void actionPerformed(ActionEvent e) {
		
	}

	private void showResult() {
		data.setText("");// löscht das TextArea
		data.append("Matrix A: \r\n");
		for (int row = 0; row < DIM; row++) {
			for (int col = 0; col < DIM; col++) {
				data.append(String.format("%3d", matrixA[row][col]) + " ");// macht 3 Stellen aus jedem Feld so dass
																			// Einer untereinander stehen
			}
			data.append("\r\n");
		}

		data.append("Matrix B: \r\n");
		for (int row = 0; row < DIM; row++) {
			for (int col = 0; col < DIM; col++) {
				data.append(String.format("%3d", matrixB[row][col]) + " ");
			}
			data.append("\r\n");
		}

		data.append("\r\n Result: \r\n");
		for (int row = 0; row < DIM; row++) {
			for (int col = 0; col < DIM; col++) {
				data.append(String.format("%3d", matrixResult[row][col]) + " ");
			}
			data.append("\r\n");
		}

	}
	

	/**
	 * <pre>
	 * Berechnung und Darstellug Pascalsches Dreieck 
	 * - 2D int array triangle mit 7 Zeilen anlegen 
	 * - TexArea loeschen 
	 * - fuer row von 0 bis kleiner Laenge von triangle
	 * 	  - Spalte in triangle[row] mit Laenge row+1 erzeugen 
	 *    - fuer col von 0 bis kleiner gleich row
	 *      - falls col gleich 0 oder col gleich row:
	 *        - triangle Element auf eins setzen 
	 *      - sonst:
	 *        - triangle Element auf triangle[row - 1][col - 1] + triangle[row - 1][col] setzen 
	 *      - triangle Element anzeigen 
	 *    - Zeilenumbruch erzeugen
	 * </pre>
	 */
	private void calcPascalTriangle() {

	}

}

public class ArrayPanelFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private ArrayPanel view = new ArrayPanel();

	public ArrayPanelFrame() {
		setTitle("Array Panel");
		view.setPreferredSize(new Dimension(400, 500));
		add(view);
		pack();
		view.init();
	}

	public static void main(String args[]) {

		ArrayPanelFrame frame = new ArrayPanelFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
