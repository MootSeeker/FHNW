import java.util.*;

public class SimpleTimer extends Thread {
	private int periode;
	private boolean keepRunning = true;
	private Vector<SimpleTimerListener> listenerVector = new Vector<SimpleTimerListener>();

	public SimpleTimer(int periode) {
		this.periode = periode;
		setPriority(Thread.MAX_PRIORITY);
	}

	public SimpleTimer(int periode, SimpleTimerListener listener) {
		this.periode = periode;
		addTimerListener(listener);
	}

	public void addTimerListener(SimpleTimerListener listener) {
		listenerVector.add(listener);
	}

	public void removeTimerListener(SimpleTimerListener listener) {
		listenerVector.remove(listener);
	}

	/* Setzt Periode in ms */
	public void setPeriode(int periode) {
		this.periode = periode;
	}

	public int getPeriode() {
		return periode;
	}

	public void run() {
		while (keepRunning) {
			if (!listenerVector.isEmpty()) {
				for (int i = 0; i < listenerVector.size(); i++) {
					((SimpleTimerListener) (listenerVector.elementAt(i)))
							.timerAction();
				}
			}
			try {
				Thread.sleep(periode);
			} catch (InterruptedException e) {
				System.err.println("sleep exception");
			}
		}
	}

	public void stopTimer() {
		keepRunning = false;
	}
}
