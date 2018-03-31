/**
 * ThreadSum has behavior like a main class which to start the application or
 * ready to begin running for counting the times for any thread.
 * 
 * @author Kornphon Noiprasert
 */
public class ThreadSum {

	/**
	 * Configure and start the application.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		// upper limit of numbers to add/subtract to Counter
		final int LIMIT = 10_000_000;
		// The counter that accumulates a total.
		Counter counter = new AtomicCounter();
		runThreads(counter, LIMIT);
	}

	/**
	 * The runThreads method is called after the main method has called, and after
	 * the system is ready for the application to begin running.
	 * 
	 * @param counter - the object to count.
	 * @param limit - the maximum number of times to count in any thread.
	 */
	public static void runThreads(Counter counter, final int limit) {
		// two tasks that add and subtract values using same Counter
		AddTask addtask = new AddTask(counter, limit);
		SubtractTask subtask = new SubtractTask(counter, limit);
		// threads to run the tasks
		Thread thread1 = new Thread(addtask);
		Thread thread2 = new Thread(subtask);
		// start the tasks
		System.out.println("Starting threads");
		long startTime = System.nanoTime();
		thread1.start();
		thread2.start();
		// wait for threads to finish
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("Threads interrupted");
		}
		double elapsed = 1.0E-9 * (System.nanoTime() - startTime);
		System.out.printf("Count 1 to %,d in %.6f sec\n", limit, elapsed);
		// the sum should be 0. Is it?
		System.out.printf("Counter total is %d\n", counter.get());
	}
}

/**
 * AddTask adds number 1 ... limit to the counter, then exits.
 */
class AddTask implements Runnable {
	private Counter counter;
	private int limit;

	/**
	 * To initialize the object and maxmimum times to run the application.
	 * 
	 * @param counter - the object to count.
	 * @param limit - the maximum number of times to count in any thread.
	 */
	public AddTask(Counter counter, int limit) {
		this.counter = counter;
		this.limit = limit;
	}

	/**
	 * When an object implementing interface Runnable is used to create a thread,
	 * starting the thread causes the object's run method to be called in that
	 * separately executing thread. The general contract of the method run is that
	 * it may take any action whatsoever.
	 */
	@Override
	public void run() {
		for (int k = 1; k <= limit; k++)
			counter.add(k);
		// If you want to see when a thread finishes, add this line:
		System.out.println("Done " + Thread.currentThread().getName());
	}
}
