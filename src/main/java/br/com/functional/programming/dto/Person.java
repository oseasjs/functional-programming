package br.com.functional.programming.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    public static final String NOT_FOUND_MESSAGE = "Person not found";

    private String name;
    private Integer age;

}
