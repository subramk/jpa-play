package mistry.Answer;

import mistry.answer.src.main.java.BookManager;
import mistry.answer.src.main.java.BooksRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class BookManager2Test {

    @Spy
    private BooksRepository booksRepository;

    @InjectMocks
    private BookManager bookManager;

    private Set<String> booksDatabaseSet;

    @BeforeEach
    public   void setup(){
        booksDatabaseSet = new HashSet<String>();
        booksDatabaseSet.add("Harry Potter");

    }

    @Test
    void dummy() {
        Assertions.assertNotNull("asdfadsfa");
    }

//    @Test
//    public void testGetBookInventoryCount(){
//
//        BookManager bookManagerSpy = Mockito.spy(bookManager);
//        when(booksRepository.getBooks()).thenAnswer(new GetBooks());
//
//        Integer getBooksCount = bookManagerSpy.getBookInventoryCount();
//        assertThat(getBooksCount, is(1));
//
//        String newBook = "Black box thinking";
//        when(booksRepository.addBook(newBook)).thenAnswer(new AddBook());
//        bookManagerSpy.addBook(newBook);
//        Integer getBooksCountAfterAdd = bookManagerSpy.getBookInventoryCount();
//        assertThat(getBooksCountAfterAdd, is(2));
//    }

    class GetBooks implements Answer<Object> {

        public Object answer(InvocationOnMock invocation) throws Throwable {

            return booksDatabaseSet;
        }
    }

    class AddBook implements Answer<Object>{

        public Object answer(InvocationOnMock invocation) throws Throwable {
            String book = (String)invocation.getArguments()[0];
            booksDatabaseSet.add(book);
            return book;
        }
    }
}
