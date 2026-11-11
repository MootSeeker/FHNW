import java.util.Vector;

public class SimpleTimer extends Thread {
	private volatile int periode;
	private volatile boolean keepRunning = true;
	private Vector<SimpleTimerListener> listenerVector = new Vector<SimpleTimerListener>();

	public SimpleTimer(int periode) {
		this.periode = periode;
	}

	public SimpleTimer(int periode, SimpleTimerListener listener) {
		this.periode = periode;
		addTimerListener(listener);
	}

	public void addTimerListener(SimpleTimerListener listener) {
		listenerVector.add(listener);
	}

	public int getPeriode() {
		return periode;
	}

	public void removeTimerListener(SimpleTimerListener listener) {
		listenerVector.remove(listener);
	}

	public void run() {
		while (keepRunning) {
			try {
				Thread.sleep(periode);
			} catch (InterruptedException e) {
				System.err.println("sleep exception");
			}
			if (!listenerVector.isEmpty()) {
				for (int i = 0; i < listenerVector.size(); i++) {
					(((SimpleTimerListener) listenerVector.elementAt(i))).timerAction();
				}
			}
		}
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	public void stopTimer() {
		keepRunning = false;
	}
}
