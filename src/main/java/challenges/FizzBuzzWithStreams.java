package challenges;

import java.util.stream.IntStream;

// From https://medium.com/codex/fizzbuzz-in-java-8-aa70b3038736

public class FizzBuzzWithStreams {

    public static void main(String args[]) {
        doStreamFizzBuzz(31);
    }

    public static void doStreamFizzBuzz(int n) {
        IntStream.rangeClosed(1, n)
                .mapToObj(FizzBuzzWithStreams::mapIntToFizzBuzz)
                .forEach(System.out::println);
    }

    public static String mapIntToFizzBuzz(int i) {
        if(i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        }

        if(i % 3 == 0) {
            return "Fizz";
        }

        if(i % 5 == 0) {
            return "Buzz";
        }

        return Integer.toString(i);
    }

}



