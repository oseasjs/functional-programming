package br.com.functional.programming.suppliers;

import br.com.functional.programming.dto.Person;

import java.util.List;
import java.util.function.Supplier;

public interface SupplierInterface {

    String MATT_NAME = "Matt";
    String JANE_NAME = "Jane";

    Supplier<List<Person>> adhocPersonList = () -> List.of(
        new Person(MATT_NAME, 20),
        new Person(JANE_NAME, 25)
    );

    Supplier<Person> mattFromAdhocPersonList = () -> adhocPersonList
            .get()
            .stream()
            .filter(p -> p.getName().equals(MATT_NAME))
            .findFirst()
            .get();

}
