package br.com.functional.programming.function;

import br.com.functional.programming.dto.Person;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface FunctionInterface {

    Function<Person, Person> incrementOneYearOnPersonAge = (person) -> {
        person.setAge(person.getAge() + 1);
        return person;
    };

    BiFunction<Person, Integer, Person> addYearsPersonAge = (person, years) -> {
        person.setAge(person.getAge() + years);
        return person;
    };

    BiFunction<Person, Person, Boolean> isYongerThan = (personA, personB) ->
            personA.getAge() < personB.getAge();

}
