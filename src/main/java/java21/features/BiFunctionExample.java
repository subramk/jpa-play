package java21.features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class BiFunctionExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

    public static void main(String[] args) {
    }

    private BiFunction biFunction = new BiFunctionExample();
    private BiFunction<List<Integer>,List<Integer>,List<Integer>>   biFunction1;
    private List<Integer> l1 = List.of(1,3,4,6,7, 9, 19);
    private List<Integer> l2 = List.of(11,3,43,6,7,19);

    // BiFunction  is a FI that takes 2 args T && U and returns a Value ie R
     final BiFunction<String,Integer,Integer> increaseSalaryBy1000_BiFunction = (key, value) -> {
        return value + 1000;    // increment by 1000
    };


     // call the apply() method.
    void usingTheApplyMethodCall() {
        System.out.println( " | Calling the biFunction example distinct Values are | " + biFunction.apply(l1,l2) );

    }

    void byImplementingApplyMethodCall(){
           biFunction1= new BiFunction<>() {
            @Override
            public List<Integer> apply(List<Integer> l1 ,  List<Integer> l2) {
                return Stream
                        .of(l1,l2)
                        .flatMap( x -> x.stream())
                        .distinct()
                        .collect(toList());
            }
        };

    }

    void chainingBiFunctionWithSort(){
        // CHAIN the BiFunction with the .andThen()
        // see the syntax here biFunction.andThen(XXXX).apply(XXX)
        // and NOT the other way .. ie biFunction.apply(XXX).andThen(XXXX)

        List<Integer> postSorting =  biFunction1.andThen(sortedFunction).apply(l1,l2);
    }

    void usingLambdaExpression_1() {
        BiFunction<List<Integer> , List<Integer>  , List<Integer>>  biFunctionLambdaExpression1  = (List<Integer> list3,List<Integer> list4) -> {
            return Stream
                    .of(list3,list4)
                    .flatMap(List::stream) // or .flatMap( element -> element.stream())
                    .distinct()
                    .collect(toList());
        };
    }

    void usingLambdaExpression_2() {
        BiFunction<List<Integer> , List<Integer>  , List<Integer>>  biFunctionLambdaExpression2  = (list3,list4) -> {
            return Stream
                    .of(list3,list4)
                    .flatMap(List::stream) // or .flatMap( element -> element.stream())
                    .distinct()
                    .collect(toList());
        };

        Map<String,Integer> empSalaryMap = new HashMap<>();
        empSalaryMap.put("basant", 15000);
        empSalaryMap.put("vasant", 10000);
        empSalaryMap.put("trissant", 12000);

        System.out.println( " | BEfore Salary Increase | " + empSalaryMap );

        BiFunction<String,Integer,Integer> increaseSalBiFunction2 = (key,value) -> {
            return value + 1000;    // increment by 1000
        };

        empSalaryMap.replaceAll(increaseSalBiFunction2);
        System.out.println(" | AFTER  Salary Increase | "+ empSalaryMap);
    }

    private Function<List<Integer> , List<Integer>>  sortedFunction =
            (lists) -> {
                return lists
                        .stream()
                        .sorted()
                        .collect(toList());
            };



    @Override
    public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
        return Stream.of(list1,list2)
                .flatMap( x -> x.stream())
                .distinct()
                .collect(toList());
    }
}
