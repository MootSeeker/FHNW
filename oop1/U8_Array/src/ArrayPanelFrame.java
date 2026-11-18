import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

class ArrayPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextArea data = new JTextArea();
	private final int DIM = 3;
	private int[][] matrixA;
	private int[][] matrixB;
	private int[][] matrixResult;
	
	private JButton btRandomMatrices = new JButton(); 
	private JButton btAdd = new JButton(); 
	private JButton btMultiply = new JButton(); 
	private JButton btPascal = new JButton(); 

	public void init() {
		setLayout(null);


		
		// Initialize both matrices with the initial values from task
		matrixA = new int[3][3]; 
		matrixB = new int[3][3]; 
		matrixResult = new int[3][3]; 
		 
		for(int i = 0; i < matrixA.length; i++) {
			for(int j = 0; j < matrixA.length; j++) {
				int spaltenA = matrixA[i].length; 
				int spaltenB = matrixB[i].length;
				matrixA[i][j] = i * spaltenA + j + 1;  
				matrixB[i][j] = i * spaltenB + j + 1;  
			}
		}
		
		// Build UI with buttons
		btAdd.setFont(new Font("monospaced", Font.BOLD, 14));
		btAdd.setText("Add");
		btAdd.setBounds(20, 350, 150, 20);
		add(btAdd); 
		
		
		btMultiply.setFont(new Font("monospaced", Font.BOLD, 14));
		btMultiply.setText("Multiply");
		btMultiply.setBounds(20, 380, 150, 20);
		add(btMultiply); 
		
		btRandomMatrices.setFont(new Font("monospaced", Font.BOLD, 14));
		btRandomMatrices.setText("Random Matrices");
		btRandomMatrices.setBounds(20, 410, 150, 20);
		add(btRandomMatrices); 
		
		btPascal.setFont(new Font("monospaced", Font.BOLD, 14));
		btPascal.setText("Pascal");
		btPascal.setBounds(20, 440, 150, 20);
		add(btPascal); 

		data.setFont(new Font("monospaced", Font.BOLD, 16));
		add(data).setBounds(5, 5, 300, 300);
		showResult();
		
		btRandomMatrices.addActionListener(this); 
		btAdd.addActionListener(this); 
		btMultiply.addActionListener(this); 
		btPascal.addActionListener(this); 
	}

	public void actionPerformed(ActionEvent e) {
		if(true == e.getSource().equals(btAdd)) {
			matrixResult = addMatrix(matrixA, matrixB); 
		}else if(true == e.getSource().equals(btMultiply)) {
			matrixResult = multiplyMatrix(matrixB, matrixA); 
		}else if(true == e.getSource().equals(btRandomMatrices)) {
			randomFillMatrix(matrixA);
			randomFillMatrix(matrixB);
		}else if(true == e.getSource().equals(btPascal)) {
			calcPascalTriangle();
			return; 
		}
		
		showResult(); 
	}
	
	private void randomFillMatrix(int Matrix[][]) {
		for(int i = 0; i < Matrix.length; i++) {
			for(int j = 0; j < Matrix.length; j++) {
				Matrix[i][j] = (int)(Math.random() * 10);   
			}
		}
	}
	
	private int[][] addMatrix(int[][] m1, int[][] m2) {
		int[][] result = new int[3][3]; 
		
		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1[i].length; j++) {
				result[i][j] = m1[i][j] + m2[i][j]; 
			}
		}
		
		return result; 
	}
	
	private int[][] multiplyMatrix(int[][] m1, int[][] m2) {
		int[][] result = new int[3][3]; 

		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1[i].length; j++) {
				for(int k = 0; k < m2[j].length; k++ ) {
					result[i][j] += m1[i][k] * m2[k][j]; 
				}
			}
		}
		
		return result; 
	}

	private void showResult() {
		data.setText("");	// löscht das TextArea
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
		int[][] triangle = new int[7][]; 
		data.setText("");	// löscht das TextArea
		
		for(int row = 0; row < triangle.length; row++) {
		    String spc = new String(new char[14 - 2 * row]).replace('\0', ' ');
		    data.append(spc);
		    
			triangle[row] = new int[row + 1]; 
			for(int col = 0; col <= row; col++) {
				if(col == 0 || col == row) {
					triangle[row][col] = 1; 
				}else {
					triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col]; 
				}
				data.append(triangle[row][col] + " ");
			}
			data.append("\n");

		}
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
