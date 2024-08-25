package ken.kousen.mockito;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PersonServiceSpring {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceSpring(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAllPersons(){
        return personRepository.findAll();

    }

    // ... methods that use the repository ...
}
