package org.example.spring_hw001.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonRequest {
    private String name;
    private String gender;
    private int age;
}
