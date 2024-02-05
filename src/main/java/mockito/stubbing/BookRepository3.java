package mockito.stubbing;

import java.util.List;

public interface BookRepository3 {
	List<Book3> findNewBooks(int days);
	Book3 findBookByBookId(String bookId);
	void save(Book3 book);
}
