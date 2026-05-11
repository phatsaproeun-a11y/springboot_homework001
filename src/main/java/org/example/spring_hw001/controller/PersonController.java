package org.example.spring_hw001.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring_hw001.model.entity.Person;
import org.example.spring_hw001.model.request.PersonRequest;
import org.example.spring_hw001.model.response.ApiResponse;
import org.example.spring_hw001.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Person>>> findAllPersons() {
        List<Person> persons = personService.findAllPersons();
        return ResponseEntity.ok(new ApiResponse<>(
                "Get all persons successfully!",
                persons,
                HttpStatus.OK.value(),
                LocalDateTime.now()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Person>> findById(@PathVariable long id) {
        Person person = personService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(
                "Get person successfully!",
                person,
                HttpStatus.OK.value(),
                LocalDateTime.now()
        ));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Person>>> findByName(@RequestParam String name) {
        List<Person> persons = personService.findByName(name);
        return ResponseEntity.ok(new ApiResponse<>(
                "Search persons successfully!",
                persons,
                HttpStatus.OK.value(),
                LocalDateTime.now()
        ));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Person>> createPerson(@RequestBody PersonRequest personRequest) {
        Person person = personService.createPerson(personRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
                "Person created successfully!",
                person,
                HttpStatus.CREATED.value(),
                LocalDateTime.now()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Person>> updateById(@PathVariable long id,
                                                          @RequestBody PersonRequest personRequest) {
        Person person = personService.updateById(id, personRequest);
        return ResponseEntity.ok(new ApiResponse<>(
                "Person updated successfully!",
                person,
                HttpStatus.OK.value(),
                LocalDateTime.now()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable long id) {
        personService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(
                "Person deleted successfully!",
                null,
                HttpStatus.OK.value(),
                LocalDateTime.now()
        ));
    }
}