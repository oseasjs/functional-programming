package br.com.functional.programming.imperative;

import br.com.functional.programming.dto.Person;

import java.util.List;

public class ImperativeProgramming {

    public Person findPersonOnList(Person person, List<Person> list) {

        return list
            .stream()
            .filter(p -> p.toString().equals(person.toString()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException(Person.NOT_FOUND_MESSAGE));

    }

}
