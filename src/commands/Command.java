package commands;

import javax.swing.Action;

public class Command {
    public String name;
    public String shortcut;
    public Action action;

    public Command(String name, String shortcut, ActionHandler action) {
        this.name = name;
        this.shortcut = shortcut;
        this.action = ActionFactory.from(action);
    }
}
