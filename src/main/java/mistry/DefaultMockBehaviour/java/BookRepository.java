package mistry.DefaultMockBehaviour.java;

public interface BookRepository   {

	void save(Book book);
	Book findBookById(String bookId);
}
