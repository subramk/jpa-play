package mistry.spies;

public class BookService implements mistry.spies.IBookService{
	
	public mistry.spies.Book findBook(String bookId) {
		throw new RuntimeException("~~~~~~~~Method not implemented");
	}
	
	public int getAppliedDiscount(mistry.spies.Book book2, int discountRate) {
		int price = book2.getPrice();
		int newPrice = price - (price * discountRate / 100);
		return newPrice;
	}


}
