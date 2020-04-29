package br.com.functional.programming.callbacks;

import br.com.functional.programming.dto.Person;

import java.util.List;
import java.util.function.Consumer;

public class CallbackService {

    public void filterPersonByNameAndDoSomethingWithIt(String personName, List<Person> list,
                                                   Consumer<Person> callback) {
        Person personFound = list
                .stream()
                .filter(p -> p.getName().equals(personName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(Person.NOT_FOUND_MESSAGE));

        callback.accept(personFound);
        
    }

}
