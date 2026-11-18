import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FourierPanel extends JPanel implements ActionListener {
	
	private JTextField tfAmp = new JTextField("1.0");
	private JTextField tfFreq = new JTextField("1.0");
	private JTextField tfHarm = new JTextField("10");
	private JComboBox<String> cbForm = new JComboBox<String>();
	private JButton btBerechne = new JButton("Berechne");
	private PlotPanel plotPanel = new PlotPanel();
	private double[] signal = {};

	/**
	 * <pre>
	 * - Baut GUI 
	 * - Registriert Listener
	 * </pre>
	 */
	public FourierPanel() {
		
		setLayout(null);

		

	}

	/**
	 * <pre>
	 * - Liest Information aus GUI aus und legt sie in entsprechenden lokalen Var. ab.
	 * - Verzweigung cbForm.getSelectedIndex():
	 *   - Fall 0:
	 *     - signal gleich berechneRechteck() mit entsprechenden Parametern berechnen.
	 *   - Fall 1:
	 *     - signal gleich berechneDreieck() mit entsprechenden Parametern berechnen.
	 *   - Fall 2:
	 *     - signal gleich berechneSaegezahn() mit entsprechenden Parametern berechnen.
	 *   - default:
	 *     - signal gleich berechneRechteck() mit entsprechenden Parametern berechnen.
	 * - Setzt Signal des PlotPanels mittels setSignal().
	 * - Loest Neuzeichnen aus.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int N = 620; // Anzahl Punkte auf der x Achse

		

	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Rechtecksignal
	 * </pre>
	 */
	private double[] berechneRechteck(double amp, double freq, int nHarm, int N) {
		
		double[] y = new double[N];

		
		return y;
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Dreiecksignal
	 * </pre>
	 */
	private double[] berechneDreieck(double amp, double freq, int nHarm, int N) {
		
		double[] y = new double[N];

		return y;
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Saegezahnsignal
	 * </pre>
	 */
	private double[] berechneSaegezahn(double amp, double freq, int nHarm, int N) {
		
		double[] y = new double[N];

		return y;
	}

}

public class FourierPanelFrame extends JFrame {
	
	private Image icon = Utility.loadResourceImage("Fourier.png");
	private FourierPanel view = new FourierPanel();

	public FourierPanelFrame() {
		
		view.setPreferredSize(new Dimension(720, 720));
		add(view);
		pack();
		setIconImage(icon);
		setTitle("|FHNW|EIT|OOP|Fourier-Panel|");
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		FourierPanelFrame frame = new FourierPanelFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}