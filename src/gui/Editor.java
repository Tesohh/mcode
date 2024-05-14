package gui;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;

import commands.Maps;
import state.State;
import grammar.SyntaxHighlighter;

import java.awt.*;

public class Editor extends JTextPane {
    private int ignoredUpdates = 0;

    public Editor() {
        new Maps(getInputMap(WHEN_FOCUSED), getActionMap());

        SyntaxHighlighter.highlight(this);

        // set statusbar as dirty
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { onInsertion(e); }
            @Override
            public void removeUpdate(DocumentEvent e) { onInsertion(e); }
            @Override
            public void changedUpdate(DocumentEvent e) { }
        });
    }

    public void onInsertion(DocumentEvent e) {
        if (ignoredUpdates < 2) { // SMARCIO CODICE
            ignoredUpdates += 1;
            return;
        }

        SyntaxHighlighter.highlight(this);

        State.buffer.ifPresent(buffer -> {
            buffer.dirty = true;
        });
        State.app.status.update();
    }

    public void updateStyle() {
        setBackground(State.stylesheet.bg);
        setCaretColor(State.stylesheet.fg.color);
    }
}

//class RangeHighlighter {
//    String[] papyrus = {"stampa"};
//    public static void highlight(JTextPane textPane) {
//        var context = StyleContext.getDefaultStyleContext();
//        var defaultStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
//
//        var papyrusStyle = context.addStyle("papyrus", null);
//        StyleConstants.setFontFamily(papyrusStyle, "papyrus");
//\
//        var doc = textPane.getStyledDocument();
//
//        // TODO: populate
//        doc.addDocumentListener(new DocumentListener() {
//            @Override public void insertUpdate(DocumentEvent e) {updateHighlighting(e);}
//            @Override public void removeUpdate(DocumentEvent e) {updateHighlighting(e);}
//            @Override public void changedUpdate(DocumentEvent e) {}
//
//            private void updateHighlighting(DocumentEvent e) {}
//            private void highlightKeyword(StyledDocument doc, String text, String keyword) {}
//        });
//    }
//}


