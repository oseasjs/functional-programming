package br.com.functional.programming.predicate;

import br.com.functional.programming.dto.Person;

import java.util.function.Predicate;

public interface PredicateInterface {

    static boolean isNameStartWithJValid(String name) {
        return name.startsWith("J") && name.length() > 4;
    }

    Predicate<Integer> isAnAdult = age -> age >= 18;

    Predicate<String> isNameStartingWithJ = name -> name.startsWith("J");

    Predicate<String> isNameLengthHigherThan4 = name -> name.length() >= 4;

    Predicate<Person> isPersonAnAdult = person -> person.getAge() >= 18;

    Predicate<Person> isPersonAnAdultAndNameStartingWithJ = person ->
            person.getAge() >= 18 && person.getName().startsWith("J");

}
