package java21.features;

import java21.features.domain.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;
import static java.util.Map.*;
import static java.util.stream.Collectors.*;

public class CollectorsTeeingExample2 {

    public static void main(String[] args) {

        CollectorsTeeingExample2 teeingExample2 = new CollectorsTeeingExample2();
        Map<String, List<Employee>> resultMap =  teeingExample2.doWork();

        System.out.println(" youngest employee" + resultMap.get("youngestEmployee"));
        System.out.println(" hihestes salary  employee" + resultMap.get("employeeWithHighestSalary"));


    }

    public Map<String, List<Employee>> doWork(){

        List<Employee> employees = getEmployees();


                // Find youngest employee
          var resultMap = employees.stream()
                        .collect(Collectors.teeing(
                                minBy(Comparator.comparingInt(Employee::getAge)),
                                maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                (youngest, highestSalary) -> {
                                    Map<String, List<Employee>> map = new HashMap<>();
                                    map.put("youngestEmployee", youngest.map(Collections::singletonList).orElse(Collections.emptyList()));
                                    map.put("employeeWithHighestSalary", highestSalary.map(Collections::singletonList).orElse(Collections.emptyList()));
                                    return map;
                                }
                        ))
                        .entrySet()
                        .stream()
                        .collect(toMap(Map.Entry::getKey,
                                       value -> value.getValue().stream().collect(Collectors.toList())
                        ));

        System.out.println(resultMap);


        // simple one

        var resultMap3 = employees.stream()
                        .sorted(Comparator.comparing(Employee::getAge))
                        .collect(Collectors.toList());


//        var resultMap4 =             employees.stream()
//                                    .collect(
//                                            teeing(
//                                                groupingBy(Employee::getAge,  minBy(toList(Comparator.comparing(Employee::getAge)))),
//                                    null,null));
//
////                            (youngest, highestSalary) -> {
//                            Map<String, List<Employee>> map = new HashMap<>()
//                                map.put("youngestEmployee", youngest));
//                            map.put("employeeWithHighestSalary", highestSalary.map(Collections::singletonList).orElse(Collections.emptyList()));
//                            return map;


//                                        (youngest, highestSalary) -> {
//                            Map<String, List<Employee>> map = new HashMap<>();
//                            map.put("youngestEmployee", sort(youngest,minBy(Employee::getAge)));
//                            map.put("employeeWithHighestSalary", highestSalary.map(Collections::singletonList).orElse(Collections.emptyList()));
//                            return map;
//                        }
//                ))
//                .entrySet()
//                .stream()
//                .collect(toMap(Map.Entry::getKey,
//                        value -> value.getValue().stream().collect(Collectors.toList())
//                ));




        return resultMap;
    }



    private List<Employee> getEmployees(){

        Employee e1 = Employee.builder().age(22).name("kasi").city("chennai").salary(50000).build();
        Employee e11 = Employee.builder().age(22).name("jambu").city("chennai").salary(23333).build();
        Employee e111 = Employee.builder().age(22).name("vambu").city("chennai").salary(23432).build();
        Employee e1111 = Employee.builder().age(22).name("rambu").city("chennai").salary(23333).build();

        // highest salary
        Employee e2 = Employee.builder().age(23).name("Rasi").city("coimbatore").salary(60000).build();
        Employee e21 = Employee.builder().age(23).name("Roossi").city("coimbatore").salary(60000).build();

        Employee e4 = Employee.builder().age(25).name("Pussi").city("alwarpet").salary(54344).build();

        Employee e3 = Employee.builder().age(24).name("Passi").city("ponneri").salary(23434).build();
        Employee e5 = Employee.builder().age(26).name("Dhoosi").city("virgugambakkam").salary(23434).build();

        return     List.of(e1,e11, e111,e1111, e2,e21, e3, e4, e5);


    }


}
