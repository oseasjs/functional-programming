package br.com.functional.programming.optionals;

import br.com.functional.programming.dto.Person;

import java.util.Optional;

public class OptionalService {

    public String getPersonName(Optional<Person> person) {
        return person
                .map(p -> p.getName())
                .orElseThrow();
    }

    public String getPersonNameOrEmptyString(Optional<Person> person) {
        return person
                .map(Person::getName)
                .orElse(null);
    }

}
