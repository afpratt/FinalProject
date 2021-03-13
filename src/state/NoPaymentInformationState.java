package state;

public class NoPaymentInformationState implements State {
    JerseyStoreState jerseyStoreState;

    public NoPaymentInformationState(JerseyStoreState jerseyStoreState) {
        this.jerseyStoreState = jerseyStoreState;
    }

    public void enterPaymentInformation() {
        System.out.println("Payment information has been entered.");
        jerseyStoreState.setState(jerseyStoreState.getHasPaymentInformationState());
    }

    public void placeOrder() {
        System.out.println("You must enter your payment information to place this order.");
    }
    
    public String toString() {
    	return "No payment information state.";
    }
}
