import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;



public class BucketSortTest {
    private Random rand=new Random();
    private int[] toSort;
    private int[] sorted;


    @Test
    public void test(){
        boolean success=true;
        for(int j=0;j<500000;j++) {
            toSort = new int[rand.nextInt(200)];
            for (int i = 0; i < toSort.length; i++) {
                toSort[i] = rand.nextInt(50000);
            }
            BucketSort sort = new BucketSort(toSort);
            sorted = sort.sort();
            success&=isSorted();
        }
        assertTrue(success);
    }

    public boolean isSorted(){
        int temp;
        if(sorted.length<=1)
            return true;
        temp=sorted[0];

        for(int i=0;i<sorted.length;temp=sorted[i++]){
            if(sorted[i]<temp){
                return false;
            }
        }
        return true;
    }

}
