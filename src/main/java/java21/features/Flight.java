package java21.features;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Flight {

    private String from ;
    private String to;
    private LocalDate date;

    private static LocalDate flightDate(){
        return LocalDate.of(2024, 4, 4);
    }

}
