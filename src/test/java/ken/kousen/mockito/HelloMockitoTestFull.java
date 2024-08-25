package ken.kousen.mockito;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloMockitoTestFull {
    @Mock
    private PersonRepository repository;

    @Mock
    private TranslationService translationService;

    @InjectMocks
    private HelloMockito helloMockito;

    @Test
    @DisplayName("Greet Admiral Hopper")
    void greetAPersonThatExists() {
        // set the expectations on the mocks
        when(repository.findById(anyInt()))
            .thenReturn(Optional.of(new Person(1L, "Grace", "Hopper",
                LocalDate.of(1906, Month.DECEMBER, 9))));

        when(translationService.translate("Hello, Grace, from Mockito!", "en", "en")).thenReturn("Hello, Grace, from Mockito!");

        // test the greet method
        String greeting = helloMockito.greet("Vanakkam");
        assertEquals("Hello, Grace, from Mockito!", greeting);

        // verify the methods are called once, in the right order
        InOrder inOrder = inOrder(repository, translationService);
        inOrder.verify(repository).findById(anyInt());
        inOrder.verify(translationService).translate(anyString(), eq("en"), eq("en"));
    }

    @Test
    @DisplayName("Greet a person not in the database")
    void greetAPersonThatDoesNotExist() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        when(translationService.translate("Hello, World, from Mockito!", "en", "en")).thenReturn("Hello, World, from Mockito!");

        String greeting = helloMockito.greet("Vanakkam");
        assertEquals("Hello, World, from Mockito!", greeting);

        // verify the methods are called once, in the right order
        InOrder inOrder = inOrder(repository, translationService);
        inOrder.verify(repository).findById(anyInt());
        inOrder.verify(translationService).translate(anyString(), eq("en"), eq("en"));
    }
}
