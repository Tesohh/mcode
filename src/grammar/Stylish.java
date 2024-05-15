package grammar;

import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;

public class Stylish {
    public String name;
    public Color color;
    public String font;
    public int size = 16;

    public Stylish(String name, Color color, String font) {
        this.name = name;
        this.color = color;
        this.font = font;
    }

    public Stylish(String name, Color color, String font, int size) {
        this.name = name;
        this.color = color;
        this.font = font;
        this.size = size;
    }

    public Style toStyle(StyleContext context) {
        var style = context.addStyle(name, null);
        updateStyle(style);
        return style;
    }

    public void updateStyle(Style style) {
        StyleConstants.setForeground(style, color);
        StyleConstants.setFontFamily(style, font);
        StyleConstants.setFontSize(style, size);
    }

    public static Color getColor(String hexColor) {
        if (hexColor.startsWith("#")) {
            hexColor = hexColor.substring(1);
        }
        int rgb = Integer.parseInt(hexColor, 16);
        return new Color(rgb);
    }
}
