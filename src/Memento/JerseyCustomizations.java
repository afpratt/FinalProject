package Memento;

public class JerseyCustomizations {
    private String jerseyCustomizations;

    public JerseyCustomizationState createState(){
        return new JerseyCustomizationState(jerseyCustomizations);
    }

    public void restore(JerseyCustomizationState customizationState) {
        jerseyCustomizations = customizationState.getCustomizations();
    }

    public String getCustomizations() {
        return jerseyCustomizations;
    }

    public void setJerseyCustomizations(String jerseyCustomizations) {
        this.jerseyCustomizations = jerseyCustomizations;
    }
}
