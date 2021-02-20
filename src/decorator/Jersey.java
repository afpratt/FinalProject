package decorator;

import java.text.NumberFormat;

import static java.text.NumberFormat.getCurrencyInstance;

public abstract class Jersey {
    String description = "Unknown decorator.Jersey";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
