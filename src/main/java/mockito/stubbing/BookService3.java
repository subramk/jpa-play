package mockito.stubbing;

import java.util.List;

public class BookService3 {
	
	private BookRepository3 bookRepository;
	
	public BookService3(BookRepository3 bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book3> getNewBooksWithAppliedDiscount(int discountRate, int days){
		List<Book3> newBooks = bookRepository.findNewBooks(days);
		// 500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450
		
		for(Book3 book : newBooks){
			int price = book.getPrice();
			int newPrice = price - (discountRate * price / 100);
			book.setPrice(newPrice);
		}
		
		return newBooks;
	}
	
	public int calculateTotalCost(List<String> bookIds) {
		int total = 0;
		for(String bookId : bookIds){
			Book3 book = bookRepository.findBookByBookId(bookId);
			total = total + book.getPrice();
		}
		return total;
	}
	
	public void addBook(Book3 book) {
		bookRepository.save(book);
	}
	
	public void addBook(BookRequest3 bookRequest) {
		if(bookRequest.getPrice() <= 500){
			return;
		}
		Book3 book = new Book3();
		book.setTitle(bookRequest.getTitle());
		book.setPrice(bookRequest.getPrice());
		book.setPublishedDate(bookRequest.getPublishedDate());
		bookRepository.save(book);
	}
}
