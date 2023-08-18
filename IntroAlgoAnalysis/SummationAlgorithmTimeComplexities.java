/**
 * SummationAlgorithmTimeComplexities
 */
public class SummationAlgorithmTimeComplexities {

    
    public static void main(String[] args) {
        
        double now = System.currentTimeMillis();
        SummationAlgorithmTimeComplexities demo = new SummationAlgorithmTimeComplexities();
        System.out.println(demo.findSum(999999));
        System.out.println("Time taken = " + (System.currentTimeMillis() - now) + " milliseconds." );

    }

    // using the summation formula for the sum of the first n natural numbers, executes in constant time O(1)
    public long findSum(long n){
        return n * (n + 1) / 2;
    }

    // using a for loop to add each of the first n natural numbers, executes in linear time O(n)
    // public long findSum(long n){
    //     int total = 0;
    //     for (int i = 1; i < n+1; i++) {
    //         total += i;
    //     }
    //     return total;
    // }


}