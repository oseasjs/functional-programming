package br.com.functional.programming.interfaces;

import br.com.functional.programming.dto.Person;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface PersonLambdaFunctionalInterface {

    public static final Person ADHOC_NICK = new Person("Nick", 10);

    abstract String getPersonName(Person person);

    // Zero Parameter
    public static Supplier<String> nickPersonToUpperCase = () -> ADHOC_NICK.getName().toUpperCase();

    //One Typed Parameter
    public static Consumer<Person> checkPerson = (person) -> Optional
            .ofNullable(person)
            .orElseThrow(() ->new RuntimeException(Person.NOT_FOUND_MESSAGE));

    // One Typed Parameter using Function
    public static Function<Person, String> personNameUpperCase = (person) -> person.getName().toUpperCase();

    // Multiple Typed parameter using BiFunction
    public static BiFunction<Person, String, String> personNameComplement = (person, complement) -> person.getName().concat(complement);

}
