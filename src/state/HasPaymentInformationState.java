package state;

public class HasPaymentInformationState implements State {
    JerseyStoreState jerseyStoreState;

    public HasPaymentInformationState(JerseyStoreState jerseyStoreState) {
        this.jerseyStoreState = jerseyStoreState;
    }

    public void enterPaymentInformation() {
        System.out.println("Payment information has already been entered.");
    }

    public void placeOrder() {
        System.out.println("Thank you for shopping with us!");
        jerseyStoreState.setState(jerseyStoreState.getSoldState());
    }
}
