import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LandscapePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Image imWolke = Utility.loadResourceImage("cloud.png",100,-1);
	private static final Color BROWN = Color.decode("#8b3700");
	private static final Color TREE_GREEN = Color.decode("#0c5000");
	private final static RenderingHints CONFIG = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);// Performance
	
	

	public void init() {
		System.out.println("init()");
		// Hintergrundsfarbe CYAN setzen ...

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Landschaft zeichnen
		((Graphics2D) g).setRenderingHints(CONFIG); // Performance
		
		
		

		

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
