// Given an array of integers, return the second maximum value.

package SecondMaxValue;

/**
 * Driver
 */
public class Driver {

    public static int secondMaxValue(int[] arr) {

        if (arr == null || arr.length == 1){
            throw new IllegalArgumentException("No second maximum value exists");
        }

        int max = arr[0], secondMax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            //sets the maximum value encountered thus far
            if (arr[i] > max){
                max = arr[i];
            }
            //if a value greater than the current secondmax is encountered that is also less than the current max OR if the value of secondmax = max, secondmax updated
            else if ((arr[i] > secondMax && arr[i] < max) || (secondMax == max)){
                secondMax = arr[i];
            }
        }

        return secondMax;

    }

    public static void main(String[] args) {

        int[] array = new int[]{55,55,55,55,55,1};

        System.out.println(secondMaxValue(array));

    }

}