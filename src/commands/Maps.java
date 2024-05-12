package commands;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;



public class Maps {
    public InputMap inputMap;
    public ActionMap actionMap;

    public Maps(InputMap inputMap, ActionMap actionMap) {
        this.inputMap = inputMap;
        this.actionMap = actionMap;

        for (var cmd : Commands.commands) {
            this.inputMap.put(KeyStroke.getKeyStroke(cmd.shortcut), cmd.name);
            this.actionMap.put(cmd.name, cmd.action);
        }
    }
}
