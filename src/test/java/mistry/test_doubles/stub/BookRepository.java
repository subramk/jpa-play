package mistry.test_doubles.stub;

import java.util.List;

public interface BookRepository {
	List<Book> findNewBooks(int days);
}
