package java21.features;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LeastRepetitiveCharInString {

    public static void main(String[] args) {

        String input = "ilovejulie";   //  should return o as it is only occuring once.
        String input2 = "aaabbbcccddeeaafg"; // should return f as it is the FIRST ONLY ONCE OCCURING CHAR .
        String input3 = "aaabbbcccddeeaaffgg"; // should return f as it is the FIRST ONLY ONCE OCCURING CHAR .

        final Predicate<Map.Entry<String,Long>> occursTwiceOnly = element -> element.getValue() == 2;

        final Predicate<Map.Entry<String,Long>> occursOnlyOnce = element -> element.getValue() == 1;



        System.out.println( " least occuring char is " + getLeastRepetitiveString(input3) ) ; // NONE FOUND
        System.out.println( " least occuring char is " + getLeastRepetitiveString(input2) ) ; // should return f
        System.out.println( " least occuring char is " + getLeastRepetitiveString(input) ) ; // should return o
    }
        public static String  getLeastRepetitiveString(String inputString){

            Optional<Map.Entry<String,Long>> leastRepeatedCharacter =
                     stream(inputString.split(""))
                    .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
                    .entrySet()
                    .stream()
                    .filter(x -> x.getValue() == 1) // Character Occuring ONLY ONCE.
                    .findFirst();

            return leastRepeatedCharacter.isPresent() ?  leastRepeatedCharacter.get().getKey() : "None Found ";

        }

        // 2nd Attempt using a Parameterized Predicate
        public static String  getLeastRepetitiveStringUsingPredicate(String inputString,
                                                                     Predicate<Map.Entry<String,Long>> occursOnceOnlyPredicate){

                Optional<Map.Entry<String,Long>> leastRepeatedCharacter =
                    stream(inputString.split(""))
                            .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
                            .entrySet()
                            .stream()
                            .filter( element -> occursOnceOnlyPredicate.test(element)) // uses predicate here.
                            .findFirst();

            return leastRepeatedCharacter.isPresent() ?  leastRepeatedCharacter.get().getKey() : "None Found ";

        }


    }

