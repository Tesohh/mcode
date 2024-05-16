package grammar;

import javax.swing.text.StyleContext;
import java.awt.*;

public class Stylesheets {
    public static Stylesheet rosepine = new Stylesheet(
            new Stylish("arithmetic", Stylish.getColor("#9ccfd8"), "Noteworthy"),
            new Stylish("comparison", Stylish.getColor("#31748f"), "Phosphate"),
            new Stylish("primitives", Stylish.getColor("#c4a7e7"), "Party LET", 32),
            new Stylish("builtins", Stylish.getColor("#eb6f92"), "BigBlue Terminal 437TT"),
            new Stylish("fg", Stylish.getColor("#e0def4"), "Menlo"),
            new Stylish("strings", Stylish.getColor("#f6c177"), "Papyrus"),
            new Stylish("comments", Stylish.getColor("#6e6a86"), "Zapfino", 12),

            Stylish.getColor("#191724"),
            Stylish.getColor("#26233a"),
            Stylish.getColor("#e0def4")
            );

    public static Stylesheet terminal = new Stylesheet(
            new Stylish("arithmetic", Stylish.getColor("#00FF00"), "Noteworthy"),
            new Stylish("comparison", Stylish.getColor("#00FF00"), "Phosphate"),
            new Stylish("primitives", Stylish.getColor("#00FF00"), "Party LET", 32),
            new Stylish("builtins", Stylish.getColor("#00FF00"), "BigBlue Terminal 437TT"),
            new Stylish("fg", Stylish.getColor("#00FF00"), "Menlo"),
            new Stylish("strings", Stylish.getColor("#00FF00"), "Papyrus"),
            new Stylish("comments", Stylish.getColor("#00FF00"), "Zapfino", 12),

            Stylish.getColor("#000000"),
            Stylish.getColor("#000000"),
            Stylish.getColor("#00FF00")
    );
    public static Stylesheet vscode = new Stylesheet(
            new Stylish("arithmetic", Stylish.getColor("#569cd6"), "Noteworthy"),
            new Stylish("comparison", Stylish.getColor("#ce9178"), "Phosphate"),
            new Stylish("primitives", Stylish.getColor("#569cd6"), "Party LET", 32),
            new Stylish("builtins", Stylish.getColor("#DCDCAA"), "BigBlue Terminal 437TT"),
            new Stylish("fg", Stylish.getColor("#cccccc"), "Menlo"),
            new Stylish("strings", Stylish.getColor("#ce9178"), "Papyrus"),
            new Stylish("comments", Stylish.getColor("#7ca668"), "Zapfino", 12),

            Stylish.getColor("#1e1e1e"),
            Stylish.getColor("#007acc"),
            Stylish.getColor("#cccccc")
    );

    public static Stylesheet solarized = new Stylesheet(
            new Stylish("arithmetic", Stylish.getColor("#b58900"), "Noteworthy"),
            new Stylish("comparison", Stylish.getColor("#dc322f"), "Phosphate"),
            new Stylish("primitives", Stylish.getColor("#6c71c4"), "Party LET", 32),
            new Stylish("builtins", Stylish.getColor("#859900"), "BigBlue Terminal 437TT"),
            new Stylish("fg", Stylish.getColor("#fdf6e3"), "Menlo"),
            new Stylish("strings", Stylish.getColor("#859900"), "Papyrus"),
            new Stylish("comments", Stylish.getColor("#586e75"), "Zapfino", 12),

            Stylish.getColor("#002b36"),
            Stylish.getColor("#073642"),
            Stylish.getColor("#839496")
    );

    public static Stylesheet[] order = {rosepine, terminal, vscode, solarized};

    public Stylesheets() {}
}
