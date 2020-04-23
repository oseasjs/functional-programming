package br.com.functional.programming.combinator;

import br.com.functional.programming.dto.Person;

public class PersonValidation {

    private boolean isNameValid(String name) {
        return name.startsWith("J");
    }

    private boolean isAnAdult(Integer age) {
        return age > 18;
    }

    public boolean isValid(Person person) {
        return isNameValid(person.getName()) && isAnAdult(person.getAge());
    }

}
