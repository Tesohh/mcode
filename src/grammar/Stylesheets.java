package grammar;

import javax.swing.text.StyleContext;
import java.awt.*;

public class Stylesheets {
    public Stylesheet rosepine = new Stylesheet(
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

    public Stylesheet terminal = new Stylesheet(
            new Stylish("arithmetic", Stylish.getColor("#00FF00"), "Noteworthy"),
            new Stylish("comparison", Stylish.getColor("#00FF00"), "Phosphate"),
            new Stylish("primitives", Stylish.getColor("#00FF00"), "Party LET", 32),
            new Stylish("builtins", Stylish.getColor("#00FF00"), "BigBlue Terminal 437TT"),
            new Stylish("fg", Stylish.getColor("#00FF00"), "Menlo"),
            new Stylish("strings", Stylish.getColor("#00FF00"), "Papyrus"),
            new Stylish("comments", Stylish.getColor("#00FF00"), "Zapfino"),

            Stylish.getColor("#000000"),
            Stylish.getColor("#000000"),
            Stylish.getColor("#00FF00")
    );

    public Stylesheets() {}
}
