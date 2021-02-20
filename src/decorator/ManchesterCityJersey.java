package decorator;

public class ManchesterCityJersey extends Jersey {

    public ManchesterCityJersey() {
        description = "Manchester City";
    }

    public double cost() {
        return 49.99;
    }
}
