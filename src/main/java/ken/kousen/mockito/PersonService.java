package ken.kousen.mockito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import ken.kousen.mockito.Person;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {
    @Autowired
    private final PersonRepository personRespository;

    public PersonService(PersonRepository personRespository) {
        this.personRespository = personRespository;
    }

    public List<String> getLastNames() {
        return personRespository.findAll()
            .stream()
            .map(Person::getLast)
            .collect(Collectors.toList());
    }

    public List<Person> findByIds(int... ids) {
        return Arrays.stream(ids)
            .filter(Objects::nonNull)
            .mapToObj(personRespository::findById)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }

    public Long getHighestId() {
        return personRespository.findAll()
            .stream()
            .mapToLong(Person::getId)
            .max().orElse(0);
    }

    public List<Long> savePeople(Person... person) {
        return Arrays.stream(person)
                .filter(Objects::nonNull)
                .map(personRespository::save) // save() generates ids
            .map(Person::getId)
            .collect(Collectors.toList());
    }

    public Person createPerson(Long id, String first,
                               String last, LocalDate dob) {
        String fullName = first +  last ;
        Person person = new Person(id, first, last, fullName,  dob);
        return personRespository.save(person);
    }

    public Person createPerson(Long id, String first,
                               String last, String dobString) {
        String fullName = first +  last ;
        Person person = new Person(id, first, last, fullName,  LocalDate.parse(dobString));
        return personRespository.save(person);
    }

    public long getTotalPeople() {
        return personRespository.count();
    }

    public void deleteAll() {
        personRespository.findAll()
            .forEach(personRespository::delete);
    }

}
