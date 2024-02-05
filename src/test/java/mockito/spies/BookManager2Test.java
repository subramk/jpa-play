package mockito.spies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BookManager2Test {

	@InjectMocks
	private BookManager2 bookManager;
	
	@Spy
	private BookService2 bookService ;
	
	@Test
	public void testMockitoSpy(){

		// We need to mock findBook because it is communicating to database or not implemented
		// We need to call getAppliedDiscount to calculate the discounted price
		Book2 book2 = new Book2("1234", "Mockito In Action", 500, LocalDate.now());
		doReturn(book2).when(bookService).findBook(anyString());
		// use doReturn() syntax when working with Spy()
		// use when(...).thenReturn(....) when working with mocks.

		//when(bookService.findBook("1234")).thenReturn(book2); // use doReturn when working with Spy()
		int actualDiscount = bookManager.applyDiscountOnBook("1234", 10);
		assertEquals(450, actualDiscount);
	}
	
}
