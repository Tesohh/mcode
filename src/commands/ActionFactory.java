package commands;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import state.Buffer;
import state.State;

public class ActionFactory {
    public static AbstractAction from(ActionHandler handler) {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.handle(e);
            }
        };
    }
}
