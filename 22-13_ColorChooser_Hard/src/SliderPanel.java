import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.BoxLayout.X_AXIS;

/**
 * SliderPanel class, a subclass of JPanel, creates a small horizontal panel containing a JLabel,
 * a JSlider, and a JFormattedTextField, and actionListeners for the latter two. One SliderPanel
 * is created for each color channel.
 * @author conorhenry
 */
public class SliderPanel extends JPanel {
    /**
     * Static ColorPanel object is a Colored rectangle that shows the specified color, shared between all SliderPanels
     * so they can all change it
     */
    private static ColorPanel rectangle=new ColorPanel();

    /**
     * JLabel stating the color channel name
     */
    private JLabel label;

    /**
     * JSlider to control this channel
     */
    private JSlider slider;

    /**
     * JFormattedTextField can take input from user and also display the current value of this channel
     */
    private JFormattedTextField input;

    /**
     * Constant array containing the names of the three channels
     */
    private static final String[] COLOR_NAMES=new String[]{"Red:    ","Green: ", "Blue:   "};

    /**
     * 1-arg constructor for SliderPanel class creates a SliderPanel object for the specified color channel with
     * initial value set to 0
     * @param channel
     */
    public SliderPanel(ColorChooser.Channel channel){
        //this.channel=channel;
        this.label=new JLabel(COLOR_NAMES[channel.ordinal()]);
        slider=new JSlider(0,255,0);
        //if slider is changed
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value=slider.getValue();
                input.setText(""+value);//update JFormattedTextField
                rectangle.setColorComponent(channel,value); //update rectangle color
            }
        });

        input=new JFormattedTextField(new RegexFormatter("^([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$"));
        //if enter is pressed
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value=Integer.parseInt(input.getText());
                slider.setValue(value);//update slider
                rectangle.setColorComponent(channel,value); //update rectangle color
            }
        });

        this.setLayout(new BoxLayout(this,X_AXIS));
        this.add(label);
        this.add(slider);
        this.add(input);
    }

    /**
     * Getter method for the ColorPanel object rectangle
     * @return rectangle, the ColorPanel object
     */
    public static ColorPanel getColorPanel() {
        return rectangle;
    }

}
