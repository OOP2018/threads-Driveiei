import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Using ReentrantLock to lock the thread.
 * 
 * @author Kornphon Noiprasert
 */
public class CounterWithLock extends Counter {
	private Lock lock = new ReentrantLock();

	/**
	 * add method lock the thread to add the amount to the sum to run for one thread and unlock it, If it's done.
	 * 
	 * @param amount - the number to add to the sum.
	 * */
	public void add(int amount) {
		try {
			lock.lock();
			super.add(amount);
		} finally {
			lock.unlock();
		}
	}
}
