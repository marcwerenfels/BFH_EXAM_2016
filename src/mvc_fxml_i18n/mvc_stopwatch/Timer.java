package mvc_fxml_i18n.mvc_stopwatch;

import java.util.Observable;

/**
 * The class Timer implements a timer.
 */
public class Timer extends Observable implements Runnable {
	/**
	 * The number of ticks.
	 */
	private int ticks;

	/**
	 * The time interval (in milliseconds) of a tick.
	 */
	private int interval;

	/**
	 * The number of milliseconds of a second.
	 */
	private final double factor = 1000.0;


	/**
	 * The thread which triggers the ticks.
	 */
	private Thread thread;

	/**
	 * Creates a Timer object.
	 * 
	 * @param intv
	 *            the time interval (in milliseconds) of the timer
	 */
	public Timer(int intv) {
		this.interval = intv;
	}

	/**
	 * @return the time (in seconds) of the timer.
	 */
	public final double getTime() {
		return ticks * interval / factor;
	}

	/**
	 * @return the time (in seconds) converted to a String.
	 */
	public final String getTimeString() {
		return String.valueOf(this.getTime());
	}

	/**
	 * @return true if the timer is running, otherwise false.
	 */
	public final boolean isRunning() {
		return thread != null;
	}

	/**
	 * Starts the timer.
	 */
	public final void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.setDaemon(true);
			thread.start();
			this.setChanged();
			this.notifyObservers();
		}
	}

	/**
	 * Stops the timer.
	 */
	public final void stop() {
		if (thread != null) {
			thread = null;
		}
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Resets the time of the timer.
	 */
	public final void reset() {
		ticks = 0;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Tiggers ticks at the expiration of the time interval.
	 */
	@Override
	public final void run() {
		while (thread != null) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// do nothing
			}
			if (thread != null) {
				ticks++;
				this.setChanged();
				this.notifyObservers();
			}
		}
	}
}
