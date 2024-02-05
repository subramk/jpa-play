package mistry.stubbing;

import java.util.List;

public interface BookRepository {

	List<mistry.stubbing.Book> findNewBooks(int days);

	mistry.stubbing.Book findBookByBookId(String bookId);

	void save(mistry.stubbing.Book book);
}
