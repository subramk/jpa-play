package java21.features;

import java.util.*;
import java.util.stream.Collectors;

public class NthHighestSalary {

    public static void main(String[] args) {

       new NthHighestSalary().getTheNthHighestSalary_V1(3);

        // new NthHighestSalary().getTheNthHighestSalary_V2();


    }

    private  void getTheNthHighestSalary_V1(int nthSalary) {

        // Note: All values in the map are unique . no duplicate values for Salary
        Map<String,Integer> salMap = new HashMap<>();
        salMap.put("anil", 1000);
        salMap.put("ankit", 1100);
        salMap.put("bhavana", 2100);
        salMap.put("charlie", 1400);
        salMap.put("dinesh", 1800);
        salMap.put("Ezhil", 1500);


        // v1 Solution .
        Map.Entry<String, Integer> nthHighestSalaryIs  = salMap.entrySet()
                .stream()
                //.sorted()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // highest to lowest
                .collect(Collectors.toList())
                .get(nthSalary - 1);

        System.out.println( " the " + nthSalary + "rd/th highest sarlary is  " +  nthHighestSalaryIs.getValue() );

    }

    private  void getTheNthHighestSalary_V2() {

        // Note: Salary values CAN BE DUPLICATE
        Map<String,Integer> salMap = new HashMap<>();
        salMap.put("anil", 1000);
        salMap.put("ankit", 1100);
        salMap.put("bhavana", 2100);
        salMap.put("charlie", 1400);
        salMap.put("dinesh", 1800);
        salMap.put("Ezhil", 1500);
        salMap.put("Ferdi", 1400);
        salMap.put("Ganesan", 1500);
        salMap.put("Harish", 1400);
        salMap.put("Immanuel", 2100);
        salMap.put("Jack", 1100);
        salMap.put("Kasi", 1500);



    }


}
