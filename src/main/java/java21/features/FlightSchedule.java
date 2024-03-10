package java21.features;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class FlightSchedule {

    private LocalDateTime scheduledDeparture;
    private LocalDateTime scheduledArrival;


    Flight getFlights(){
        return new Flight.FlightBuilder().date(LocalDate.now()).from("London").to("Chennai").build();
    }
}
