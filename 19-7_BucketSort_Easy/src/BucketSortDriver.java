/**
 * Driver Class for BucketSort, creates a BucketSort object, providing an unsorted array, calls the sort method, and
 * prints the sorted result
 * @author conorhenry
 */
public class BucketSortDriver {
    public static void main(String[] args){
        BucketSort sort=new BucketSort(new int[]{100,3,97,23,51,3,2,64});
        int[] result=sort.sort();
        for(int n:result){
            System.out.print(n+",");
        }
    }
}
