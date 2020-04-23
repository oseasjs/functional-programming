package br.com.functional.programming.combinator;

import br.com.functional.programming.dto.Person;

import java.util.function.Function;

import static br.com.functional.programming.combinator.ValidatorCombinator.ValidationResult;

public interface ValidatorCombinator extends Function<Person, ValidationResult> {

    static ValidatorCombinator isNameValid() {
        return person ->
                person.getName().startsWith("J") ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_VALID_NAME;
    }

    static ValidatorCombinator isAnAdult() {
        return person ->
                person.getAge() > 18 ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default ValidatorCombinator and (ValidatorCombinator other) {
        return person -> {
            ValidationResult result = this.apply(person);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(person) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        IS_NOT_VALID_NAME,
        IS_NOT_AN_ADULT
    }

}