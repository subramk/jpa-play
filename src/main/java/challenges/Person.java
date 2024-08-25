package challenges;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private String firstName ;
    private String lastName;
    private String fullName;

     String getFullName(){
        return this.firstName + " " + this.getLastName();
    }

}
