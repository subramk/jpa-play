package java21.features;

import java21.features.domain.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class CollectorsGroupingByInsteadOfTeeing {

    public static void main(String[] args) {
        CollectorsGroupingByInsteadOfTeeing instance = new CollectorsGroupingByInsteadOfTeeing();
        //instance.usingSeparateGroupingByAndThenCreateMap();
        //instance.usingToMapWithThreeParamsInsteadOfGroupingBy();

        instance.usingTeeing();
    }

    public void usingTeeing(){

        Stream<LinkedHashMap<Integer, List<Employee>>> linkedHashMapStream = getEmployees()
                .stream()
                .sorted(comparing((Employee::getAge))) // asc order
                .collect(teeing(
                        groupingBy(Employee::getAge, LinkedHashMap::new, toList()),
                        groupingBy(Employee::getSalary, LinkedHashMap::new, toList()),
                        (youngest, oldest) -> {
                            return Map.of("youngest", youngest, "highestSalary", oldest);
                        }
                ))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue);

         List<Employee> employeeList = linkedHashMapStream.findFirst()
                .stream()
                .map(x -> x.values())
                .flatMap(x -> x.stream())
                .flatMap(x -> x.stream())
                .collect(toList());


//        List<Map.Entry<String, Map<Integer, List<Employee>>>> collect = usingTeeingCollector
//                .entrySet()
//                .stream()
//                .flatMap( e -> e.getValue())
//                .collect(toList());


        // .map( emp -> emp.getValue()).findFirst().get();


       System.out.println( " youngest list of employees is "  + employeeList);

    }



    public  void usingIndividualGroupingBy() {

        List<Employee> youngestEmployee =
                getEmployees()
                        .stream()
                        .sorted(comparing(Employee::getAge)) // asc order
                        .collect(groupingBy(
                                e -> e.getAge(),
                                LinkedHashMap::new,
                                mapping(e -> e, toList()))).values().stream().findFirst().get();

        List<Employee>  employeesWithHighestSalaries = getEmployees()
                .stream()
                .sorted(comparing(Employee::getSalary).reversed())
                .collect(groupingBy(
                        e -> e.getSalary(),
                        LinkedHashMap::new,
                        mapping(e -> e, toList())))
                        .values()
                        .stream()
                        .findFirst()
                        .get();


        final Map combinedMap  = Map.of("youngest",youngestEmployee,
                                       "highestSal", employeesWithHighestSalaries);

        System.out.println(" Combined Map is " + combinedMap );

    }





    public void usingToMapWithThreeParamsInsteadOfGroupingBy(){

        List<Employee> youngestEmployee = getEmployees()
                .stream()
                .sorted(comparing(Employee::getAge))
                .collect(toMap(
                        emp -> emp.getAge(),
                        emp -> new LinkedList<>(Arrays.asList(emp)),
                        (list1, list2) -> { // merge the list when there are duplicate Key in the Map.
                            list1.addAll(list2); //
                            return list1;
                        }))
                        .values()
                        .stream()
                        .findFirst()
                        .get();

        System.out.println(" Using toMap() to get to the Youngest Employee is  " + youngestEmployee );


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
