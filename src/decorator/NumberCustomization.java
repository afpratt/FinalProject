package decorator;

public class NumberCustomization extends JerseyDecorator{
    Jersey jersey;

    public NumberCustomization (Jersey jersey) {
        this.jersey = jersey;
    }

    public String getDescription() {
        return jersey.getDescription() + ", Number";
    }

    public double cost() {
        return jersey.cost() + 7.99;
    }
}
