package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean upRightPressed, upLeftPressed, downRightPressed, downLeftPressed;

    private Map<String, Integer> keyBindings;

    public KeyHandler() {
        keyBindings = new HashMap<>();

        // Prompt user to choose key bindings
        String[] options = {"Use default keys", "Set custom keys"};
        int choice = JOptionPane.showOptionDialog(
            null, 
            "Do you want to use the default direction keys (WASD) or set your own?", 
            "Key Bindings", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            options[0]
        );

        if (choice == 1) {
            setCustomKeyBindings();
        } else {
            setDefaultKeyBindings();
        }
    }

    private void setDefaultKeyBindings() {
        keyBindings.put("up", KeyEvent.VK_W);
        keyBindings.put("down", KeyEvent.VK_S);
        keyBindings.put("left", KeyEvent.VK_A);
        keyBindings.put("right", KeyEvent.VK_D);
        keyBindings.put("upRight", KeyEvent.VK_E);
        keyBindings.put("upLeft", KeyEvent.VK_Q);
        keyBindings.put("downRight", KeyEvent.VK_C);
        keyBindings.put("downLeft", KeyEvent.VK_Z);
    }

    private void setCustomKeyBindings() {
        keyBindings.put("up", askForKey("up"));
        keyBindings.put("down", askForKey("down"));
        keyBindings.put("left", askForKey("left"));
        keyBindings.put("right", askForKey("right"));
        keyBindings.put("upRight", askForKey("upRight"));
        keyBindings.put("upLeft", askForKey("upLeft"));
        keyBindings.put("downRight", askForKey("downRight"));
        keyBindings.put("downLeft", askForKey("downLeft"));
    }

    private int askForKey(String direction) {
        String key = JOptionPane.showInputDialog("Enter the key for " + direction + " direction:");
        return KeyEvent.getExtendedKeyCodeForChar(key.charAt(0));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // Returns the integer keyCode associated with the key in this event
        if (code == keyBindings.get("up")) {
            upPressed = true;
        }
        if (code == keyBindings.get("down")) {
            downPressed = true;
        }
        if (code == keyBindings.get("left")) {
            leftPressed = true;
        }
        if (code == keyBindings.get("right")) {
            rightPressed = true;
        }
        if (code == keyBindings.get("upRight")) {
            upRightPressed = true;
        }
        if (code == keyBindings.get("upLeft")) {
            upLeftPressed = true;
        }
        if (code == keyBindings.get("downRight")) {
            downRightPressed = true;
        }
        if (code == keyBindings.get("downLeft")) {
            downLeftPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); // Returns the integer keyCode associated with the key in this event
        if (code == keyBindings.get("up")) {
            upPressed = false;
        }
        if (code == keyBindings.get("down")) {
            downPressed = false;
        }
        if (code == keyBindings.get("left")) {
            leftPressed = false;
        }
        if (code == keyBindings.get("right")) {
            rightPressed = false;
        }
        if (code == keyBindings.get("upRight")) {
            upRightPressed = false;
        }
        if (code == keyBindings.get("upLeft")) {
            upLeftPressed = false;
        }
        if (code == keyBindings.get("downRight")) {
            downRightPressed = false;
        }
        if (code == keyBindings.get("downLeft")) {
            downLeftPressed = false;
        }
    }
}
