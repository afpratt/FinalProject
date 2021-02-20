package Memento;

public class JerseyCustomizationState {
    private final String jerseyCustomizations;

    public JerseyCustomizationState(String jerseyCustomizations){
        this.jerseyCustomizations = jerseyCustomizations;
    }

    public String getCustomizations() {
        return jerseyCustomizations;
    }
}
