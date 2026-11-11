import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.Clip;
import javax.swing.*;

class ShooterPanel extends JPanel implements ActionListener, MouseListener, ItemListener, SimpleTimerListener {
	private static final long serialVersionUID = 1L;
	private static final int GROESSE = 80;
	// private Clip audioClip = Utility.loadAudioClip("laughter.wav");
	private Image imBird = Utility.loadResourceImage("bird.png", GROESSE, GROESSE);
	private JTextField tfPunkte = new JTextField(100);
	private JButton btStart = new JButton("Start");
	private JComboBox<String> cbLevel = new JComboBox<String>();
	private int x, y;
	private int anzahlPunkte = 0;
	private boolean pause = true;
	private SimpleTimer timer;
	private int time = 1000;

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

		add(new JLabel("Level")).setBounds(20, 30, 100, 20);
		add(cbLevel).setBounds(20, 50, 100, 20);
		add(btStart).setBounds(20, 100, 100, 40);
		add(new JLabel("Punkte")).setBounds(20, 160, 100, 20);
		add(tfPunkte).setBounds(20, 180, 100, 20);
		tfPunkte.setEditable(false);

		cbLevel.addItem("1");
		cbLevel.addItem("2");
		cbLevel.addItem("3");

		addMouseListener(this);
		btStart.addActionListener(this);
		cbLevel.addItemListener(this);

	}

	/**
	 * <pre>
	 * - zeichnet vertikale Linie bei 1/3 der Panelbreite 
	 * - Falls  pause unwahr
	 * 		- schreibt Ergebnis von getXPos() auf Attribut x 
	 * 		- schreibt Ergebnis von getYPos() auf Attribut y
	 * 		- zeichnet Flappy mit Bildmitte bei x, y und ImageObserver null
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight());
		if (pause != true) {
			x = getXPos();
			y = getYPos();

			g.drawImage(imBird, x - GROESSE / 2, y - GROESSE / 2, null);
		}

	}

	/**
	 * <pre>
	 * - gibt Zufallszahl x innerhalb Spielfeld zurueck
	 * </pre>
	 */
	private int getXPos() {
		return (int) (getWidth() / 3 + Math.random() * (getWidth() - getWidth() / 3));
	}

	/**
	 * <pre>
	 * - gibt Zufallszahl y innerhalb Spielfeld zurueck
	 * </pre>
	 */
	private int getYPos() {
		return (int) (Math.random() * (getHeight()));
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
//		if ((Math.abs(x - e.getX()) < GROESSE / 2)) {
//			if ((Math.abs(y - e.getY()) < GROESSE / 2)) {
		if ((Math.abs(x - e.getX()) < GROESSE / 2) && (Math.abs(y - e.getY()) < GROESSE / 2)) {
			// if (Math.sqrt(Math.pow((x - e.getX()), 2) + Math.pow((y - e.getY()), 2)) <
			// GROESSE / 2) {//alternativ

			anzahlPunkte++;
			// tfPunkte.setText("" + anzahlPunkte);
			tfPunkte.setText(Integer.toString(anzahlPunkte));

			System.out.println("Treffer");

			if (e.getButton() == MouseEvent.BUTTON1) {
				playSound(Utility.loadAudioClip("laughter.wav"));
			} else {
				playSound(Utility.loadAudioClip("cry.wav"));
			}

		}

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

		pause = true;
		if (cbLevel.getSelectedItem().equals("1")) {
			time = 1000;
		}
		if (cbLevel.getSelectedItem().equals("2")) {
			time = 800;

		}
		if (cbLevel.getSelectedItem().equals("3")) {
			time = 500;
		}

		switch ((String) cbLevel.getSelectedItem()) {
		case "1":
			time = 1000;
			break;
		case "2":
			time = 800;
			break;
		default:
			time = 500;
		}

		switch (cbLevel.getSelectedIndex()) {
		case 0:
			time = 1000;
			break;
		case 1:
			time = 800;
			break;
		default:
			time = 500;

		}

	}

	@Override
	public void timerAction() {
		repaint();

	}

	private void playSound(Clip audioClip) {
		audioClip.setFramePosition(0);
		audioClip.start();

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
