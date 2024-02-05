package mockito.spies;

public class BookService2 implements IBookService2 {
	
	public Book2 findBook(String bookId) {
		throw new RuntimeException("~~~~~~~~Method not implemented");
	}
	
	public int getAppliedDiscount(Book2 book2, int discountRate) {
		int price = book2.getPrice();
		int newPrice = price - (price * discountRate / 100);
		return newPrice;
	}


}
