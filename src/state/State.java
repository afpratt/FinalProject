package state;

public interface State {

    public void enterPaymentInformation();
    public void removePaymentInformation();
    public void placeOrder();
    public void shipOrder();
}
