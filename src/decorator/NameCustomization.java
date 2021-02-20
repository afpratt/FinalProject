package decorator;

public class NameCustomization extends JerseyDecorator {
    Jersey jersey;

    public NameCustomization (Jersey jersey) {
        this.jersey = jersey;
    }

    public String getDescription() {
        return jersey.getDescription() + ", Name";
    }

    public double cost() {
        return jersey.cost() + 9.99;
    }
}
