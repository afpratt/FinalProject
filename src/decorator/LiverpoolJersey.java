package decorator;

public class LiverpoolJersey extends Jersey {

    public LiverpoolJersey() {
        description = "Liverpool";
    }

    public double cost() {
        return 49.99;
    }
}
