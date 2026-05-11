package org.example.spring_hw001.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.spring_hw001.model.entity.Person;
import org.example.spring_hw001.model.request.PersonRequest;
import org.example.spring_hw001.repository.PersonRepo;
import org.example.spring_hw001.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;

    @Override
    public List<Person> findAllPersons() {
        return personRepo.findAllPersons();
    }

    @Override
    public Person findById(long id) {
        return personRepo.findById(id);
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepo.findByName(name);
    }

    @Override
    public Person createPerson(Object personRequest) {
        return null;
    }

    @Override
    public Person createPerson(PersonRequest personRequest) {
        Person person = new Person();
        person.setName(personRequest.getName());
        person.setGender(personRequest.getGender());
        person.setAge(personRequest.getAge());
        personRepo.createPerson(person);
        return person;
    }

    @Override
    public Person updateById(long id, PersonRequest personRequest) {
        personRepo.updateById(id, personRequest);
        return personRepo.findById(id);
    }

    @Override
    public void deleteById(long id) {
        personRepo.deleteById(id);
    }
}