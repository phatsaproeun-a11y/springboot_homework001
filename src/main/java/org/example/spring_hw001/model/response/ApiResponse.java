package org.example.spring_hw001.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiResponse <T>{
    private String message;
    private T payload;
    private int status;
    private LocalDateTime date;

}
