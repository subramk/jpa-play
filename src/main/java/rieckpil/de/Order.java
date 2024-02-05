package rieckpil.de;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor

public class Order {
    private String id;
    private LocalDate creationDate;
    private Long amount;
    private String productName;



}
