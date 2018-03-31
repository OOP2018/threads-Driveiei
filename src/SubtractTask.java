/**
 * SubtractTask subtract number 1 ... limit to the counter, then exits.
 */
public class SubtractTask implements Runnable {

	private Counter counter;
	private int limit;

	/**
	 * To initialize the object and maxmimum times to run the application.
	 * 
	 * @param counter - the object to count.
	 * @param limit - the maximum number of times to count in any thread.
	 */
	public SubtractTask(Counter counter, int limit) {
		this.counter = counter;
		this.limit = limit;
	}

	/**
	 * When an object implementing interface Runnable is used to create a thread,
	 * starting the thread causes the object's run method to be called in that
	 * separately executing thread.
	 */
	@Override
	public void run() {
		for (int k = 1; k <= limit; k++)
			counter.add(-k);
	}

}
