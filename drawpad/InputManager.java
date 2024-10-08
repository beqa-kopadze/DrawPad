package drawpad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * The InputManager class manages user input from keyboard events using key bindings.
 * It provides methods to check the state of keyboard keys.
 */
public class InputManager {
    private final Map<Integer, Boolean> keyStates;

    /**
     * Constructor to initialize the InputManager.
     */
    public InputManager() {
        keyStates = new HashMap<>();
    }

    /**
     * Sets up key bindings for the specified component.
     *
     * @param component The component to set up key bindings for.
     */
    public void setupKeyBindings(JComponent component) {
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = component.getInputMap(condition);
        ActionMap actionMap = component.getActionMap();

        for (int i = 0; i < 256; i++) {
            final int keyCode = i;
            inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), "key" + keyCode);
            actionMap.put("key" + keyCode, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    keyStates.put(keyCode, true);
                }
            });

            inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, true), "release" + keyCode);
            actionMap.put("release" + keyCode, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    keyStates.put(keyCode, false);
                }
            });
        }
    }

    /**
     * Checks if a specific key is currently down.
     *
     * @param keyCode The key code of the key to check.
     * @return true if the key is down, false otherwise.
     */
    public boolean isKeyDown(int keyCode) {
        return keyStates.getOrDefault(keyCode, false);
    }
}