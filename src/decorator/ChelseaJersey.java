package decorator;

public class ChelseaJersey extends Jersey{

    public ChelseaJersey() {
        description = "Chelsea";
    }

    public double cost() {
        return 49.99;
    }
}
