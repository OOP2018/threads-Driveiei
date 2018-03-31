/**
 * An accumulator for a sum.
 * 
 * @author Kornphon Noiprasert
 */
public class Counter {
	protected long total;

	/**
	 * To initailize the sum.
	 */
	public Counter() {
		total = 0;
	}

	/**
	 * Add an amount to the total.
	 * 
	 * @param amount - the number to add to the sum.
	 */
	public void add(int amount) {
		total += amount;
	}

	/**
	 * Get the total value of counter.
	 */
	public long get() {
		return total;
	}
}
