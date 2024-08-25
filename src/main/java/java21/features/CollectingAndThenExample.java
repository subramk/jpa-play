package java21.features;

import java21.features.domain.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
        CollectionAndThen
        Collectors.dropWhile
        Collectors.takeWhile
        Collectors.teeing

        // .teeing() helps us to Stream the same collection TWICE in one straight pass ,instead of
        // doing it in two separate steps
 */




import static java.util.stream.Collectors.*;

public class CollectingAndThenExample {
    public static void main(String[] args) {
        CollectingAndThenExample andThen = new CollectingAndThenExample();
        andThen.example1();
    }

    public void example1(){

        // using static imports.
        getEmployees().stream()
                .mapToDouble(Employee::getSalary)
                .boxed() // .boxed() gives you back a Stream<Double> .
                .collect(collectingAndThen(
                        averagingDouble(Double::doubleValue), // colle downstream collector
                        Math::round
                ));

       final  Predicate<Employee> salaryIsLessThan25K = ele -> ele.getSalary() < 25000;
       final  Predicate<Employee> salaryIsGreaterThan30K = ele -> ele.getSalary() > 30000;

       // dropWhile
        List<Employee> collect = getEmployees()
                        .stream()
                        .dropWhile(salaryIsLessThan25K)
                        .collect(Collectors.toList());
        // takeWhile
        List<Employee> takeWhileList = getEmployees()
                .stream()
                .takeWhile(salaryIsGreaterThan30K)
                .collect(Collectors.toList());
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
