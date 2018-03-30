import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter extends Counter{
	
	private AtomicLong total;
	
	public AtomicCounter() {
		total = new AtomicLong();
	}
	
	public void add(int amount) {
		total.getAndAdd(amount);
	}
	
	public long get() {
		return total.longValue();
	}
}
