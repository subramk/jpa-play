package mistry.exception_handling;


import java.sql.SQLException;
import java.util.List;

public class BookService5 {
	
	private BookRepository5 bookRepository;
	
	public BookService5(BookRepository5 bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public int getTotalPriceOfBooks() {
		List<Book5> books = null;
		try {
			books = bookRepository.findAllBooks();
		} catch (SQLException e) {
			// log exception
			throw new DatabaseReadException5("Unable to read from database due to - " + e.getMessage());
		}
		int totalPrice = 0;
		for(Book5 book : books){
			totalPrice = totalPrice + book.getPrice();
		}
		return totalPrice;
	}
	
	public void addBook(Book5 book){
		try {
			bookRepository.save(book);
		} catch (SQLException e) {
			// log exception
			throw new DatabaseWriteException6("Unable to write in database due to - " + e.getMessage());
		}
	}
}
