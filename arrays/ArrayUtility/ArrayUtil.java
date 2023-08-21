package ArrayUtility;

 /**
 * ArrayUtil
 */
public class ArrayUtil {

    //--------------------------------------------------------------------------------------------------------------------------------------------------------
    
    //printing an array
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------

    // Using the summation formula of n natural numbers, will calculate the expected sum for n=arr.length+1, then will iterate through the array subtracting
    // each element from the previously calculated sum. Whatever is left will be the missing number
    public static int findMissingNumber(int[] arr) {
        
        int n = arr.length+1;
        int sum = ((n)*(n+1)) /2; 

        for (int num : arr) {
            sum = sum - num;
        }

        return sum;

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------

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

    //--------------------------------------------------------------------------------------------------------------------------------------------------------

    //This was my first attempt, it works but performs many unnecessary operations 
    // public static int[] moveZerosToEnd(int[] arr) {
        
    //     int moves = 0;

    //     for (int i = 0; i < arr.length; i++) {
                
    //         if(arr[i] != 0){
    //             int temp = arr[i];
    //             arr[i] = 0;
    //             arr[moves] = temp;
    //             moves++;
    //         }

    //     }

    //     return arr;
        
    // }

    //This method will use two pointers and will only make swaps in the case that the first pointer encounteres a zero and the second pointer encounters a non zero
    //in the case that there is not a nonzero ahead of a zero, no operation is carried out and the pointers are simply updated, reducing the number of operations
    //compared to the method above

    public static int[] moveZerosToEnd(int[] arr) {
        
        //will be used to focus on 0 elements
        int j = 0;

        //i will be used to focus on nonzero elements
        for (int i = 0; i < arr.length; i++) {

            if( (arr[i] != 0) && (arr[j] == 0) ){
                arr[j] = arr[i];
                arr[i] = 0;
            }
            if(arr[j] != 0){
                j++;
            }
            
        }

        return arr;

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------

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

    //--------------------------------------------------------------------------------------------------------------------------------------------------------

    // creates a new array of the desired size, copies all elements from the original array and then returns a reference to the new array
    public static int[] resizeArray(int[] arr, int newsize) {
        
        int[] newArray = new int[newsize];

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }

        return newArray;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------

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

    //--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static int secondMaxValue(int[] arr) {

        if (arr == null || arr.length == 1){
            throw new IllegalArgumentException("No second maximum value exists");
        }

        int max = arr[0], secondMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            //if a new maximum is found the old is set to the secondmax before max is updated
            if (arr[i] > max){
                secondMax = max;
                max = arr[i];
            }
            //if a value greater than the current secondmax is encountered that is also less than the current max OR if the value of secondmax = max, secondmax updated
            //The OR is in the case that the first or the first and subsequent are the max
            else if ((arr[i] > secondMax && arr[i] < max) || (secondMax == max)){
                secondMax = arr[i];
            }
        }

        return secondMax;

    }

    public void demo(){
        int[] myArray = new int[5];
        
        //setting the value of each element at the specified index
        myArray[0]=5;
        myArray[1]=5;
        myArray[2]=5;
        myArray[3]=5;
        myArray[4]=1;
        
        //changes the value of the element at index 0 from 5 to six
        myArray[0]=6;

        printArray(myArray);

        //prints the length of the array
        System.out.println(myArray.length);
        //prints the last element of the array
        System.out.println(myArray[myArray.length-1]);

        //throws an out of bounds exception as there is not index 5
        //myArray[5] = 10;

        //this is another way of creating an array where the elements are initialized at declaration
        int[] arr = {3,5,1,6};
        printArray(arr);

        //it is also possible to actually pass an array to the print method wihout creating and assigning it to a variable stored in memeory
        printArray(new int[] {3,2,4,6,4});

    }

    public static void main(String[] args) {
     
        ArrayUtil demo = new ArrayUtil();
        demo.demo();
        
    }

}