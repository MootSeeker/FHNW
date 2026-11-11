import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class Lokomotive extends JPanel {
	//
	private static final long serialVersionUID = 1L;

	private Image imBackGround = Utility.loadResourceImage("background.jpg", 900, 600);
	private Image imLummerLand = Utility.loadResourceImage("lummerland.jpg", 900, 600);
	private Image imDragon = Utility.loadResourceImage("drache.jpg", 900, 600);
	private JButton btRandom = new JButton("Glückswürfel");
	private SimpleTimer timer;

	private final static RenderingHints CONFIG = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);// Performance

	private int x, xStart;
	private int y, yStart, yEnd;
	private boolean isLummerland = false;
	private boolean isKummerland = false;

	public void init() {

		// ---------gegeben----------------------------
		add(btRandom);
		btRandom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				destiny();

			}
		});
		// ------------------------------------------
		// ToDo: hier darunter Ihren Code ergaenzen

		// Aufgabe 1 Variabeln setzten
		yEnd = (int) ((double) getHeight() * 0.25);
		yStart = (int) ((double) getHeight() * 0.75);
		xStart = (int) ((double) getWidth() * 0.8);
		x = xStart;
		y = yStart;
		
		isLummerland = false; 

	}

	public void paintComponent(Graphics g) {
		//
		super.paintComponent(g);
		((Graphics2D) g).setRenderingHints(CONFIG); // Performance
		g.drawImage(imBackGround, 0, 0, null);
		// ToDo: hier darunter Ihren Code ergaenzen

		// Aufgabe 1 Lokomotive zeichnen

		g.setColor(Color.GRAY);
		g.fillRect(x, y, 100, 60);

		g.fillRect(x - 20, y, 10, 50);

		// Refpoint
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 10, 10);

		
		if(true == isLummerland)
		{
			goLummerLand(g);
		}
		else if (isKummerland)
		{
			goKummerLand(g);
		}
	}

	private void goKummerLand(Graphics g) {
		// ToDo: hier Ihren Code ergaenzen
		do {
			if (x < 200) {
				g.drawImage(imDragon, 0, 0, null);
			}
			x--; // Nach Links bewegen
			System.out.println(x);

			
		} while (x > 200);

	}

	private void goLummerLand(Graphics g) {
		// ToDo: hier Ihren Code ergaenzen
		do {
			if (x < 200) {
				g.drawImage(imLummerLand, 0, 0, null);
			}
			x--; // Nach Links
			y--; // Nach oben bewegen

		} while (x > 200);
	}

	private void destiny() {
		int choise = 0;
		int randNum = (int) (Math.random() * 100) + 1;

		if (0 == (randNum % 2)) {
			System.out.println(randNum);
			
			startJourney();
			isLummerland = true;
		}
		else {
			isLummerland = false; 
			isKummerland = true; 
		}

	}

	// Methode goStartPosition() ergaenzen

	// ----gegeben-------------------------------------------------

	private void startJourney() {
		timer = new SimpleTimer(10, new SimpleTimerListener() {
			public void timerAction() {
				repaint();
				Toolkit.getDefaultToolkit().sync();

			}
		});
		timer.start();
	}

}

public class LokomotiveFrame extends JFrame {
	static final long serialVersionUID = 1L;
	Lokomotive view = new Lokomotive();

	public LokomotiveFrame() {
		setTitle("Jim Knopf will heim");
		view.setPreferredSize(new Dimension(900, 600));
		add(view);
		pack();
		view.setDoubleBuffered(true);
		view.init();
	}

	public static void main(String args[]) {
		LokomotiveFrame frame = new LokomotiveFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
