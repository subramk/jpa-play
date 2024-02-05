package mockito.argument_captor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository   {

	void save(Book book);
	Book findBookById(String bookId);
}
