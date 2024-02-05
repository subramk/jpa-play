package mistry.MockitoBDD;

import mistry.MockitoBDD.src.EmailService;
import mistry.MockitoBDD.src.TrainBarriers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrainBarriersTest {

    @Mock
    EmailService emailServiceMock;
    final int PASSENGER_ID = 3;

    @Test
    public void passengerEntry(){

        //given - setup for test
        TrainBarriers trainBarriers = new TrainBarriers(emailServiceMock);
        TrainBarriers trainBarriersSpy = spy(trainBarriers);
        when(trainBarriersSpy.passengerIsEligible(PASSENGER_ID)).thenReturn(true);

        //when - method invocation
        trainBarriersSpy.passengerEntry(PASSENGER_ID);

        //then - what we expect
        verify(emailServiceMock).notifyPassenger(PASSENGER_ID);
        Assertions.assertTrue(trainBarriersSpy.getPassengersOnBoard().contains(PASSENGER_ID));
    }

    @Test
    public void passengerEntryBDD(){

        //given - setup for test
        TrainBarriers trainBarriers = new TrainBarriers(emailServiceMock);
        TrainBarriers trainBarriersSpy = spy(trainBarriers);
        given(trainBarriersSpy.passengerIsEligible(PASSENGER_ID))
                .willReturn(true);

        //when - method invocation
        trainBarriersSpy.passengerEntry(PASSENGER_ID);

        //then - what we expect
        then(emailServiceMock)
                .should()
                .notifyPassenger(PASSENGER_ID);

        Assertions.assertTrue(trainBarriersSpy.getPassengersOnBoard().contains(PASSENGER_ID));
    }
}
