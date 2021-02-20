package decorator;

public class ArsenalJersey extends Jersey{

    public ArsenalJersey() {
        description = "Arsenal";
    }

    public double cost() {
        return 49.99;
    }
}
