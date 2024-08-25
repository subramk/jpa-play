package ken.kousen.mockito;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Either
// This //@SpringBootTest() &&   @ContextConfiguration(classes = PersonServiceSpring.class)
// OR
// This @SpringBootTest(classes = PersonServiceSpring.class) with  @ContextConfiguration()  will Load the Classes.

@SpringBootTest
@ContextConfiguration(classes = PersonServiceSpring.class)
public class PersonServiceSpringTest {

    // Note , we do not use the  @Mock here ,
    @Autowired
    private PersonServiceSpring personServiceSpring;

    @MockBean
    private PersonRepository personRepository;

    @Test
    @DisplayName("check all the dependencies are initialized")
    public void checkDeps(){
        Assert.assertNotNull(personServiceSpring);
        Assert.assertNotNull(personRepository);
        System.out.println(" Hashcode of the personRepository " + personRepository.hashCode());
    }

    @Test
    public void someTestMethod() {
        // Set expectations on mock
        List<Person> persons = Arrays
                .asList(
                        new Person(1L,"subr","kasi", LocalDate.of(1971,12,12)));

        when(personRepository.findAll()).thenReturn(persons);

        // Test service method
        assertEquals(1, personServiceSpring.findAllPersons().size());

        // Verify method call on mock
        Mockito.verify(personRepository).findAll();
    }
}
