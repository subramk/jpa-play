package mistry.behavior.verification;


public interface BookRepository {
	void save(mistry.behavior.verification.Book book);
	Book findBookById(String bookId);
}
