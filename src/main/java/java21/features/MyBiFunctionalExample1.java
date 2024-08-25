package java21.features;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyBiFunctionalExample1 {

    public static void main(String[] args) {
        MyBiFunctionalExample1 a1 = new MyBiFunctionalExample1();

        a1.perform1();
    }

    private void perform1() {


        List<Integer> list1 = List.of(1,3,4,6,7,9,11,13);
        List<Integer> list2 = List.of(3,4,8,12,14,15,19,20);
        List<Integer> list3 = List.of(5,12,19,29,39,41,43);

        List<Integer> values  =  Stream.of(list1,list2,list3)
                                .flatMap(element -> element.stream())
                                .collect(Collectors.toList());




    }


}
