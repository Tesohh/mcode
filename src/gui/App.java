package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import state.State;

public class App extends JPanel {
    private String content;
    public Editor editor;
    public StatusBar status;

    public App() {
        State.buffer.ifPresent(b -> {
            try { content = Files.readString(b.path, StandardCharsets.UTF_8); } 
            catch (IOException e) { System.out.println(e); }
        });

        editor = new Editor();
        editor.setBorder(new EmptyBorder(10, 10, 10, 10));
        editor.setText(content);
        editor.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));

        status = new StatusBar();
        status.update();

        setLayout(new BorderLayout());
        setSize(800, 600);
        add(editor, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
    }
}
