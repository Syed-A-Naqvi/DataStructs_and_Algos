package ArrayUtility;

 /**
 * ArrayUtil
 */
public class ArrayUtil {

    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
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