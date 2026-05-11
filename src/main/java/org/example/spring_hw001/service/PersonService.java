package org.example.spring_hw001.service;

import org.example.spring_hw001.model.entity.Person;
import org.example.spring_hw001.model.request.PersonRequest;

import java.util.List;

public interface PersonService {
    List<Person> findAllPersons();
    Person findById(long id);
    List<Person> findByName(String name);
    Person createPerson(Object personRequest);

    Person createPerson(PersonRequest personRequest);

    Person updateById(long id, PersonRequest personRequest);
    void deleteById(long id);
}