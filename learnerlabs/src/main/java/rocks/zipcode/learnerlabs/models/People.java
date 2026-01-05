package rocks.zipcode.learnerlabs.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class People<PersonType extends Person> implements Iterable<PersonType> {

    private List<PersonType> personList;

    public People(List<PersonType> personList) {
        this.personList = personList;
    }

    @SafeVarargs
    public People(PersonType... people) {
        this.personList = new ArrayList<>(Arrays.asList(people));
    }

    @Override
    public Iterator<PersonType> iterator() {
        return personList.iterator();
    }

    public void add(PersonType person) {
        personList.add(person);
    }

    public void remove(PersonType person) {
        personList.remove(person);
    }

    public int size() {
        return personList.size();
    }
    
    public void clear() {
        personList.clear();
    }
    
    public void addAll(Iterable<PersonType> people) {
        for (PersonType person : people) {
            personList.add(person);
        }
    }
    
    public PersonType findById(long id) {
        for (PersonType person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
    
    public List<PersonType> findAll() {
        return personList;
    }
}