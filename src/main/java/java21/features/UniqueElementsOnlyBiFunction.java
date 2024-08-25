package java21.features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

public class UniqueElementsOnlyBiFunction implements BiFunction<List<Integer>,List<Integer>, List<Integer>> {

    private static List<Integer> l1 = List.of(1, 3, 4, 6, 7, 9, 11, 19);
    private static List<Integer> l2 = List.of(11, 3, 43, 6, 19, 22);


    @Override
    public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
        return
                Stream.of(list1, list2)
                        .flatMap(element -> element.stream())
                        .distinct()
                        .sorted(naturalOrder())
                        .collect(toList());
    }


    public static void main(String[] args) {

        //1 . using the apply() method that comes built in
        BiFunction<List<Integer>, List<Integer>, List<Integer>> op1 = new UniqueElementsOnlyBiFunction();
        List<Integer> uniqueElements = op1.apply(l1, l2);
        System.out.println("        Using the apply method || " + uniqueElements) ;

        //2.  Anonymous Inner Method implementation
        BiFunction<List<Integer>, List<Integer>, List<Integer>> op2 = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(final List<Integer> l1, final List<Integer> l2) {
                return Stream.of(l1, l2)
                        .flatMap(List::stream)
                        .distinct()
                        .sorted(naturalOrder())
                        .collect(toList());
            }};

        System.out.println("       Using the Anonymous Method || " + op2.apply(l1,l2)) ;



        //3. Using just the Lambda
     BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunctionLambda =    (l1 , l2 ) ->
                 Stream.of(l1,l2)
                .flatMap(List::stream)
                .distinct()
                .sorted(naturalOrder())
                .collect(toList());

        System.out.println("      Using the Lambda Method ||   " + biFunctionLambda.apply(l1,l2)) ;

        // Sorting
        Function<List<Integer>, List<Integer>> sortedFunction =  (list) ->
                list.stream()
                        .sorted()
                        .collect(toList());

        biFunctionLambda
                .andThen(sortedFunction)
                .apply(l1,l2);

        // 4. INLINE LAMBDA












        Map<String,Integer> salaryMap  = new HashMap<>();
        salaryMap.put("bhamini", 1200);
        salaryMap.put("reddy", 2400);
        salaryMap.put("sai", 2000);

        BiFunction<String, Integer, Integer> increaseSalaryBiFunction = (key, value) -> value + 500;




        System.out.println(" SalaryMap values is ||| ");
        System.out.println( salaryMap);


    }
}

