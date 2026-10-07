import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DemoMethodenPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int STATUS_OK = 1;
	private static final int STATUS_NOTOK = 0;
	private static final int RECT = 2;
	private static final int OVAL = 3;

	private int count = 0;

	public void init() {
		// Test method addition
		System.out.printf("Addition %d \n", addition(12, 42));

		// Test method accumulation
		for (int i = 0; i < 10; i++) {
			accumulate();
			System.out.printf("accumulation: %d \n", count);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("paintComponent");

		// Test method addition
		g.drawString("Addition original method: " + addition(12, 42), 150, 200);

		// Test method addition
		g.drawString("Addition overloaded method: " + addition(12, 42, 14), 150, 225);
		
		// Test method accumulation
		accumulate();
		g.drawString("Accumulation: " + count, 150, 250);
		
	}

	// Basic method which simple addition
	public int addition(int x, int y) {
		int result = x + y;
		return result;
	}
	
	// Overloaded method with three parameters
	public int addition( int x, int y, int z) {
		int result = x + subtraction(y, z); 		// Use private class method
		return result; 
	}

	// Void method - public available via class name
	public void accumulate() {
		count += 5;
	}
	
	// Private method - only in this class available
	private int subtraction( int x, int y ) {
		int result = x - y; 
		return result; 
	}

}

public class DemoMethodenFrame extends JFrame {
	DemoMethodenPanel view = new DemoMethodenPanel();

	public DemoMethodenFrame() {
		setTitle("Demo Methoden");
		view.setPreferredSize(new Dimension(400, 300));
		add(view);
		pack();
		view.init();
		view.accumulate();
	}

	public static void main(String args[]) {
		DemoMethodenFrame frame = new DemoMethodenFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
