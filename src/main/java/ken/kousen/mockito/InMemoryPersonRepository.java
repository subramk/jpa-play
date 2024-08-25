package ken.kousen.mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.Long.valueOf;

public class InMemoryPersonRepository implements  PersonRepository
 {
    private final List<Person> people =  Collections.synchronizedList(new ArrayList<>());

    @Override
    public final Person save(Person person) {
        synchronized (people) {
            people.add(person);
        }
        return person;
    }

    @Override
    public final void delete(Person person) {
        synchronized (people) {
            people.remove(person);
        }
    }

    @Override
    public Optional<Person> findById(int id){
        return Optional.of(people.get(id));
        // throw new UnsupportedOperationException("not yet implemented");

    }

    @Override
    public  List<Person> findAll(){
        return people;
        //throw new UnsupportedOperationException("not yet implemented");
    }

    public long count(){
        return valueOf(people.size());
    }




}
