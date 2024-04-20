package java21.features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


/**
 * Take a large piece of a String and splice it into Chunks of say 3 chars .
 *
 * In Each of the Chunks , compute the occurence of Vowels ( a,e,i,o,u )  .
 *
 */
    public class SpliceStringIntoChunks {

        private static final int chunkSize = 3;
        private static final String vowelslist = "aeiouAEIOU";

        private static long vowelCount(String input) {
            return
                    input.chars()
                            .filter(c -> vowelslist.contains(String.valueOf((char) c)))
                            .count();
        }

        // use codePoint to destructure the inputString into a stream of characters.
        private static long vowelCount2(String input) {
            return
                    input.codePoints() // this produces a Stream of chars from the input.
                            .filter(c -> vowelslist.contains(String.valueOf((char) c)))
                            .count();
        }

        // Example
        // Karthik is the string (length is 7)
        //  Splice it into chunks - (1,2,3) / 2,3,4 / 3,4,5 / 4,5,6 / 5,6,7
        //  LAST Allowed Index in the String , is 5th char - ie to get 5,6,7 into a Chunk
        // So these will be the combinations.

        // 0  to 4  --> Kar
        // 1  to 5 -->  art
        // 2  to 6 -->  rth
        // 3  to 7 -->  thi
        // 4  to 8 -->  hik

        private static List<String> splitIntoChunks(String input) {
            List<String> splitStrings = new ArrayList<String>();
            IntStream.range(0, input.length() - 2)
                    .forEach(i -> {
                        splitStrings.add(input.substring(i, chunkSize + i));
                    });
            return splitStrings;
        }

        public static void main(String[] args) {
            String input = "SolvendarSatishAndDoctorPettedson";
            splitIntoChunks(input).forEach(s -> {
                System.out.println(s + " contains " + vowelCount2(s) + " vowels");
            });

        }
    }
