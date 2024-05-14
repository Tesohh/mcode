package grammar;

import javax.swing.text.Style;
import java.awt.*;

public class Stylesheet {
    public Stylish arithmetic; // jonta, sotra
    public Stylish comparison; // maor, mender, valif, desvalif
    public Stylish primitives; // se, lasa, retorn, cmd, no
    public Stylish builtins;   // stampa
    public Stylish fg;         // regular text
    public Stylish comments;
    public Stylish strings;
    public Stylish special = new Stylish("special", Stylish.getColor("#00FF1E"), "Trattatello", 500);

    public Color bg;
    public Color statusbarBg;
    public Color statusbarFg;

    public Stylesheet(
        Stylish arithmetic,
        Stylish comparison,
        Stylish primitives,
        Stylish builtins,
        Stylish fg,
        Stylish strings,
        Stylish comments,
        Color bg,
        Color statusbarBg,
        Color statusbarFg
    ) {
        this.arithmetic = arithmetic;
        this.comparison = comparison;
        this.primitives = primitives;
        this.builtins = builtins;
        this.fg = fg;
        this.strings = strings;
        this.comments = comments;
        this.bg = bg;
        this.statusbarBg = statusbarBg;
        this.statusbarFg = statusbarFg;
    }
}
