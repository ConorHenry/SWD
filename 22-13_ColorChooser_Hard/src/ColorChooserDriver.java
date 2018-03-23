import javax.swing.*;

/**
 * Driver class for ColorChooser, creates and displays instance of ColorChooser frame
 * @author conorhenry
 */
public class ColorChooserDriver {
    public static void main (String[] args) {
        ColorChooser colorChooser = new ColorChooser();
        colorChooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorChooser.pack();
        colorChooser.setResizable(false);
        colorChooser.setVisible(true);
    }
}
