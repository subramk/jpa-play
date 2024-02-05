package reickpil.de;

import org.junit.jupiter.api.Test;
//import org.mockito.MockedStatic;
import org.mockito.Mockito;
import rieckpil.de.Order;
import rieckpil.de.OrderService;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Examples From https://rieckpil.de/mocking-static-methods-with-mockito-java-kotlin/

public class OrderServiceTest {

    private OrderService cut = new OrderService();
    private UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private LocalDateTime defaultLocalDateTime = LocalDateTime.of(2020, 1, 1, 12, 0);

    @Test
    void shouldIncludeRandomOrderIdWhenNoParentOrderExists() {
//        try (MockedStatic<UUID> mockedUuid = Mockito.mockStatic(UUID.class)) {
//            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);
//
//            Order result = cut.createOrder("MacBook Pro", 2L, null);
//
//            assertEquals("8d8b30e3-de52-4f1c-a71c-9905a8043dac", result.getId());
//        }


    }
}
