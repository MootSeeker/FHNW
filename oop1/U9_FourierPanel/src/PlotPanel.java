import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PlotPanel extends JPanel {

	private double[] signal = {};

	public PlotPanel() {

	}

	@Override
	/**
	 * <pre>
	 * - Erzeugt lokale Ganzzahl-Arrays x und y mit gleicher Laenge wie das Signal signal.
	 * 
	 * - Fuer k gleich Null bis kleiner der Laenge von x:
	 *   - x an der Stelle k gleich  k setzen.
	 *   - y an der Stelle k gleich dem Ganzzahlanteil von 200 minus 100 mal dem Signal an der Stelle k setzen.
	 *
	 * - Farbe von g auf schwarz setzen.
	 * - Mittels ((Graphics2D) g).setStroke(new BasicStroke(1)) die Strichdicke auf 1 setzen.
	 * - Achsen mittels drawLine() zeichnen.
	 *   
	 * - Farbe von g auf blau setzen.
	 * - Mittels ((Graphics2D) g).setStroke(new BasicStroke(3)) die Strichdicke auf 3 setzen.
	 * - Mittels drawPolyline() den Plot zeichnen.
	 * 
	 * </pre>
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

	}

	public void setSignal(double[] signal) {
		this.signal = signal;
	}

}
