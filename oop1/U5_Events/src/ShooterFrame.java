import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class ShooterPanel extends JPanel implements ActionListener, MouseListener, ItemListener, SimpleTimerListener {
	private static final long serialVersionUID = 1L;
	private static final int GROESSE = 80;
	private Image imBird = Utility.loadResourceImage("bird.png", GROESSE, GROESSE);
	private Image imBirdShot = Utility.loadResourceImage("Bird_Shot.png", 150, 150);
	private JTextField tfPunkte = new JTextField(100);
	private JButton btStart = new JButton("Start");
	private JComboBox<String> cbLevel = new JComboBox<String>();
	private int x, y;
	private int anzahlPunkte = 0;
	private boolean pause = true;
	private boolean hit = false; 
	private SimpleTimer timer;
	private int time = 1000;

	private boolean vogelSichtbar = false;

	/*
	 * Additional timer which draws the falling bird all 20ms 
	 */
	private javax.swing.Timer fallTimer = new javax.swing.Timer(20, e -> {
	    // The bird falls by 10px down
		y += 10; 

		// Stop the timer when bird is out of screen
	    if (y >= getHeight()) {
	        ((javax.swing.Timer)e.getSource()).stop();
	        hit = false;
	        vogelSichtbar = false;
	    }

	    repaint();
	});
	
	
	/**
	 * <pre>
	 * - setzt Null-Layout
	 * - patziert Komponenten nach Skizze 
	 * - setzt Textfeld tfPunkte auf nicht editierbar
	 * - erzeugt alle drei Items der Combobox
	 * - registriert die Listener an den entspechenden Komponenten
	 * </pre>
	 */
	public void init() {
		setLayout(null);

		// Level selection
		add(new JLabel("Level")).setBounds(20, 30, 100, 20);
		add(cbLevel).setBounds(20, 50, 100, 20);
		cbLevel.addItem("1");
		cbLevel.addItem("2");
		cbLevel.addItem("3");
		
		// Select the first Item - is also default
		cbLevel.setSelectedIndex(0); 

		// Start button
		add(btStart).setBounds(20, 100, 100, 40);

		// Game Score
		add(new JLabel("Punkte")).setBounds(20, 160, 100, 20);
		add(tfPunkte).setBounds(20, 180, 100, 20);
		tfPunkte.setEditable(false);

		// Setup listeners
		addMouseListener(this);
		btStart.addActionListener(this);
		cbLevel.addItemListener(this);
	}

	/**
	 * <pre>
	 * - zeichnet vertikale Linie bei 1/3 der Panelbreite 
	 * - Falls pause unwahr
	 * 		- schreibt Ergebnis von getXPos() auf Attribut x 
	 * 		- schreibt Ergebnis von getYPos() auf Attribut y
	 * 		- zeichnet Flappy mit Bildmitte bei x, y und ImageObserver null
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw Field line
		g.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight());

		// Draw Game when started
		if (!pause&&vogelSichtbar) {
			// Draw Bird on Screen
			if(hit) {
				g.drawImage(imBirdShot, x-35, y-35, null);
			}else {
				g.drawImage(imBird, x, y, null);
			}	
		}
		
		// Update Game Score 
		tfPunkte.setText(Integer.toString(anzahlPunkte));
	}

	/**
	 * <pre>
	 * - gibt Zufallszahl x innerhalb Spielfeld zurueck
	 * </pre>
	 */
	private int getXPos() {
		// Place Bird inside of the field on x axis
		int randPosX = getWidth() / 3 + (int) (Math.random() * (getWidth() - getWidth() / 3 - GROESSE));
		return randPosX;
	}

	/**
	 * <pre>
	 * - gibt Zufallszahl y innerhalb Spielfeld zurueck
	 * </pre>
	 */
	private int getYPos() {
		// Place Bird inside of the field on y axis
		int randPosY = (int) (Math.random() * (getHeight() - GROESSE));
		return randPosY;
	}

	/**
	 * <pre>
	 * - Falls Mausklick das Flappybild trifft
	 * 		- erhoeht anzahlPunkte
	 * 		- aktualisiert tfPunkte mit anzahl Punkte
	 * 		- gibt "Treffer" auf der Konsole aus
	 * </pre>
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// Calculate the diffrence between click and bird position
		int xScoreDiff = (int)(Math.abs(x - e.getX()));
		int yScoreDiff = (int)(Math.abs(y - e.getY())); 
		
		if((xScoreDiff < (GROESSE)) & (yScoreDiff < (GROESSE))){
			// This should be a hit
			// Repaint with new image and start fall timer
			hit = true; 
			anzahlPunkte++; 
	        fallTimer.start();
	        repaint();
		}
		
        // Show Score diff on console 
		System.out.println(xScoreDiff); 
		System.out.println(yScoreDiff); 
	}

	/**
	 * <pre>
	 * - setzt pause auf unwahr
	 * - falls timer Objekt vorhanden
	 * 		- entfernt TimerListener des timer mittels timer.removeTimerListener(this);
	 * - erzeugt und startet neuen timer mit Periode time
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		pause = false;
		if (timer != null) {
			timer.removeTimerListener(this);
		}
		timer = new SimpleTimer(time, this);
		timer.start();

		// Draw new bird on start
		vogelSichtbar = true; 
		x = getXPos(); 
		y = getYPos(); 
		repaint(); 
	}

	/**
	 * <pre>
	 * - setzt pause auf wahr
	 * - Falls Level 1
	 * 		- setzt time auf 1000
	 * - Falls Level 2 
	 * 		- setzt time auf 800
	 * - Falls Level 3 
	 * 		- setzt time auf 500
	 * </pre>
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// Pause the game
		pause = true;
		
		// Set game speed with selected value from dropdown
		switch (cbLevel.getSelectedItem().toString()) {
		case "1":
			time = 1000;
			break;

		case "2":
			time = 750;
			break;

		case "3":
			time = 500;
			break;

		default:
			time = 1000;
			break;
		}
	}

	@Override
	public void timerAction() {
		// Set new bird if alive
		if(!pause && !hit) {
			x = getXPos();
			y = getYPos();
			vogelSichtbar = true; 
		}
		
		// Else hit bird is falling - so we only redraw the screen
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}

public class ShooterFrame extends JFrame {
	static final long serialVersionUID = 1L;
	ShooterPanel view = new ShooterPanel();

	public ShooterFrame() {
		setTitle("Shooter");
		view.setPreferredSize(new Dimension(600, 400));
		add(view);
		pack();
		view.init();
	}

	public static void main(String args[]) {
		ShooterFrame frame = new ShooterFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
