import javax.swing.*;

/**
 * Main ColorChooser is a subclass of JFrame, creates the main window where the colorChooser will be shown
 * @author conorhenry
 */
public class ColorChooser extends JFrame{
    /**
     * JPanel subclass object which is a colored rectangle showing the selected color
     */
    private ColorPanel rectangle = new ColorPanel();

    /**
     * Array of SliderPanel objects, each consisting of a JLabel, a JSlider, and a JFormattedTextField
     * Implementing them as an array makes it easier to add more channels if desired and reduced repeated
     * code compared to grouping all the components for all the channels into a single JPanel
     */
    private SliderPanel[] adjustments;

    /**
     * Enum Channel containing ordered constants representing the red, green, and blue channels
     * Additional channels can be added easily
     */
    public enum Channel{RED,GREEN,BLUE}

    /**
     * NUMBER_OF_CHANNELS- {@value} The number of color channels
     */
    private static final int NUMBER_OF_CHANNELS=3;//

    /**
     * no-arg constructor for ColorChooser objects. Sets JFrame title
     * and adds components to frame in a vertical BoxLayout
     */
    public ColorChooser(){
        super("Color Chooser");
        super.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.adjustments =new SliderPanel[NUMBER_OF_CHANNELS];
        this.rectangle=SliderPanel.getColorPanel();
        this.add(rectangle);
        for(Channel channel:Channel.values()) {
            adjustments[channel.ordinal()]=new SliderPanel(channel);
            this.add(adjustments[channel.ordinal()]);
        }
    }
}
