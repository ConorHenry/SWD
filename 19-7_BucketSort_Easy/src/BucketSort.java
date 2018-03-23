import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * BucketSort class contains methods for implementing the bucket sort algorithm using a 2D array:
 *
 * @author conorhenry
 */
public class BucketSort {

    /**
     * Int array containing the array to be sorted (and returned once sorted)
     */
    private int[] resultArr;

    /**
     * 2d array to serve as the buckets as specified by the book
     */
    private Integer[][] buckets;

    /**
     * Counter to keep track of how many 'passes' the algorithm as
     */
    private int round;

    /**
     * the number of digits in the largest number to be sorted
     */
    private final int maxOrder;

    /**
     * Constructor takes as input an unsorted array of ints, calculates maxOrder, and initializes private variables
     * @param toSort - unsorted int array to be sorted by sort method
     */
    public BucketSort(int[] toSort) {
        resultArr = toSort;
        round = 0;
        buckets = new Integer[10][toSort.length];
        int max = 0;
        for (Integer number : toSort) {
            if (number.toString().length() > max)
                max = number.toString().length();
        }
        maxOrder=max;
    }

    /**
     * sort() method implements the BucketSort algorithm specified in the book:
     * "a) Place each value of the one-dimensional array into a row of the bucket array, based on the value’s “ones”
     * (rightmost) digit. For example, 97 is placed in row 7, 3 is placed in row 3 and 100 is placed in row 0. This
     * procedure is called a distribution pass.
     * b) Loop through the bucket array row by row, and copy the values back to the original array. This procedure is
     * called a gathering pass. The new order of the preceding values in the one-dimensional array is 100, 3 and 97.
     * c) Repeat this process for each subsequent digit position (tens, hundreds, thousands, etc.). On the second
     * (tens digit) pass, 100 is placed in row 0, 3 is placed in row 0 (because 3 has no tens digit) and 97 is placed
     * in row 9. After the gathering pass, the order of the values in the one-dimensional array is 100, 3 and 97. On the
     * third (hundreds digit) pass, 100 is placed in row 1, 3 is placed in row 0 and 97 is placed in row 0 (after the 3).
     * After this last gathering pass, the original array is in sorted order.
     * @return clone result array- the sorted array"
     */
    public int[] sort() {
        for (round = 0; round < maxOrder; round++) {
            distribute();
            gather();
            System.out.print(this); //optional
            buckets=new Integer[10][resultArr.length];
        }
        return resultArr.clone();
    }

    /**
     * Handles the distribution pass of the algorithm as specified by the book:
     * "Place each value of the one-dimensional array into a row of the bucket array, based on the value’s “ones”
     * (rightmost) digit. For example, 97 is placed in row 7, 3 is placed in row 3 and 100 is placed in row 0.
     * This procedure is called a distribution pass."
     */
    public void distribute() {
        for (Integer number : resultArr) {
            append(buckets[getDigit(number,round+1)],number);
        }
    }

    /**
     * Handles the gathering pass of the algorithm specified in the book:
     * "Loop through the bucket array row by row, and copy the values back to the original array. This procedure is
     * called a gathering pass. The new order of the preceding values in the one-dimensional array is 100, 3 and 97."
     */
    public void gather() {
        int index=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<resultArr.length&&buckets[i][j]!=null;j++) {
                resultArr[index++] = buckets[i][j];
            }
        }
    }//

    /**
     * Overridden toString method to display resultArr and buckets to show the progress of the sorting algorithm
     * or for debugging purposes
     * @return String containing resultArr and buckets
     */
    @Override
    public String toString() {
        return Arrays.toString(resultArr) + print2D(buckets);
    }

    /**
     * getDigit() method finds the n'th least significant digit of an integer
     * @param number Integer to get the nth digit of
     * @param digit refers to a particular digit in the number. i.e. n=1: the one's place, n=2: the ten's place
     * @return the integer form of the n'th least significant digit of number
     */
    public static int getDigit(Integer number, int digit){
        if(digit>number.toString().length())
            return 0;
        return Character.getNumericValue(number.toString().charAt(number.toString().length()-digit));
    }

    /**
     * Method to assign Integer objects in the first null element of an Integer array
     * @param arr An Integer array to be appended
     * @param n the int value to be appended
     */
    public static void append(Integer[] arr, int n){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==null){
                arr[i]=n;
                return;
            }
        }
    }

    /**
     * Method to create a formatted String representation of a 2d array,
     * @param arr An 2d array of Objects to be printed
     * @return a formatted String representation of arr
     */
    public static String print2D(Object[][] arr){
        StringBuilder result= new StringBuilder("\n");
        for (Object[] x : arr) {
            for (Object y : x) {
                result.append(y).append(" ");
            }
            result.append("\n");
        }
        result.append("\n\n");
        return result.toString();
    }
}
