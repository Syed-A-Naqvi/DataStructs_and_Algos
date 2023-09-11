package Strings;

/**
 * Palindrome
 */
public class Palindrome {

    // public static boolean isPalindrome(String word) {

    //     char[] charArray = word.toCharArray();

    //     int last = charArray.length-1;

    //     for (int i = 0; i < charArray.length/2; i++) {
            
    //         if( charArray[i] != charArray[last-i]){
    //             return false;
    //         }

    //     }

    //     return true;

    // }

    // I like this implementation better, it will work for any palindrome regardless of the symbols used. It will also recognize case-insensitive equivalent letters
    public static boolean isPalindrome(String word) {
        
        char[] charArray = word.toCharArray();

        int start = 0;
        int end = charArray.length-1;

        while(start<end){

            if (charArray[start] != charArray[end] &&
                Character.isLetter(charArray[start]) &&
                Character.isLetter(charArray[end]) &&
                Math.abs((int)charArray[start] - (int)charArray[end]) == 32){
            }
            else if (charArray[start] != charArray[end]){
                return false;
            }

            start ++;
            end --;

        }

        return true;

    }


    public static void main(String[] args) {
        
        System.out.println(isPalindrome("%^$131$^%Stanley Yelnats%^$131$^%"));
        System.out.println(isPalindrome("that"));

    }

}