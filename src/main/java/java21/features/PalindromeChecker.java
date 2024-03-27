package java21.features;

public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println(" inside main");

        String inputString = "malayalam";
        String input = "English";

        System.out.println( " Paindrome check for  inputString  "  + inputString + " is  " +   isStringPalindrome(inputString) ) ;
    }

    public static boolean isStringPalindrome(final  String inputString){
        return inputString.equals(new StringBuilder(inputString).reverse().toString()) ? true : false ;
    }

    // without using StringBuilder.reverse() ;


}
