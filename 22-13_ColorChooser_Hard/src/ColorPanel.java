import javax.swing.*;
import java.awt.*;

/**
 * ColorPanel class is a JPanel subclass which defines a solid rectangle of the specified color
 * @author conorhenry
 */
public class ColorPanel extends JPanel {

    /**
     * The color of the rectangle, specified by the other controls
     */
    private Color color;

    /**
     * width- {@value}, the preferred width of the colored rectangle
     * can't be static because needed in paintComponent(Graphics) method
     */
    private final int width=270;

    /**
     * width- {@value}, the preferred height of the colored rectangle
     * can't be static because needed in paintComponent(Graphics) method
     */
    private final int height=180;

    /**
     * no-arg constructor for ColorPanel, initializes color to black and sets the panel's preferred size.
     */
    public ColorPanel(){
        this.color=new Color(0,0,0);
        this.setPreferredSize(new Dimension(width,height));
    }

    /**
     * Method to change the value of a single channel of an RGB color
     * @param channel ColorChooser.Channel object to specify the channel to be changed
     * @param newVal the new value for that channel, an integer between 0 and 255
     * @see ColorChooser.Channel
     */
    public void setColorComponent(ColorChooser.Channel channel, int newVal) {
        switch (channel) {
            case RED:
                color = new Color(newVal, color.getGreen(), color.getBlue());
                break;
            case GREEN:
                color = new Color(color.getRed(), newVal, color.getBlue());
                break;
            case BLUE:
                color = new Color(color.getRed(), color.getGreen(), newVal);
                break;
            default:
                throw new RuntimeException("Error: should be unreachable.\n This function does not recognize " + channel);
        }
        repaint();
    }

    /**
     * Overridden paintComponent method from JPanel sets the color and paints a rectangle in that color
     * @param g Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0,0, width, height);
    }
}