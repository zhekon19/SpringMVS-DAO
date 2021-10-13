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

        people.add(new Person(++PEOPLE_COUNT, "Nick", 22, "nick.@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sara", 14, "Sara.@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Vova", 31, "Vova.@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "John", 40, "John.@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    // return Person with Id
    public Person show(int id) {
        return people.stream()
                .filter(a -> a.getId() == id)
                .findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setMail(person.getMail());
    }

    public void delete(int id) {
        people.removeIf(a -> a.getId() == id);
    }
}
