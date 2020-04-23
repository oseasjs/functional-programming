package br.com.functional.programming.function;

import br.com.functional.programming.dto.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.functional.programming.function.FunctionInterface.*;
import static br.com.functional.programming.mock.PersonMock.MIKE;

public class FunctionInterfaceTest {

    private Person JEFREY;

    @Before
    public void init() {
        JEFREY = new Person("Jefrey", 15);
    }

    @Test
    public void isYongerThanSuccess() {

        Boolean result = isYongerThan.apply(JEFREY, MIKE);
        Assert.assertTrue(result);

    }

    @Test
    public void isNotYongerThanSuccess() {

        Boolean result = isYongerThan.apply(MIKE, JEFREY);
        Assert.assertFalse(result);

    }

    @Test
    public void isJohnAnAdultSuccess() {

        Person oldJefrey = incrementOneYearOnPersonAge
                .andThen(incrementOneYearOnPersonAge)
                .andThen(incrementOneYearOnPersonAge)
                .apply(JEFREY);

        Assert.assertTrue(oldJefrey.getAge() == 18);

    }

    @Test
    public void isJohnAnAcientSuccess() {

        Person oldJefrey = addYearsPersonAge
                .apply(JEFREY, 45);

        Assert.assertTrue(oldJefrey.getAge() == 60);

    }

}
