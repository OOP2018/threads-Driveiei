import java.util.concurrent.atomic.AtomicLong;

/**
 * An accumulator for a sum.
 * 
 * @author Kornphon Noiprasert
 */
public class AtomicCounter extends Counter{
	
	private AtomicLong total;
	
	/**
	 * To initailize the sum.
	 */
	public AtomicCounter() {
		total = new AtomicLong();
	}
	
	/**
	 * Add an amount to the total.
	 * 
	 * @param amount - the number to add to the sum.
	 */
	public void add(int amount) {
		total.getAndAdd(amount);
	}
	
	/**
	 * Get the total value of counter.
	 */
	public long get() {
		return total.longValue();
	}
}
