package mockito.stubbing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	@InjectMocks
	private BookService3 bookService;
	
	@Mock
	private BookRepository3 bookRepository;
	
	@Test
	public void testCalculateTotalCostOfBooks() {
		List<String> bookIds = new ArrayList<>();
		bookIds.add("1234");
		bookIds.add("1234");
		
		Book3 book1 = new Book3("1234", "Mockito In Action", 500, LocalDate.now());
		Book3 book2 = new Book3("1235", "JUnit 5 In Action", 400, LocalDate.now());
		
		when(bookRepository.findBookByBookId("1234"))
				.thenReturn(book1)
				.thenReturn(book1);
//		when(bookRepository.findBookByBookId("1234")).thenReturn(book1);
		
//		doReturn(book1).when(bookRepository).findBookByBookId("1234");
//		doReturn(book2).when(bookRepository).findBookByBookId("1235");
		
		int actualCost = bookService.calculateTotalCost(bookIds);
		assertEquals(1000, actualCost);
	}
	
	@Test
	public void testSaveBook() {
		Book3 book1 = new Book3(null, "Mockito In Action", 500, LocalDate.now());
		doNothing().when(bookRepository).save(book1); // ==
		bookService.addBook(book1);
	}
	
	@Test
	public void testSaveBookWithBookRequest() {
		BookRequest3 bookRequest = new BookRequest3("Mockito In Action", 600, LocalDate.now());
		Book3 book = new Book3(null, "Mockito In Action", 600, LocalDate.now());
		doNothing().when(bookRepository).save(book);
		bookService.addBook(bookRequest);
	}
	
	@Test
	public void testSaveBookWithBookRequestWithGreaterPrice() {
		BookRequest3 bookRequest = new BookRequest3("Mockito In Action", 500, LocalDate.now());
		Book3 book = new Book3(null, "Mockito In Action", 500, LocalDate.now());
//		doNothing().when(bookRepository).save(book);
		bookService.addBook(bookRequest);
	}
	
}
