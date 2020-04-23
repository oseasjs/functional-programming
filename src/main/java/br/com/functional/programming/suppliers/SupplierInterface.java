package br.com.functional.programming.suppliers;

import br.com.functional.programming.dto.Person;

import java.util.List;
import java.util.function.Supplier;

public class SupplierInterface {

    static final String MATT_NAME = "Matt";

    static Supplier<List<Person>> adhocPersonList = () -> List.of(
        new Person(MATT_NAME, 20),
        new Person("Jane", 25)
    );

    static Supplier<Person> mattFromAdhocPersonList = () -> adhocPersonList
            .get()
            .stream()
            .filter(p -> p.getName().equals(MATT_NAME))
            .findFirst()
            .get();

}
