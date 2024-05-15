package grammar;

import state.State;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.util.Base64;

public class SyntaxHighlighter {
    static String[] arithmetic = {"jonta", "sotra"};
    static String[] comparison = {"maor", "mender", "valif", "desvalif"};
    static String[] primitives = {"se", "lasa", "retorn", "cmd", "no"};
    static String[] builtins = {"stampa"};
    public static StyleContext styleContext = StyleContext.getDefaultStyleContext();
    public static Style aritheticStyle = State.stylesheet.arithmetic.toStyle(styleContext);
    public static Style comparisonStyle = State.stylesheet.comparison.toStyle(styleContext);
    public static Style primitivesStyle = State.stylesheet.primitives.toStyle(styleContext);
    public static Style builtinsStyle = State.stylesheet.builtins.toStyle(styleContext);
    public static Style stringStyle = State.stylesheet.strings.toStyle(styleContext);
    public static Style commentsStyle = State.stylesheet.comments.toStyle(styleContext);
    public static Style fgStyle = State.stylesheet.fg.toStyle(styleContext);
    public static Style specialStyle = State.stylesheet.special.toStyle(styleContext);
    static String specialRegex = new String(Base64.getDecoder().decode("bW9kaWNh"));

    public static void updateStyles() {
        System.out.println("geeking");
        State.stylesheet.arithmetic.updateStyle(aritheticStyle);
        State.stylesheet.comparison.updateStyle(comparisonStyle);
        State.stylesheet.primitives.updateStyle(primitivesStyle);
        State.stylesheet.builtins.updateStyle(builtinsStyle);
        State.stylesheet.strings.updateStyle(stringStyle);
        System.out.println(stringStyle.getAttribute("color"));
        State.stylesheet.comments.updateStyle(commentsStyle);
        State.stylesheet.fg.updateStyle(fgStyle);
        State.stylesheet.special.updateStyle(specialStyle);
    }

    static private void highlightKeyword(StyledDocument doc, String text, String keyword, Style style) throws BadLocationException {
        int pos = 0;
        while ((pos = text.indexOf(keyword, pos)) >= 0) {
            doc.setCharacterAttributes(pos, keyword.length(), style, false);
            pos += keyword.length();
        }
    }

    static private void highlightRegex(StyledDocument doc, String text, Style style, String pattern) {
        var regex = java.util.regex.Pattern.compile(pattern);
        var matcher = regex.matcher(text);
        while (matcher.find()) {
            int startPos = matcher.start();
            int endPos = matcher.end();
            doc.setCharacterAttributes(startPos, endPos - startPos, style, false);
        }
    }

    static private void highlightComments(StyledDocument doc, String text, Style style) throws BadLocationException {
        int pos = 0;
        while ((pos = text.indexOf("#", pos)) >= 0) {
            int endPos = text.indexOf("\n", pos);
            if (endPos == -1) {
                endPos = text.length();
            }
            doc.setCharacterAttributes(pos, endPos - pos, style, false);
            pos = endPos;
        }
    }

    static private void highlightDefault(StyledDocument doc, String text, Style style) {
        doc.setCharacterAttributes(0, doc.getLength(), style, true);
    }

    static public void updateHighlighting(StyledDocument doc) {
        SwingUtilities.invokeLater(() -> {
            try {
                String text = doc.getText(0, doc.getLength());
                highlightDefault(doc, text, fgStyle);
                for (String keyword : arithmetic) { highlightKeyword(doc, text, keyword, aritheticStyle); }
                for (String keyword : comparison) { highlightKeyword(doc, text, keyword, comparisonStyle); }
                for (String keyword : primitives) { highlightKeyword(doc, text, keyword, primitivesStyle); }
                for (String keyword : builtins) { highlightKeyword(doc, text, keyword, builtinsStyle); }
                highlightRegex(doc, text, stringStyle, "\"[^\"]*\"");
                highlightRegex(doc, text, stringStyle, "([+-]?(?=\\.\\d|\\d)(?:\\d+)?(?:\\.?\\d*))(?:[Ee]([+-]?\\d+))?");
                highlightRegex(doc, text, specialStyle, specialRegex);
                highlightComments(doc, text, commentsStyle);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void highlight(JTextPane textPane) {


        StyledDocument doc = textPane.getStyledDocument();
        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateHighlighting(doc);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateHighlighting(doc);
            }

            @Override
            public void changedUpdate(DocumentEvent e) { /* dont put anything here or this becomes a fork bomb */ }

            });


//            private void applyDefaultHighlight(StyledDocument doc, String text, Style style) throws BadLocationException {
//                // Remove existing highlighting
//                doc.setCharacterAttributes(0, doc.getLength(), style, true);
//
//                // Define arrays of highlighted elements (keywords, strings, comments)
//                String[] keywords = {"if", "else", "for", "while", "return"};
//                String pattern = "\"[^\"]*\"";
//                java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
//                java.util.regex.Matcher m = p.matcher(text);
//                while (m.find()) {
//                    doc.setCharacterAttributes(m.start(), m.end() - m.start(), style, false);
//                }
//                pattern = "#[^\n]*";
//                p = java.util.regex.Pattern.compile(pattern);
//                m = p.matcher(text);
//                while (m.find()) {
//                    doc.setCharacterAttributes(m.start(), m.end() - m.start(), style, false);
//                }
//            }
        }
        


}
