package br.com.functional.programming.interfaces;

import br.com.functional.programming.dto.Person;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface PersonLambdaFunctionalInterface {

    Person ADHOC_NICK = new Person("Nick", 10);

    String getPersonName(Person person);

    // Zero Parameter
    Supplier<String> nickPersonToUpperCase = () -> ADHOC_NICK.getName().toUpperCase(); // Impure

    //One Typed Parameter
    Consumer<Person> checkPerson = (person) -> Optional
            .ofNullable(person)
            .orElseThrow(() ->new RuntimeException(Person.NOT_FOUND_MESSAGE)); // Impure

    // One Typed Parameter using Function
    Function<Person, String> personNameUpperCase = (person) -> person.getName().toUpperCase();

    // Multiple Typed parameter using BiFunction
    BiFunction<Person, String, String> personNameComplement = (person, complement) ->
            person.getName().concat(complement); // Side Effect

}
