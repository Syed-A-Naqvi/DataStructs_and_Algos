package ReverseArray;


/**
 * Driver
 */
public class Driver {

    //printing an array
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
    
    //reversing an array, this method requires the creation of an entirely new array of the same size as the original
    // public static int[] reverseArray(int[] arr) {
        
    //     int[] reversedArray = new int[arr.length];
        
    //     for (int i = arr.length-1; i >= 0; i--) {
    //         reversedArray[(arr.length-1)-i] = arr[i];
    //     }

    //     return reversedArray;
    // }

    //reversing an array, this is an in place reversal that does not require the creation of a new array
    public static int[] reverseArray(int[] arr) {

        int start = 0;
        int end = arr.length-1;

        while (start<end){
            
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;

        }

        return arr;
    
    }
    
    public static void main(String[] args) {
        
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};

        printArray(array);
        printArray(reverseArray(array));

    }

}