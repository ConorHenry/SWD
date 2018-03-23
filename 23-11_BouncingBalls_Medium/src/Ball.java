import java.awt.*;
import java.util.Random;

/**
 * Ball class implements Runnable interface so that each balls position can be computed using multithreading
 * @author conorhenry
 */
public class Ball implements Runnable{
    /**
     * The X position of the ball (seems to be the point in the upper left corner of the smallest rectangle that can
     * contain the circle.
     */
    private int x;

    /**
     * The Y position of the ball (seems to be the point in the upper left corner of the smallest rectangle that can
     * contain the circle.
     */
    private int y;

    /**
     * radius of the ball
     */
    private int radius;

    /**
     * The color of the ball
     */
    private Color color;
    /**
     * The ball's velocity in the positive X direction
     */
    private int xVelocity;
    /**
     * The ball's velocity in the positive Y direction
     */
    private int yVelocity;

    /**
     * The upper boundary on the X axis at which point the ball bounces;
     */
    private int xWall;

    /**
     * The upper boundary on the Y axis at which point the ball bounces;
     */
    private int yWall;

    /**
     * MIN_VELOCITY- {@value}, The maximum number of pixels any ball may move between frames/refreshes
     */
    private static final int MAX_VELOCITY=10;

    /**
     * MIN_VELOCITY- {@value}, The minimum number of pixels any ball may move between frames/refreshes
     */
    private static final int MIN_VELOCITY=1;

    /**
     * MAX_RADIUS- {@value}, The maximum radius of any ball
     */
    private static final int MAX_RADIUS=80;

    /**
     * MIN_RADIUS- {@value}, The minimum radius of any ball
     */
    private static final int MIN_RADIUS=10;

    /**
     * MAX_CHANNEL_VAL- {@value}, The Maximum value any 8bit color channel (including alpha) can legally reach
     */
    private static final int MAX_CHANNEL_VAL=255;

    /**
     * MIN_CHANNEL_VAL- {@value}, the minimum opacity allowed by the program, controlled to reduce invisible balls
     */
    private static final int MIN_ALPHA_VAL=120;


    /**
     * 8-argument constructor for Ball class initializes private variables
     * @param x The X position of the ball (seems to be the point in the upper left corner of the smallest rectangle
     *          that can contain the circle.
     * @param y The Y position of the ball (seems to be the point in the upper left corner of the smallest rectangle
     *          that can contain the circle.
     * @param radius radius of the ball
     * @param color the color of the ball (RGBA)
     * @param xVelocity The ball's velocity in the positive X direction
     * @param yVelocity The ball's velocity in the positive Y direction
     * @param xWall The upper boundary on the X axis at which point the ball hits a "wall" and bounces
     * @param yWall The upper boundary on the Y axis at which point the ball hits a "wall" and bounces
     */
    public Ball(int x, int y, int radius, Color color, int xVelocity, int yVelocity, int xWall, int yWall){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.color=color;
        this.xVelocity=xVelocity;
        this.yVelocity=yVelocity;
        this.xWall=xWall;
        this.yWall=yWall;

}

    /**
     * 3 argument Constructor for Ball class used to randomize all variables
     * @param xWall The upper boundary on the X axis at which point the ball hits a "wall" and bounces
     * @param yWall The upper boundary on the Y axis at which point the ball hits a "wall" and bounces
     * @param rand a Random object seeded by the x coordinate of the mouse click. Clicking in the same
     *             place repeatedly will generate the same ball, while moving the mouse before clicking
     *             will create a new ball each time.
     */
    public Ball(int xWall, int yWall, Random rand){
        this(
                rand.nextInt(xWall-2*MAX_RADIUS),//set all to random
                rand.nextInt(yWall-2*MAX_RADIUS),
                rand.nextInt(MAX_RADIUS-MIN_RADIUS)+MIN_RADIUS,
                new Color(
                        rand.nextInt(MAX_CHANNEL_VAL),
                        rand.nextInt(MAX_CHANNEL_VAL),
                        rand.nextInt(MAX_CHANNEL_VAL),
                        rand.nextInt(MAX_CHANNEL_VAL-MIN_ALPHA_VAL)+MIN_ALPHA_VAL),
                rand.nextInt(MAX_VELOCITY-MIN_VELOCITY)+MIN_VELOCITY,
                rand.nextInt(MAX_VELOCITY-MIN_VELOCITY)+MIN_VELOCITY,
                xWall,
                yWall
        );
    }

    /**
     * Overridden run() method from runnable interface, regularly updates each ball's position as it moves
     * around the screen.
     */
    @Override
    public void run(){
        for(;;) {
            try {
                if (x+2*radius>= xWall || x <= 0)
                    xVelocity = -xVelocity;
                if (y+2*radius >= yWall || y <= 0)
                    yVelocity = -yVelocity;
                x += xVelocity;
                y += yVelocity;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Getter method for x coordinate of this Ball object
     * @return The X position of the ball (seems to be the point in the upper left corner of the smallest rectangle that can
     * contain the circle.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter method for y coordinate of this Ball object
     * @return The Y position of the ball (seems to be the point in the upper left corner of the smallest rectangle that can
     * contain the circle.
     */
    public int getY() {
        return y;
    }

    /**
     * Getter method for radius of this Ball object
     * @return the radius of the circle as an int
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Getter method for color of this Ball object
     * @return the radius of the circle as an int
     */
    public Color getColor() {
        return color;
    }
}
