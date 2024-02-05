package mistry.spies;


public class BookManager {
	
	private mistry.spies.BookService bookService;
	
	public BookManager(BookService bookService) {
		this.bookService = bookService;
	}
	
	public int applyDiscountOnBook(String bookId, int discountRate) {
		mistry.spies.Book book1 = bookService.findBook(bookId); // We need to Mock
		int discountedPrice = bookService.getAppliedDiscount(book1, discountRate);
		return discountedPrice;
	}
}
