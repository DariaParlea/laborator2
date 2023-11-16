package org.example.repositories;

import org.example.main.Person;
import org.example.main.Person;

import java.util.List;

public class PersonRepository {

    private List<Person> people;

    public PersonRepository(List<Person> people) {
        this.people = people;
    }

    public Person findById(int targetPersonId) {
        for (Person person : people) {
            if (person.getId() == targetPersonId) {
                return person;
            }
        }
        System.out.println("Could not find Person with Id: " + targetPersonId);
        return null;
    }

    public List<Person> findAll() {
        if (people.isEmpty()) {
            System.out.println("There are no people");
            return null;
        }
        return people;
    }


    public boolean save(Person person) {
        boolean saved = false;
        for (Person item : people) {
            if (person.getId() == item.getId()) {
                System.out.println("Person already exists");
                return saved;
            }

        }
        people.add(person);
        for (Person item : people) {
            if (person.getId() == item.getId())
                saved = true;
        }

        return saved;
    }

    public boolean update(Person updatedPerson) {
        boolean updated = false;
        for (Person person : people) {
            if (person.getId() == updatedPerson.getId()) {
                person.setFirstName(updatedPerson.getFirstName());
                person.setLastName(updatedPerson.getLastName());
                person.setBirth_date(updatedPerson.getBirth_date());
                person.setAddress(updatedPerson.getAddress());
                updated = true;
                break;
            }
        }
        if (updated == false)
            System.out.println("Person was not updated");

        return updated;
    }

    public boolean delete(int targetPersonId) {
        boolean deleted = false;
        Person personToRemove = null;
        for (Person person : people) {
            if (person.getId() == targetPersonId) {
                personToRemove = person;
                break;
            }
        }
        if (personToRemove == null) {
            System.out.println("Person does not exist");
            deleted = false;
        }
        if (personToRemove != null) {
            people.remove(personToRemove);
            deleted = true;
        }
        return deleted;


    }


}