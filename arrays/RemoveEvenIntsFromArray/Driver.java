package RemoveEvenIntsFromArray;

/**
 * Driver
 */
public class Driver {

    //removing even integers
    public static int[] removeEvenIntegers(int[] arr) {

        int count = 0;

        for (int i : arr) {
            if(i%2 != 0){
                count++;
            }
        }

        int[] oddIntegers = new int[count];

        int n = 0;
        for (int i : arr) {
            if(i%2 != 0){
                oddIntegers[n] = i;
                n++;
            }
        }

        return oddIntegers;
        
    }

    //printing an array
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        int[] myArray = new int[]{3,2,4,7,10,6,5};

        printArray(myArray);

        printArray(removeEvenIntegers(myArray));

    }
}