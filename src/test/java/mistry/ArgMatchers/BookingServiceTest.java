package mistry.ArgMatchers;

import mistry.ArgMatchers.src.main.BookingRepository;
import mistry.ArgMatchers.src.main.BookingService;
import mistry.ArgMatchers.src.main.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Spy
    BookingRepository bookingRepository;

    @InjectMocks
    BookingService bookingService;

    @Test
    public void testBuyTicket(){

        BookingService bookingServiceSpy = Mockito.spy(bookingService);
        bookingServiceSpy.buyTicket("ABC123");

        Mockito.verify(bookingServiceSpy).bookSeat(any(Ticket.class));
    }


    @Test
    public void testBookSeat(){

        String ticketShowId = "TICKET:ID_1";
        Ticket ticket = new Ticket(ticketShowId);

        List<String> availableTickets = new ArrayList<String>();
        availableTickets.add(ticketShowId);

        when(bookingRepository.getSeats(anyString())).thenReturn(availableTickets);

        assertTrue(bookingService.bookSeat(ticket));
    }
}
