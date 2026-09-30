import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("unused")
class HelloWorldPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public void init() {
	
		setBackground(Color.LIGHT_GRAY);
	  
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		String welcomeText = "Hello World!"; 
		int positionTitle = (getHeight() - 50) / 2;
		int positionSubtitle = positionTitle + 50;

		g.setColor( Color.RED );
		g.drawRoundRect( 50, 50, 500, 300, 30, 30 );

		g.setColor(Color.BLACK);
		g.setFont( new Font("Arial", Font.BOLD, 24) );
		g.drawString(welcomeText, (getWidth() - g.getFontMetrics().stringWidth(welcomeText)) / 2, positionTitle);
		
		welcomeText = "Simple Java UI Application - and yes python can do this in 3 lines of code!";
		g.setColor(Color.BLACK);
		g.setFont( new Font("Arial", Font.ITALIC, 14) );
		g.drawString(welcomeText, (getWidth() - g.getFontMetrics().stringWidth(welcomeText)) / 2, positionSubtitle);
		
	}

}

public class HelloWorldFrame extends JFrame {
	static final long serialVersionUID = 1L;
	HelloWorldPanel view = new HelloWorldPanel();

	public HelloWorldFrame() {
		setTitle("HelloWorldFrame");
		view.setPreferredSize(new Dimension(600, 400));
		add(view);
		pack();
		view.init();
	}

	public static void main(String args[]) {
		HelloWorldFrame frame = new HelloWorldFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
