/**
 * MazeTraversal class provides a representation of the maze to be solved as a 2d array of enum objects (Wall, Passage,
 * and Path) and methods for solving it recursively according to the algorithm described in the book.
 *
 *    "
 *       The grid of #s and dots (.) in Fig. 18.22 is a two-dimensional array representation of a maze. The #s represent
 *       the walls of the maze, and the dots represent locations in the possible paths through the maze. A move can be made
 *       only to a location in the array that contains a dot.
 *
 *       # # # # # # # # # # # #
 *       # . . . # . . . . . . #
 *       . . # . # . # # # # . #
 *       # # # . # . . . . # . #
 *       # . . . . # # # . # . .
 *       # # # # . # . # . # . #
 *       # . . # . # . # . # . #
 *       # # . # . # . # . # . #
 *       # . . . . . . . . # . #
 *       # # # # # # . # # # . #
 *       # . . . . . . # . . . #
 *       # # # # # # # # # # # #
 *
 *
 *       Write a recursive method (mazeTraversal) to walk through mazes like the one in Fig. 18.22. The method should
 *       receive as arguments a 12-by-12 character array representing the maze and the current location in the maze (the
 *       first time this method is called, the current location should be the entry point of the maze). As mazeTraversal
 *       attempts to locate the exit, it should place the charac- ter x in each square in the path. There’s a simple
 *       algorithm for walking through a maze that guar- antees finding the exit (assuming there’s an exit). If there’s no
 *       exit, you’ll arrive at the starting location again. The algorithm is as follows: From the current location in the
 *       maze, try to move one space in any of the possible directions (down, right, up or left). If it’s possible to move
 *       in at least one direction, call mazeTraversal recursively, passing the new spot on the maze as the current spot.
 *       If it’s not possible to go in any direction, “back up” to a previous location in the maze and try a new direction for
 *       that location (this is an example of recursive backtracking). Program the method to display the maze after each move
 *       so the user can watch as the maze is solved. The final output of the maze should display only the path needed to solve
 *       the maze—if going in a particular direction results in a dead end, the x’s going in that direction should not be
 *       displayed. [Hint: To display only the final path, it may be helpful to mark off spots that result in a dead end with
 *       another character (such as '0').]
 *
 *    "
 *    @author conorhenry
 */
public  class MazeTraversal {
    /**
     * Enum Block is used to represent the maze internally in place of the characters that are used to display it
     * in order to allow limit the number of possible blocks to those recognized by the program internally.
     * The blocks are:
     * WALL: a wall of the maze, cannot be traversed, represented in text by "#"
     * PASSAGE: a path that can be traversed, but has not yet been traversed on the current pass of the solving algorithm
     * PATH: a passage that has already been traversed on the current path of the solving algorithm
     */
    public enum Block {
        WALL('#'), PASSAGE('.'), PATH('x');
        public char character;

        /**
         * Constructor for Block enum
         * @param c the character representation of this block
         */
        Block(char c){ this.character=c; }
    }

    /**
     * The x coordinate of the starting position
     */
    private int xStart;
    /**
     * The y coordinate of the starting position
     */
    private int yStart;
    /**
     * The maze, represented as a 2D array of Block objects, WALL, PASSAGE, and PATH
     * @see Block
     */
    private Block[][] maze;

    /**
     * MAX_X- {@value}, The width of the maze,
     */
    private static final int MAX_X=12;

    /**
     * MAX_Y- {@value}, The width of the maze,
     */
    private static final int MAX_Y=12;


    /**
     * 3-arg constructor for MazeTraversal class,
     * @param maze The maze, represented as a 2D array of {@link Block #Block} objects, WALL, PASSAGE, and PATH
     * @param x The x coordinate of the starting position
     * @param y The y coordinate of the starting position
     */
    public MazeTraversal(Block[][] maze, int x, int y){
        this.maze=maze;
        this.xStart=x;
        this.yStart=y;
    }

    /**
     * Starter function makes the first call to the recursive traverse function, and displays a message to the user
     * in the case that the maze has no exit
     */
    public void solve(){
        if(!traverse(xStart,yStart))
            System.out.println("No exit was found");

    }

    /**
     * The recursive traversal function for the maze outlined in the book.
     *
     * "
     *       As mazeTraversal attempts to locate the exit, it should place the charac- ter x in each square in the path.
     *       There’s a simple algorithm for walking through a maze that guar- antees finding the exit (assuming there’s
     *       an exit). If there’s no exit, you’ll arrive at the starting location again. The algorithm is as follows:
     *       From the current location in the maze, try to move one space in any of the possible directions (down,
     *       right, up or left). If it’s possible to move in at least one direction, call mazeTraversal recursively,
     *       passing the new spot on the maze as the current spot. If it’s not possible to go in any direction, “back
     *       up” to a previous location in the maze and try a new direction for that location (this is an example of
     *       recursive backtracking). Program the method to display the maze after each move so the user can watch as
     *       the maze is solved. The final output of the maze should display only the path needed to solve the maze—if
     *       going in a particular direction results in a dead end, the x’s going in that direction should not be displayed.
     * "
     * @param x the x coordinate of current position in the maze,
     * @param y the y coordinate of current position in the maze,
     * @return true if the sub-path being explored leads to the maze's exit, false otherwise
     */
    public boolean traverse(int x, int y){
        System.out.print(this);
        if((y==11 || x==11 || x==0 || y==0)){//if current location is on the border (i.e. start point or end point)
            if(maze[y][x]==Block.PATH){//if on end point
                return true;
            }
            maze[y][x]=Block.PATH;//changes starting point to x
        }
        for(int i=-1;i<=1;i++){ //for each of the four possible directions
            for(int j = (i==0) ? -1 : 0; j<=1; j+=2){
                //if maze is a passage (not a wall, and hasn't been visited, not out of bounds)
                if((y+i)>=0 && (x+j)>=0 && (y+i)<MAX_Y && (x+j)<MAX_X && maze[y+i][x+j]==Block.PASSAGE){
                    maze[y+i][x+j]=Block.PATH;
                    if(traverse(x+j,y+i)){
                        return true;
                    }
                }
            }
        }
        maze[y][x]=Block.PASSAGE; //mark the location as part of the solution path
        return false;
    }

    /**
     * Overridden toString method for displaying the maze to the user as text. Uses # to represent walls, . to represent
     * passages, and x to represent passages that are part of the current path being explored
     * @return the result of the StringBuilder containing the entire maze text representation
     */
    @Override
    public String toString(){
        StringBuilder result= new StringBuilder();
        for(int y=0;y<MAX_Y;y++){
            result.append("\n");
            for(int x=0;x<MAX_X;x++){
                result.append(" "+maze[y][x].character);
            }
        }
        result.append("\n\n");
        return result.toString();
    }
}


