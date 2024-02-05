package mistry.InjectMocks;

import mistry.InjectMocks.src.main.java.BreakfastWaiter;
import mistry.InjectMocks.src.main.java.CustomerOrder;
import mistry.InjectMocks.src.main.java.DinnerWaiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class CustomerOrderTest {

    @Spy
    BreakfastWaiter breakfastWaiter;

    @Spy
    DinnerWaiter dinnerWaiter;

    @InjectMocks
    CustomerOrder customerOrder;

    @Test
    public void testServeVegetarianBreakfast(){

        List<String> expectedBreakfast = Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
        List<String> actualBreakfast = customerOrder.vegetarianBreakfast();
        assertThat(expectedBreakfast, is(actualBreakfast));
    }

    @Test
    public void testServeMeatDinner(){

        List<String> expectedDinner = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
        List<String> actualDinner = customerOrder.meatDinner();
        assertThat(expectedDinner, is(actualDinner));
    }
}