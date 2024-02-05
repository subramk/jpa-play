package mockito.exception_handling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	@InjectMocks
	private mockito.exception_handling.BookService bookService;
	
	@Mock
	private mockito.exception_handling.BookRepository bookRepository;
	
	@Test
	public void testTotalPriceOfBooks() throws SQLException {
		when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
		assertThrows(mockito.exception_handling.DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
	}
	
	@Test
	public void testTotalPriceOfBooks3() throws SQLException {
//		when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
		given(bookRepository.findAllBooks()).willThrow(SQLException.class);
		assertThrows(mockito.exception_handling.DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
	}
	
	@Test
	public void testTotalPriceOfBooks1() throws SQLException {
		when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database not available"));
		assertThrows(mockito.exception_handling.DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
	}
	
	@Test
	public void testAddBook() throws SQLException {
		Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
		doThrow(SQLException.class).when(bookRepository).save(book);
		assertThrows(mockito.exception_handling.DatabaseWriteException.class, () -> bookService.addBook(book));
	}
	
	@Test
	public void testTotalPriceOfBooks2() throws SQLException {
		when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database not available"));
		assertThrows(mockito.exception_handling.DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
	}
	
}
