package mockito.spies;


public class BookManager2 {
	
	private BookService2 bookService;
	
	public BookManager2(BookService2 bookService) {
		this.bookService = bookService;
	}
	
	public int applyDiscountOnBook(String bookId, int discountRate) {
		Book2 book2 = bookService.findBook(bookId); // We need to Mock
		int discountedPrice = bookService.getAppliedDiscount(book2, discountRate);
		return discountedPrice;
	}
}
