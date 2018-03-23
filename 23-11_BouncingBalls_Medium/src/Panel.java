import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Container which inherits from JPanel to serve as the stage where the balls with bounce around within the frame
 *
 * @author conorhenry
 */
public class Panel extends JPanel {

    /**
     * ExecutorService object for handling threading and running Ball classes runnable method
     */
    private ExecutorService executorService; // for running Ball runnable

    /**
     * ArrayList of all the balls currently on the screen
     */
    private ArrayList<Ball> activeBalls = new ArrayList<>();
    /**
     * MAX_BALLS - {@value}, The maximum number of balls to be displayed on the screen at once before new balls stop spawning
     */
    private static final int MAX_BALLS = 100;// max number of balls that can be created

    /**
     * Constructor for Panel contains mouse listener as anonymous inner class, and implements multithreading logic
     *
     * @param width The width of the panel (will be cut off if width of frame is smaller)
     * @param height The height of the panel (will be cut off if height of frame is smaller)
     */

    public Panel(int width, int height){
        executorService = Executors.newCachedThreadPool(); // initialize executorService
        addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                Random rand=new Random(e.getX());
                if( ((ThreadPoolExecutor)executorService).getActiveCount() < MAX_BALLS ){
                    Ball newBall=new Ball(width, height, rand);
                    activeBalls.add(newBall);
                    executorService.execute(newBall); // execute the ball in its own thread
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
            @Override
            public void mousePressed(MouseEvent e){}
            @Override
            public void mouseReleased(MouseEvent e){}
        } ); // add mouse listener to panel
    }

    /**
     * Overridden paintComponent method from JPanel class, paints each ball in the order they were spawned, thus, Ball
     * objects which were instantiated later will appear in front of those created earlier
     * @param g Graphics object to be drawn
     */
    @Override
    public void paintComponent( Graphics g ){
        super.paintComponent(g); // clears drawing area
        for(Ball ball:activeBalls){
            g.setColor(ball.getColor());
            g.fillOval(ball.getX(), ball.getY(), ball.getRadius()*2, ball.getRadius()*2);
        }
    }
}
