package java21.features.domain;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Employee {
    private String name;
    private int salary;
    private int age;
    private String city;
    private String department;
}
