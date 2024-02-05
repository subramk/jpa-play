package mistry.ArgMatchers.src.main;

import java.util.List;

public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public boolean buyTicket(String showId){
        System.out.println(" insdie of the buyTicket method ....");
        String ticketShowId = createTicketShowId(showId);
        Ticket ticket = new Ticket(ticketShowId);
        return bookSeat(ticket);
    }

    public boolean bookSeat(Ticket ticket) {
        System.out.println(" Within  the bookSeat method ....");

        List<String> availableSeatsForShow =
                bookingRepository.getSeats(ticket.getShowFromId());
        if(availableSeatsForShow.contains(ticket.getShowId())){
            //update database
            return true;
        }
        else{
            return false;
        }
    }

    private String createTicketShowId(String showId) {
        return "TICKET:" + showId;
    }
}
