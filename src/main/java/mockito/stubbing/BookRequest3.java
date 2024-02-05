package mockito.stubbing;

import java.time.LocalDate;

public class BookRequest3 {
	private String title;
	private int price;
	private LocalDate publishedDate;
	
	public BookRequest3(String title, int price, LocalDate publishedDate) {
		this.title = title;
		this.price = price;
		this.publishedDate = publishedDate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
}
