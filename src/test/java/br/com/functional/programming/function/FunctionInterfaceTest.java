package br.com.functional.programming.function;

import br.com.functional.programming.dto.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.functional.programming.function.FunctionInterface.*;
import static br.com.functional.programming.mock.PersonMock.MIKE;

public class FunctionInterfaceTest {

    private Person MARK;

    @Before
    public void init() {
        MARK = new Person("Mark", 15);
    }

    @Test
    public void isYongerThanSuccess() {

        Boolean result = isYongerThan.apply(MARK, MIKE);
        Assert.assertTrue(result);

    }

    @Test
    public void isNotYongerThanSuccess() {

        Boolean result = isYongerThan.apply(MIKE, MARK);
        Assert.assertFalse(result);

    }

    @Test
    public void isJohnAnAdultSuccess() {

        Person oldPerson = incrementOneYearOnPersonAge
                .andThen(incrementOneYearOnPersonAge)
                .andThen(incrementOneYearOnPersonAge)
                .apply(MARK);

        Assert.assertTrue(oldPerson.getAge() == 18);

    }

    @Test
    public void isJohnAnAcientSuccess() {

        Person oldJefrey = addYearsPersonAge
                .apply(MARK, 45);

        Assert.assertTrue(oldJefrey.getAge() == 60);

    }

}
