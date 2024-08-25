package ken.kousen.mockito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
// does not extend the JPARepository etc here.
public interface PersonRepository  {
    Person save(Person person);

    Optional<Person> findById(int id);

    List<Person> findAll();

    long count();

    void delete(Person person);
}
