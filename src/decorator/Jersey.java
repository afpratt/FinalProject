package decorator;

public abstract class Jersey {
    String description = "Unknown decorator.Jersey";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
