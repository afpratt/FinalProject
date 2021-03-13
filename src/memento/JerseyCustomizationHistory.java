package memento;

import java.util.ArrayList;
import java.util.List;

public class JerseyCustomizationHistory {
    public List<JerseyCustomizationState> customizationStates = new ArrayList<>();

    public void push(JerseyCustomizationState customizationState) {
        customizationStates.add(customizationState);
    }

    public JerseyCustomizationState pop() {
        var lastIndex = customizationStates.size() - 1;
        var lastState = customizationStates.get(lastIndex);
        customizationStates.remove(lastState);

        return lastState;
    }
}
