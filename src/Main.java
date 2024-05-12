import java.util.Optional;

import javax.swing.*;
import state.Buffer;
import state.State;
import gui.App;

public class Main extends JFrame {
    public Main() {
        super("mcode");

        State.buffer = Optional.of(new Buffer("example.tr"));
        State.app = new App();

        setIconImage(new ImageIcon("icon.png").getImage());
        add(State.app);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });        
    }
}
