package gui;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import commands.Maps;
import state.State;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Editor extends JTextPane {
    private int ignoredUpdates = 0;

    public Editor() {
        new Maps(getInputMap(WHEN_FOCUSED), getActionMap());

        // set statusbar as dirty
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { onInsertion(); }
            @Override
            public void removeUpdate(DocumentEvent e) { onInsertion(); }
            @Override
            public void changedUpdate(DocumentEvent e) { onInsertion(); }
        });
    }

    public void onInsertion() {
        if (ignoredUpdates < 2) {
            ignoredUpdates += 1;
            return;
        }

        State.buffer.ifPresent(buffer -> {
            buffer.dirty = true;
        });
        State.app.status.update();
    }
}
