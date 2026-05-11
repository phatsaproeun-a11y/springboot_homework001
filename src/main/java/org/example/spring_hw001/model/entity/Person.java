package org.example.spring_hw001.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    private long id;
    private String name;
    private String gender;
    private int age;
}
