package org.example.controllers;

import org.example.main.Person;
import org.example.repositories.PersonRepository;
import org.example.main.Patterns.Factory.PersonFactory;

import java.util.List;

public class PersonController {
    private PersonRepository peopleRepository;
    private PersonFactory personFactory;
    private Person currentPerson;

    public PersonController(PersonRepository peopleRepository, PersonFactory personFactory) {
        this.peopleRepository = peopleRepository;
        this.personFactory = personFactory;
    }

    public void createPerson(int personId, String fname, String lname,String bdate, String adress, String email) {
        if(email == null || email.isEmpty()){
            peopleRepository.save(personFactory.createAuthor(personId,fname,lname,bdate,adress));
        }
        else{
            peopleRepository.save(personFactory.createClient(personId,fname,lname,bdate,adress,email));
        }
//        Person person = new Person(personId, fname, lname, bdate, adress);
//        peopleRepository.save(person);
    }

    public Person findPersonById(int personId) {
        return peopleRepository.findById(personId);
    }

    public List<Person> viewAllPeople() {
        return peopleRepository.findAll();
    }

    public void updatePerson(int personId, String fname, String lname,String bdate, String adress, String email) {
        if(email == null || email.isEmpty()){
            Person updatedauthor = personFactory.createAuthor(personId,fname,lname,bdate,adress);
            peopleRepository.save(updatedauthor);
        }
        else{
            Person updatedclient = personFactory.createClient(personId,fname,lname,bdate,adress,email);
            peopleRepository.save(updatedclient);
        }
//        Person updatedperson = new Person(personId, fname, lname, bdate, adress);
//        peopleRepository.update(updatedperson);
    }

    public void deletePerson(int personId) {
        peopleRepository.delete(personId);
    }
}