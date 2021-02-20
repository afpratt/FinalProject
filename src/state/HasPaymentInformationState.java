package state;

public class HasPaymentInformationState implements State {
    JerseyStoreState jerseyStoreState;

    public HasPaymentInformationState(JerseyStoreState jerseyStoreState) {
        this.jerseyStoreState = jerseyStoreState;
    }

    public void enterPaymentInformation() {
        System.out.println("Payment information has already been entered.");
    }

    public void removePaymentInformation() {
        System.out.println("Payment information removed.");
        jerseyStoreState.setState(jerseyStoreState.getNoPaymentInformationState());
    }

    public void placeOrder() {
        System.out.println("Your order has been placed.");
        jerseyStoreState.setState(jerseyStoreState.getSoldState());
    }

    public void shipOrder() {
        System.out.println("Your order has not been shipped yet.");
    }
}
