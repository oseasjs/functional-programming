package br.com.functional.programming.consumer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static br.com.functional.programming.consumer.ConsumerInterface.*;
import static br.com.functional.programming.mock.PersonMock.*;

public class CosumerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void isPersonAnAdultSuccess() {
        checkIsAnAdult.accept(MIKE);
    }

    @Test
    public void isPersonAnAdultFailed() {

        expectedException.expectMessage(INVALID_PERSON_AGE);
        expectedException.expect(RuntimeException.class);

        checkIsAnAdult.accept(JOHN);
    }

    @Test
    public void isPersonOnAgeLimitSuccess() {
        checkPersonYongerThanOther.accept(MIKE, JULIE);
    }

    @Test
    public void isPersonOnAgeLimitFailed() {

        expectedException.expectMessage(INVALID_PERSON_AGE);
        expectedException.expect(RuntimeException.class);

        checkPersonYongerThanOther.accept(MIKE, JOHN);

    }

}
