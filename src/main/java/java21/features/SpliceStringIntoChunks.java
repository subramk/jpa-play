package java21.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SpliceStringIntoChunks {

    private static final int splitLength = 3;
    private static final String vowelslist = "aeiou";

    private Predicate<Character> charPredicate = c -> vowelslist.contains(String.valueOf((char)c));

    private static long vowelCount(String input) {
        return
                input.chars()
                        .filter(c -> vowelslist.contains(String.valueOf((char) c)))
                        .count();
    }

    private static List<String> splitIntoChunks(String input) {
        List<String> splitStrings = new ArrayList<String>();
        IntStream.range(0, input.length() - 2)
                .forEach(i -> {
                    splitStrings.add(input.substring(i, splitLength + i));
                });
        return splitStrings;
    }

    public static void main(String[] args) {
        String input = "SolvendarSatishAndPettedson";
        splitIntoChunks(input).forEach(s -> {
            System.out.println(s + " contains " + vowelCount(s) + " vowels");
        });
    }
}
