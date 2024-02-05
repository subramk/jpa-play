package mockito.spies;

public interface IBookService2 {
    public Book2 findBook(String bookId);

    public int getAppliedDiscount(Book2 book2, int discountRate);
}