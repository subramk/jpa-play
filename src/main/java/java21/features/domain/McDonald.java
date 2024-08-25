package java21.features.domain;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class McDonald {
    private double latitude, longitude ;
    private String name ;
    private String address;
    private String city;
    private String state ;
}
