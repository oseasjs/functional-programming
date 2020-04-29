package br.com.functional.programming.imperative;

import br.com.functional.programming.dto.Person;

import java.util.List;

public class ImperativeProgramming {

    public Person findPersonByNameOnList(String personName, List<Person> list) {

        Person personFound = null;

        for (Person p : list) {

            if (p.getName().equals(personName)) {
                personFound = p;
                break;
            }

        }

        if (personFound == null) {
            throw new RuntimeException(Person.NOT_FOUND_MESSAGE);
        }

        return personFound;

    }

}
