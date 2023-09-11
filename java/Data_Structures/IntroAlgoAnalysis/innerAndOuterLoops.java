/**
 * innerAndOuterLoops
 */
public class innerAndOuterLoops {

    public static void main(String[] args) {
        innerAndOuterLoops test = new innerAndOuterLoops();
        test.print(3);
    }

    public void print(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("i = %d, j = %d\n", i, j);
            }
            System.out.println("End of inner loop");
        }
        System.out.println("End of outer loop");
    }

    // this is a very simple algorithm showcasing how regardless of the way that operations are counted, the number of nested for-loops used equals the degree of n
    // in the big o time complexity
    // in this ase because there are two nested for loops, the time complexity is O(n^2)

}