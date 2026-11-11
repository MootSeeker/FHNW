import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

class LandscapePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Image imWolke = Utility.loadResourceImage("cloud.png", 100, -1);
	private static final Color BROWN = Color.decode("#8b3700");
	private static final Color TREE_GREEN = Color.decode("#0c5000");
	private final static RenderingHints CONFIG = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);// Performance

	int x = 0;
	int y1 = 100;
	int y2 = 200;
	int y3 = 300;

	private static void painTree(Graphics g, int _xs, int _ys, int _width, int _height) {
		Graphics g2d = g;

		g2d.setColor(BROWN);
		g2d.fillRect(_xs, _ys, _width, _height);
		g2d.setColor(TREE_GREEN);
		g2d.fillOval(_xs - 20, _ys - 180, _width * 3, _height * 2);
	}

	public void init() {
		System.out.println("init()");

		// Set background to cyan
		setBackground(Color.CYAN);

		new SimpleTimer(10, new SimpleTimerListener() {
			public void timerAction() {

				if (x < 800) {
					x++;
				} else {
					x = -100;
				}

				y1 = 100 + (int) (40 * Math.sin(x * 0.05));
				y2 = 100 + (int) (40 * Math.sin(x * 0.02 + Math.PI / 2));
				y3 = 100 + (int) (40 * Math.sin(x * 0.01 + Math.PI));
				repaint();
				Toolkit.getDefaultToolkit().sync();
			}
		}).start();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Landschaft zeichnen
		((Graphics2D) g).setRenderingHints(CONFIG); // Performance
		g.setColor(Color.GREEN);
		g.fillRect(0, 400, 800, 200);

		// Draw Cloud with sun
		g.setColor(Color.YELLOW);
		g.fillOval(80, 80, 50, 50);
		g.drawImage(imWolke, x, y1, null);
		g.drawImage(imWolke, x, y2, null);
		g.drawImage(imWolke, x, y3, null);

		// Draw House
		g.setColor(Color.WHITE);
		g.fillRect(500, 250, 200, 200);
		g.setColor(Color.RED);
		g.fillRect(475, 200, 250, 50);
		g.setColor(Color.YELLOW);
		g.fillRect(540, 280, 40, 40);
		g.fillRect(630, 280, 40, 40);
		g.setColor(BROWN);
		g.fillRect(600, 400, 20, 50);

		// Build trees
		painTree(g, 50, 500, 20, 100);
		painTree(g, 150, 450, 20, 100);
		painTree(g, 250, 500, 20, 100);

	}
}

public class LandscapeFrame extends JFrame {
	static final long serialVersionUID = 1L;
	LandscapePanel view = new LandscapePanel();

	public LandscapeFrame() {
		setTitle("LandscapeFrame");
		view.setPreferredSize(new Dimension(800, 600));
		add(view);
		view.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				System.out.println("x: " + e.getX() + " y: " + e.getY());
			}
		});
		pack();
		view.setDoubleBuffered(true);
		view.init();
	}

	public static void main(String args[]) {
		LandscapeFrame frame = new LandscapeFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
