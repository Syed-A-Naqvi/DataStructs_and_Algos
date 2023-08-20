package MinimumValueInArray;

import java.util.Arrays;

/**
 * Driver
 */
public class Driver {

    // simply traverses the array and returns the minimum value encountered
    public static int findMinimum(int[] arr) {

        //edge cases
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid Input");
        }

        int min = arr[0];

        for (int i : arr) {
            if(i<min){
                min = i;
            }
        }

        return min;
        
    }

    //we can also first sort the array and then return the last element which will be the minimum,
    //this could reduce time complexity depending on the sorting algorithm used
    // public static int findMinimum(int[] arr) {

    //     //edge cases
    //     if (arr == null || arr.length == 0){
    //         throw new IllegalArgumentException("Invalid Input");
    //     }

    //     Arrays.sort(arr);
    //     System.out.println(Arrays.toString(arr));

    //     return arr[arr.length-1];
        
    // }
    
    public static void main(String[] args) {
        
        int[] array = new int[]{3,5,4,7,1,9};

        System.out.println(findMinimum(array));

    }

}