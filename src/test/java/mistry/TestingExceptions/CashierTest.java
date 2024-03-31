package mistry.TestingExceptions;

import org.junit.jupiter.api.Assertions;

public class CashierTest {

    public void validateTransactionUnacceptedCurrency(){

        RuntimeException    thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            // Code under test
             //Cashier.validateTransaction("USD", 10);

        });

        Assertions.assertEquals("some message", thrown.getMessage());

    }

    //@Test(expected = RuntimeException.class)
    public void validateTransactionAmountNegative(){
        //Cashier.validateTransaction("EUR", -10);
    }
}
