package ua.zhekon.springtest.dao;

import org.springframework.stereotype.Component;
import ua.zhekon.springtest.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Nick"));
        people.add(new Person(++PEOPLE_COUNT, "Sara"));
        people.add(new Person(++PEOPLE_COUNT, "Vova"));
        people.add(new Person(++PEOPLE_COUNT, "John"));
    }

    public List<Person> index() {
        return people;
    }

    // return Person with Id
    public Person show(int id) {
        return people.stream().filter(a -> a.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update( int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
    }
    public void delete(int id){
        people.removeIf(a -> a.getId()==id);
    }
}
