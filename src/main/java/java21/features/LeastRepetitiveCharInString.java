package java21.features;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LeastRepetitiveCharInString {

    public static void main(String[] args) {

        String input = "ilovejulie";   //  should return o as it is only occuring once.
        String input2 = "aaabbbcccddeeaafg"; // should return f as it is the FIRST ONLY ONCE OCCURING CHAR .
        String input3 = "aaabbbcccddeeaaffgg"; // should return f as it is the FIRST ONLY ONCE OCCURING CHAR .

        System.out.println( " least occuring char is " + getLeastRepetitiveString(input3) ) ; // NONE FOUND
        System.out.println( " least occuring char is " + getLeastRepetitiveString(input2) ) ; // should return f
        System.out.println( " least occuring char is " + getLeastRepetitiveString(input) ) ; // should return o
    }
        static String  getLeastRepetitiveString(String inputString){

            Optional<Map.Entry<String,Long>> leastRepeatedCharacter =
                     stream(inputString.split(""))
                    .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
                    .entrySet()
                    .stream()
                    .filter(x -> x.getValue() == 1) // character occuring only once
                    .findFirst();

            return leastRepeatedCharacter.isPresent() ?  leastRepeatedCharacter.get().getKey() : "None Found ";

        }
    }
