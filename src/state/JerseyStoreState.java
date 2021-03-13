package state;

public class JerseyStoreState {
    State soldState;
    State noPaymentInformationState;
    State hasPaymentInformationState;

    State state;

    public JerseyStoreState() {
        soldState = new SoldState(this);
        noPaymentInformationState = new NoPaymentInformationState(this);
        hasPaymentInformationState = new HasPaymentInformationState(this);
        state = noPaymentInformationState;
    }

    public void enterPaymentInformation() {
        state.enterPaymentInformation();
    }

    public void placeOrder() {
        state.placeOrder();
    }

    void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getNoPaymentInformationState() {
        return noPaymentInformationState;
    }

    public State getHasPaymentInformationState() {
        return hasPaymentInformationState;
    }
    
    public String toString() {
    	StringBuffer result = new StringBuffer();
    	result.append(state);
    	return result.toString();
    }
}
