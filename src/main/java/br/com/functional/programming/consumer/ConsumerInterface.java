package br.com.functional.programming.consumer;

import br.com.functional.programming.dto.Person;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface ConsumerInterface {

    String INVALID_PERSON_AGE = "Invalid person age";

    Consumer<Person> checkIsAnAdult = person ->
        Optional
            .ofNullable(person)
            .filter(p -> p.getAge() > 18)
            .orElseThrow(() -> new RuntimeException(INVALID_PERSON_AGE));

    BiConsumer<Person, Person> checkPersonYoungerThanOther = (person, other) ->
        Optional
            .ofNullable(person)
            .filter(p -> p.getAge() <= other.getAge())
            .orElseThrow(() -> new NumberFormatException(INVALID_PERSON_AGE));

}
