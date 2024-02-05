package mistry.spies;

public interface IBookService {

    public mistry.spies.Book findBook(String bookId);

    public int getAppliedDiscount(mistry.spies.Book  book, int discountRate);


}