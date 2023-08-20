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
            if (arr[i] > max){
                max = arr[i];
            }
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