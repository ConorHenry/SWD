import javax.swing.*;
import java.awt.*;

/**
 * Class Frame is a JFrame which holds (and creates) the Panel Object
 *@author conorhenry
 */
public class Frame extends JFrame {
    private final Panel displayPanel;

    /**
     * Constructor creates Frame object and it's private Panel object
     *
     * @param width width of frame
     * @param height  height of frame
     */
    public Frame(int width, int height){
        super("Look at at them boys go");
        pack(); //necessary in order to get correct Insets before displaying panel
        setSize(width,height);
        System.out.println(getInsets().top);
        displayPanel=new Panel(width,height-getInsets().top);
        add(displayPanel); //add panel to JFrame
    }
}
