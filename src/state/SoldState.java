package state;

public class SoldState implements State {
    JerseyStoreState jerseyStoreState;

    public SoldState(JerseyStoreState jerseyStoreState) {
        this.jerseyStoreState = jerseyStoreState;
    }

    public void enterPaymentInformation() {
        System.out.println("Payment information has been entered.");
    }

    public void removePaymentInformation() {
        System.out.println("You can no longer update or remove your payment information.");
    }

    public void placeOrder() {
        System.out.println("Your order is being processed and will ship in 1-2 business days.");
    }

    public void shipOrder() {
        jerseyStoreState.setState(jerseyStoreState.getNoPaymentInformationState());
    }
}
