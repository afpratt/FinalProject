package command;

public class PlaceOrderCommand implements Command {
	private Checkout checkout;
	
	public PlaceOrderCommand(Checkout checkout) {
		this.checkout = checkout;
	}
	
	public void execute() {
		checkout.submitOrder();
	}
}
