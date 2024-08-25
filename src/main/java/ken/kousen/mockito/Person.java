package ken.kousen.mockito;


import lombok.*;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private Long id;
    private String last;
    private String first;
    private String full;
    private LocalDate dob;

    Person(Long  id , String last , String first, LocalDate dob){
        this.id = id;
        this.first = first;
        this.last = last;
        this.dob = dob;
        this.full = first +  last ;

    }

}
