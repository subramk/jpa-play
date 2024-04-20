package java21.features;

public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println(" inside main");

        String sentence = "My name is Nitin and I can speak Malayalam";

        String[] words = sentence.split(" ");

        for(String word : words){
            if(isPalindromeWithoutStringReverse(word.toLowerCase())){
                System.out.println(" the word " + word  + " is a palindrome ");
            }
        }


        //        String inputString = "malayalam";
//        String input = "English";
//        System.out.println( " Paindrome check for  inputString  "  + inputString + " is  " +   isStringPalindrome(inputString) ) ;


    }

    public static boolean isStringPalindrome(final  String inputString){
        return inputString.equals(new StringBuilder(inputString).reverse().toString()) ? true : false ;
    }

    // without using StringBuilder.reverse() ;
    public static boolean isPalindromeWithoutStringReverse(final  String inputString) {
        // nitin
        int startIndex = 0;
        int endIndex = inputString.length() - 1;

        while (endIndex > startIndex) {
            if (inputString.charAt(startIndex) != inputString.charAt(endIndex)) {
                return false;
            }
            startIndex = startIndex + 1; // i1++
            endIndex = endIndex - 1;  // i2--
        }
        return true;
    }
}
