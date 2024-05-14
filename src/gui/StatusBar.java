package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

import state.State;

public class StatusBar extends JPanel {
    public JLabel filename = new JLabel("[new file]");
    public JLabel mcode = new JLabel("mcode v1");

    public StatusBar() {
        JLabel[] left = {filename};
        JLabel[] right = {mcode};

        setLayout(new BorderLayout());
        for (var l : left) {
            l.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
            add(l, BorderLayout.WEST);
        }

        setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));

        for (var l : right) {
            l.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
            add(l, BorderLayout.EAST);
        }
    }

    public void updateStyle() {
        setBackground(State.stylesheet.statusbarBg);

        for (var component : this.getComponents()) {
            component.setForeground(State.stylesheet.statusbarFg);
        }
    }

    public void update() {
        State.buffer.ifPresentOrElse(
            b -> {
                var name = b.path.toString();
                if (b.dirty) {
                    name += " [+]";
                }
                filename.setText(name);
            },
            () -> { filename.setText("[new file]");}
        );
    }
}
