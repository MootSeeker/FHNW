import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ForestPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final Color STEM_BROWN_1 = Color.decode("#8b3700");
	private static final Color STEM_BROWN_2 = Color.decode("#b30000");
	private static final Color STEM_BROWN_3 = Color.decode("#4d1a00");

	private static final Color FOLIAGE_GREEN_1 = Color.decode("#0c5000");
	private static final Color FOLIAGE_GREEN_2 = Color.decode("#408000");
	private static final Color FOLIAGE_GREEN_3 = Color.decode("#00b300");

	private static final Color GRASS_GREEN = Color.decode("#99ff33");
	
	// Collect all available stem colors
	private static final Color STEM_COLORS[] = {
			STEM_BROWN_1, STEM_BROWN_2, STEM_BROWN_3
	}; 
	
	// Collect all available foliage colors 
	private static final Color FOLIAGE_COLORS[] = {
			FOLIAGE_GREEN_1, FOLIAGE_GREEN_2, FOLIAGE_GREEN_3
	}; 
	
	// Constant object sizes 
	private static final int REF_MARKING_DOT_WIDTH = 10; 
	private static final int REF_MARKING_DOT_HEIGHT = 10;
	
	// Tree object sizes 
	private static final int TREE_STEM_WIDTH = 20; 
	private static final int TREE_STEM_HEIGHT= 50;
	private static final int TREE_LEAF_WIDTH = 40; 
	private static final int TREE_LEAF1_HEIGHT = 70;  
	private static final int TREE_LEAF2_HEIGHT = 170; 
	
	// Some additional helper values
	private static final int OVER_LEAP = 15; 
	private static final int RENDER_AMOUNT = 5;
	private static final int HEIGHT_STEPS = 10; 
	
	// Get random color of Foliage color array
	private static Color getFoliageColor( ) {
		final int index = (int) (Math.random() * FOLIAGE_COLORS.length);
		return FOLIAGE_COLORS[ index ];  
	}
	
	// Get random color of stem color array
	private static Color getStemColor( ) {
		final int index = (int)(Math.random() * STEM_COLORS.length); 
		return STEM_COLORS[ index ]; 
	}
	
	public void init() {
		// Setup background
		setBackground(Color.CYAN);
	}

	// Draw a tree at position: x/y 
	public void drawTree(int x, int y, Graphics g) {
		// x and y is the lower middle of the stem
		
		// Calculated stem position
		final int stemX = x - TREE_STEM_WIDTH / 2; 
		final int stemY = y - TREE_STEM_HEIGHT; 
		
		// Calculated leef1 position from stem
		final int leef1X = x - (TREE_LEAF_WIDTH / 2); 
		final int leef1Y = stemY + OVER_LEAP - TREE_LEAF1_HEIGHT; 
		final int leef2X = x - (TREE_LEAF_WIDTH / 2); 
		final int leef2Y = stemY + OVER_LEAP - TREE_LEAF2_HEIGHT; 
		
		// Draw stem
		g.setColor(getStemColor( ));
		g.fillRect(stemX, stemY, TREE_STEM_WIDTH, TREE_STEM_HEIGHT);
		
		// Draw leafs from back to front
		g.setColor(getFoliageColor());
		g.fillOval(leef1X, leef1Y, TREE_LEAF_WIDTH, TREE_LEAF1_HEIGHT);
		
		g.setColor(getFoliageColor());
		g.fillOval(leef2X, leef2Y, TREE_LEAF_WIDTH, TREE_LEAF2_HEIGHT);
		
		// Draw point at x/y position
		g.setColor(Color.PINK);
		g.fillRect(x - (REF_MARKING_DOT_WIDTH / 2), y - (REF_MARKING_DOT_HEIGHT / 2), 
				REF_MARKING_DOT_WIDTH, REF_MARKING_DOT_HEIGHT);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Define some constants
		final int grassY = getHeight() / 2;
		final int grassHeight = getHeight() - grassY;
		final int grassWidth = getWidth(); 
		final int leefMargin = TREE_LEAF_WIDTH / 2; 
		
		// Draw grass
		g.setColor(GRASS_GREEN);
		g.fillRect(0, grassY, grassWidth, grassHeight);
		
		// Draw tree in the middle of the screen
		drawTree(grassWidth / 2, grassY, g);
		
		// Draw random trees inside grass
		for(int i = 0; (i < (10 * HEIGHT_STEPS)) && (i < grassHeight) ; i += HEIGHT_STEPS) {
			
			// Y Position places trees in 10 steps from grassY
			int treePosY = grassY + i; 
			
			for(int j = 0; j < RENDER_AMOUNT; j++) {
				
				// X Position with some margin on both sides so the whole tree fits in the screen
				// Draws renderAmount on one line
				int treePosX = leefMargin + (int)(Math.random() * (getWidth() - 2 * leefMargin));
			
				// Draw tree at calculated position
				drawTree(treePosX, treePosY, g); 
			}
		}
	}
}

public class ForestFrame extends JFrame {
	static final long serialVersionUID = 1L;
	ForestPanel view = new ForestPanel();

	public ForestFrame() {
		setTitle("ForestFrame");
		view.setPreferredSize(new Dimension(800, 600));
		add(view);
//	view.addMouseMotionListener(new MouseMotionAdapter() {
//	  public void mouseMoved(MouseEvent e) {
//		System.out.println("x: " + e.getX() + " y: " + e.getY());
//	  }
//	});
		pack();
		view.setDoubleBuffered(true);
		view.init();
	}

	public static void main(String args[]) {
		ForestFrame frame = new ForestFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
