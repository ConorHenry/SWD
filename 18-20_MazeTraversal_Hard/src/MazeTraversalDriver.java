/**
 * Driver Class for MazeTraversal program, provides the maze and startpoint to start the traversal.
 * @author conorhenry
 */
public class MazeTraversalDriver {

    /**
     * Main function for MazeTraversal program, creates a MazeTraversal object with the maze provided by the book
     * @param a
     */
    public static void main(String... a){
        System.out.println(MazeTraversal.class.getPackage().getName());
        MazeTraversal mazeTraversal= new MazeTraversal(new MazeTraversal.Block[][]
                //example maze found in the book
                {

                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL,    MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.PASSAGE, MazeTraversal.Block.WALL},
                        {MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL,    MazeTraversal.Block.WALL}
                },0,2);
        mazeTraversal.solve();
    }
}

