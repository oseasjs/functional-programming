package br.com.functional.programming.declarative;

import br.com.functional.programming.dto.Person;

import java.util.List;

public class DeclarativeProgramming {

    public Person findPersonByNameOnList(String personName, List<Person> list) {

        return list
                .stream()
                .filter(p -> p.getName().equals(personName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(Person.NOT_FOUND_MESSAGE));

    }

}
