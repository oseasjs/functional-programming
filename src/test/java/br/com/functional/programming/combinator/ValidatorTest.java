package br.com.functional.programming.combinator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.functional.programming.combinator.ValidatorCombinator.*;
import static br.com.functional.programming.mock.PersonMock.*;

public class ValidatorTest {

    private PersonValidation personValidation;

    @Before
    public void init() {
        personValidation = new PersonValidation();
    }

    @Test
    public void isPersonValidSuccess() {

        boolean isPersonValid = personValidation.isValid(JULIE);
        Assert.assertTrue(isPersonValid);

    }

    @Test
    public void isPersonValidNameFailed() {

        boolean isPersonValid = personValidation.isValid(NANCY);
        Assert.assertFalse(isPersonValid);

    }

    @Test
    public void isPersonValidAgeFailed() {

        boolean isPersonValid = personValidation.isValid(JOHN);
        Assert.assertFalse(isPersonValid);

    }

    @Test
    public void isPersonValidationCombinationSuccess() {

        ValidationResult validationResult = isNameValid()
                .and(isAnAdult())
                .apply(JULIE);

        Assert.assertEquals(ValidationResult.SUCCESS, validationResult);

    }

    @Test
    public void isPersonValidationCombinationNameFailed() {

        ValidationResult validationResult = isNameValid()
                .and(isAnAdult())
                .apply(NANCY);

        Assert.assertEquals(ValidationResult.IS_NOT_VALID_NAME, validationResult);

    }

    @Test
    public void isPersonValidationCombinationAgeFailed() {

        ValidationResult validationResult = isNameValid()
                .and(isAnAdult())
                .apply(JOHN);

        Assert.assertEquals(ValidationResult.IS_NOT_AN_ADULT, validationResult);

    }

}
