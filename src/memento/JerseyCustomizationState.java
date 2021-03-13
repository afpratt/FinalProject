package memento;

public class JerseyCustomizationState {
    private String jerseyNameCustomizations;
    private String jerseyNumberCustomizations;

    public JerseyCustomizationState() {
        
    }

    public void setJerseyNumberCustomizations(String jerseyNumberCustomizations) {
        this.jerseyNumberCustomizations = jerseyNumberCustomizations;
    }

    public String getJerseyNumberCustomizations() {
        return jerseyNumberCustomizations;
    }

    public void setJerseyNameCustomizations(String jerseyNameCustomizations) {
        this.jerseyNameCustomizations = jerseyNameCustomizations;
    }

    public String getJerseyNameCustomizations() {
        return jerseyNameCustomizations;
    }
}
