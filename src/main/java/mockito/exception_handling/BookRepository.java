package mockito.exception_handling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
	List<mockito.exception_handling.Book> findAllBooks() throws SQLException;
	void save(mockito.exception_handling.Book book) throws SQLException;
}
