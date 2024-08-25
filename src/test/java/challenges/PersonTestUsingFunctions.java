package challenges;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Originally from https://betterprogramming.pub/my-ten-year-quest-for-concise-lambda-expressions-in-java-39fde576b950
 * Donald Raab
 *
 */
public class PersonTestUsingFunctions {
    @Test
    @DisplayName("Test First Last and FullName of the persons.")
    public void findUniqueFirstLastAndFullNames() {
        LinkedList<Person> people = new LinkedList<>(
                List.of(
                Person.builder().firstName("kasi").lastName("subramk").build(),
                Person.builder().firstName("satish").lastName("solvendar").build(),
                Person.builder().firstName("anez").lastName("southwest").build()
                ));

        Function<Person,String> byFirstName = person -> person.getFirstName();
        Function<Person,String> byLastName = person -> person.getLastName();
        Function<Person,String> byFullName = person -> person.getFullName();


        Set<String> firstNames = getUniqueValues(people, each -> each.getFirstName());
        Set<String> lastNames = getUniqueValues(people,  each -> each.getLastName());
        Set<String> fullNames = getUniqueValues(people, each -> each.getFullName());

        assertEquals(Set.of("kasi", "satish", "anez"), firstNames);
        assertEquals(Set.of("subramk", "southwest", "solvendar"), lastNames);
        assertEquals(Set.of("kasi subramk", "satish solvendar", "anez southwest"), fullNames);

    }

    private Set<String> getUniqueValues(List<Person> people, Function<Person, String> personFunction) {

        Set<String> values = new HashSet<>();
        for (Person each : people) {
            values.add(personFunction.apply(each));
        }
        return values;
    }
}
