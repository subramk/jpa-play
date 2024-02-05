package mistry.MockitoWhen;

import mistry.MockitoWhen.src.main.java.BookingManager;
import mistry.MockitoWhen.src.main.java.HotelDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookingManagerTest {

    private BookingManager bookingManager;

    @Mock
    private HotelDao hotelDaoMock;


    @BeforeEach
    public void setup() throws SQLException {

        bookingManager = new BookingManager(hotelDaoMock);

        List<String> availableRooms = Arrays.asList("A,B");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);
        when(bookingManager.checkRoomAvailability("B")).thenReturn(true);

    }

//    @Test
//    public void checkAvailableRoomsTrue() throws SQLException {
//        hotelDaoMock = mock(HotelDao.class);
//        bookingManager = new BookingManager(hotelDaoMock);
//
//        Assertions.assertFalse(bookingManager.checkRoomAvailability("B"));
//
//    }
//
//
//    @Test
//    public void checkAvailableRoomsReturnsFalse() throws  SQLException{
//        hotelDaoMock = mock(HotelDao.class);
//        bookingManager = new BookingManager(hotelDaoMock);
//        Assertions.assertFalse(bookingManager.checkRoomAvailability("D"));
//    }
//
//
//    @Test
//    public void checkAvailableRoomsFalse() throws SQLException {
//        hotelDaoMock = mock(HotelDao.class);
//        bookingManager = new BookingManager(hotelDaoMock);
//
//        when(hotelDaoMock.fetchAvailableRooms()).thenThrow(SQLException.class);
//
//        Assertions.assertThrows(RuntimeException.class, () -> {
//            // Code that throws Exception
//            // bookingManager.checkRoomAvailability("");
//            bookingManager.checkRoomAvailability(Mockito.anyString());
//        });
//    }
}