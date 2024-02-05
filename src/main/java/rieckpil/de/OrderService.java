package rieckpil.de;

import java.time.LocalDate;
import java.util.UUID;


// Example From https://rieckpil.de/mocking-static-methods-with-mockito-java-kotlin/
public class OrderService {

    public Order createOrder(String productName, Long amount, String parentOrderId) {
        Order order = new Order();

        order.setId(parentOrderId == null ? UUID.randomUUID().toString() : parentOrderId);
        order.setCreationDate(LocalDate.now());
        order.setAmount(amount);
        order.setProductName(productName);

        return order;
    }

}
