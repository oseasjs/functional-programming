package br.com.functional.programming.declarative;

import br.com.functional.programming.dto.Person;

import java.util.List;

public class DeclarativeProgramming {

    public Person findPersonOnList(Person person, List<Person> list) {

        Person personFound = null;

        for (Person p : list) {

            if (p.toString().equals(person.toString())) {
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
