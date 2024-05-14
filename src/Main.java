import java.util.Optional;

import javax.swing.*;

import grammar.Stylesheets;
import state.Buffer;
import state.State;
import gui.App;

public class Main extends JFrame {
    public Main() {
        super("mcode");

        State.buffer = Optional.of(new Buffer("example.tr"));
        State.stylesheet = new Stylesheets().rosepine;
        State.app = new App();
        State.app.editor.updateStyle();
        State.app.status.updateStyle();

        setIconImage(new ImageIcon("icon.png").getImage());
        add(State.app);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
