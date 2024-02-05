package mistry.exception_handling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository5 {
	List<Book5> findAllBooks() throws SQLException;
	void save(Book5 book) throws SQLException;
}
