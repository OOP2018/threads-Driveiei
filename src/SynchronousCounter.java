/**
 * An accumulator for a sum by using synchronized process.
 * 
 * @author Kornphon Noiprasert
 */
public class SynchronousCounter extends Counter {
	
	/**
	 * Add an amount to the total.
	 * */
	@Override
	public synchronized void add(int amount) {
		total += amount;
	}
}
