package commands;

import java.io.FileWriter;
import java.io.IOException;

import grammar.Stylesheets;
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
        }),
        new Command("styleforward", "meta alt T", e -> {
            System.out.println("meta alt t");
            int index = 0;
            for (int i=0; i < Stylesheets.order.length; i++) {
                if (Stylesheets.order[i] == State.stylesheet) { index = i; }
            }

            index += 1;
            if (index >= Stylesheets.order.length) index = 0;
            State.stylesheet = Stylesheets.order[index];
            State.app.editor.updateStyle();
            State.app.status.updateStyle();
        }),

        new Command("execute", "meta E", e -> {
            var os = System.getProperty("os.name").toLowerCase();
            var builder = new ProcessBuilder();

            State.buffer.ifPresent(buffer -> {
                if (os.startsWith("mac")) {
                    var script = String.format("tell application \"Terminal\" to do script \"%s %s\"", State.settings.torcolPath.toAbsolutePath(), buffer.path.toAbsolutePath());
                    System.out.println(script);
                    builder.command("osascript", "-e", script);
                } else if (os.startsWith("windows")) {
                    var script = "";
                    builder.command("cmd", "/c", "start", "cmd", "/k", script);
                }

                try {
                    builder.start();
                } catch (IOException err) {
                    err.printStackTrace();
                }
            });


        })
    };
}
