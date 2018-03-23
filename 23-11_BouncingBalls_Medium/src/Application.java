import javax.swing.*;

/**
 * Driver class for random circle program, generates circle, and calls panel and frame constructors to
 * initialize the GUI elements and display the image
 * @author conorhenry
 */

public class Application{
    /**
     * FRAME_DELAY- {@value}, the number of ms after which repaint() is called to refresh the Panel
     */
    private static final int FRAME_DELAY=10;

    /**
     * Main method initializes frame and calls repaint() evert FRAME_DELAY ms (1.5s)
     * @param args
     */
    public static void main(String[] args) {
        Frame window= new Frame(1000,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        for(;;){
            try{
                Thread.sleep(FRAME_DELAY);
                window.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}