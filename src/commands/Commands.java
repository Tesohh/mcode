package commands;

import java.io.FileWriter;
import java.io.IOException;

import state.State;
import state.Buffer;

import javax.swing.*;

public class Commands {
    public static Command[] commands = {
        new Command("write", "meta S", e -> {
            State.buffer.ifPresentOrElse(
                b -> {
                    try {
                        var fw = new FileWriter(b.path.toString());
                        var textPane = (JTextPane) e.getSource();
                        fw.write(textPane.getText());
                        fw.close();

                        b.dirty = false;
                        State.app.status.update();
                    }
                    catch (IOException err) {System.out.println("TODO: Handle"); err.printStackTrace();}
                },
            () -> {}
            );

        })
    };
}
