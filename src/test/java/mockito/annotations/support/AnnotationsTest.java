package mockito.annotations.support;

import mistry.bdd.behavior_verification.Book;
import mistry.bdd.behavior_verification.BookRepository;
import mistry.bdd.behavior_verification.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {

	@InjectMocks
	private BookService bookService;

	@Mock
	private BookRepository bookRepository;

	@Test
	//TODO FIX TEST
	public void demoCreateMocksUsingAnnotations() {
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

		List<Book> newBooks = new ArrayList<>();
		newBooks.add(book1);
		newBooks.add(book2);

		// when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

		// List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

//		assertEquals(2, newBooksWithAppliedDiscount.size());
//		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
//		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());


	}

}
