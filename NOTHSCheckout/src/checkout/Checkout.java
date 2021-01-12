package checkout;

public interface Checkout {
	void scan(Item item);
	double total();
}
