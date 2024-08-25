package java21.features;

import java21.features.domain.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class CollectorsTeeingExample {
    public static void main(String[] args) {
        CollectorsTeeingExample teeOff = new CollectorsTeeingExample();
        //teeOff.simpleExampleOfUsingTeeingCollector();
     //   System.out.println(teeOff.getYougestEmployeeAndEmployeeWithHighestSalary() );
        teeOff.getEmp2();
    }


    // Get the Youngest and Oldest Employee using Teeing.
    //
    // .teeing() helps us to Stream the same collection TWICE in ONE  straight pass ,instead of
    // doing it in two separate steps

    private Map<String, List<Employee>> getYougestEmployeeAndEmployeeWithHighestSalary() {
        /*
            I have a list of Employees , I want to get an output of a Map of two entries -

            1st entry in Map - key is String "youngestEmployee" -
            value is a List<Employee>   - as there can be more than one youngest employee with Same Age

            2nds entry in Map - key is a String "highestSalaryEmployee" -
            value is a List<Employee>   - as there can be more than one employee with Same Highest Salary

            I am trying to use a Teeing Collector which takes two downstream Collectors and then using the merge BiFunction
            to return the above Map

           For set up of the  Downstream Collectors ,  I am trying to use the GroupingBy Collector, which will give me a Map like this
            key : "youngest"
            value: List<Employee>

            key : "highestSalary"
            value: List<Employee>

            But I am doing something wrong as it is not compiling.

         */

        var employeeList = getEmployees();



//                employeeList
//                .stream()
//                .collect(
//                        Collectors.teeing(
//                                .groupingBy(identity(), LinkedHashMap::new, Collectors.minBy(Employee::getAge), // Youngest Employeee  // downstream one D1
//                                        .groupingBy(identity(), LinkedHashMap::new, Collectors.maxBy((Employee::getSalary)), // Youngest Employeee  // downstream one D1
//                                       //s null; // this willbe the merge BiFunction
//
//
////                        (youngest,oldest) -> {
//                            return Map.of("youngest", youngest.get(), "oldest", oldest.get());
//                        }));

        //return  yougestAndOldestEmployeeAsMap;
                        return null;

    }






    private void simpleExampleOfUsingTeeingCollector() {

        List<Employee> employeeList = getEmployees();


        // Without Teeing , we need to separtely get youngest employee
        // Youngest employee
        Employee youngestEmployee =
                employeeList
                        .stream()
                        .min(comparing(Employee::getAge)).get();

        // ...and the Employee with Highest Salary
        Employee employeeWithhighestSalary =
                employeeList
                        .stream()
                        .max(comparing(Employee::getSalary)).get();

        Map<String, Employee> oldestYoungestEmployee = new HashMap<>();
        oldestYoungestEmployee.put("highestSalary", employeeWithhighestSalary);
        oldestYoungestEmployee.put("youngest", youngestEmployee);


        // using Teeing Collector  it is just ONE step to pass through the Stream Api
        // the signature of the .teeing() method is 2 dowstream collectors and a Merger BiFunction
        // Merger Function it has access to both the above downstrem collectors
        // the return  of the BiFunction is hence the return type of the method .

        /*
                teeing(Collector<? super T, ?, R1> downstream1,
                Collector<? super T, ?, R2> downstream2,
                BiFunction<? super R1, ? super R2, R> merger) {
         */


        Map<String, Employee> youngestAndOldestMap2 =
                employeeList
                        .stream()
                        .collect(
                                Collectors.teeing(
                                        minBy(comparing(Employee::getAge)), // Youngest Employeee  // downstream one D1
                                        maxBy(comparing(Employee::getSalary)), // Empolyee with Highest Salary  // downstream two D2

//                                Old way of passing D1,D2 and use it to create the Merger BiFunction.
//                                (young, old)-> {
                                        // Merging BiFunction
                                        // in this case, we would do  Map comprising of the youngest and oldest
                                        //                Map<String,Employee> finisher = new HashMap<>();
//                                                    finisher.put("youngest", young.get());
//                                                    finisher.put("oldest", old.get());
                                        //}
//                                  // OR use Map.of to create a map on the Fly .
                                        (young, highestSalary) -> Map.of("youngest", young.get(), "highSalary", highestSalary.get())));

        System.out.println(" Example  1   ==>  Youngest Age   " + youngestAndOldestMap2.get("youngest"));
        System.out.println(" Example  1   ==>   Highest Salary  " + youngestAndOldestMap2.get("highSalary"));

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

    private void  getEmp2(){
        Comparator<Employee> compareByAgeAndSalary = Comparator.comparing((Employee employee) -> employee.getAge()).thenComparing(Employee::getSalary);

        List<Employee> result123 = getEmployees().stream().sorted(compareByAgeAndSalary).collect(Collectors.toList());

//        getEmployees().stream().collect(groupingBy(Function.identity(),
//                                        LinkedHashMap::new,
//                                        (e -> Map.Entry()
//
//                        );
//
//                sorted(compareByAgeAndSalary).collect(Collectors.toList());

        result123.forEach(e -> System.out.println(e.getName() + " " + e.getAge() + " " + e.getSalary()));
    }
}
