package br.com.functional.programming.imperative;

import br.com.functional.programming.declarative.DeclarativeProgramming;
import br.com.functional.programming.dto.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static br.com.functional.programming.mock.PersonMock.*;

public class ImperativeDeclarativeProgrammingTest {

    private ImperativeProgramming imperativeProgramming;
    private DeclarativeProgramming declarativeProgramming;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void init() {
        imperativeProgramming = new ImperativeProgramming();
        declarativeProgramming = new DeclarativeProgramming();
    }

    @Test
    public void compareImperativeDeclarativeProgrammingSuccess() {

        Person personFoundImp = imperativeProgramming.findPersonByNameOnList(MIKE.getName(), PERSON_LIST_WITH_MIKE);
        Person personFoundDec = declarativeProgramming.findPersonByNameOnList(MIKE.getName(), PERSON_LIST_WITH_MIKE);

        Assert.assertNotNull(personFoundImp);
        Assert.assertEquals(MIKE.getName(), personFoundImp.getName());
        Assert.assertEquals(MIKE.getAge(), personFoundImp.getAge());

        Assert.assertNotNull(personFoundDec);
        Assert.assertEquals(personFoundImp.getName(), personFoundDec.getName());
        Assert.assertEquals(personFoundImp.getAge(), personFoundDec.getAge());

    }

    @Test
    public void isImperativeFindPersonOnListSuccess() {

        Person personFound = imperativeProgramming.findPersonByNameOnList(MIKE.getName(), PERSON_LIST_WITH_MIKE);

        Assert.assertNotNull(personFound);
        Assert.assertEquals(MIKE.getName(), personFound.getName());
        Assert.assertEquals(MIKE.getAge(), personFound.getAge());

    }

    @Test
    public void isImperativeFindPersonOnListFailed() {

        expectedException.expectMessage(Person.NOT_FOUND_MESSAGE);
        expectedException.expect(RuntimeException.class);

        imperativeProgramming.findPersonByNameOnList(MIKE.getName(), PERSON_LIST_WITHOUT_MIKE);

    }

    @Test
    public void isDeclarativeFindPersonOnListSuccess() {

        Person personFound = declarativeProgramming.findPersonByNameOnList(MIKE.getName(), PERSON_LIST_WITH_MIKE);

        Assert.assertNotNull(personFound);
        Assert.assertEquals(MIKE.getName(), personFound.getName());
        Assert.assertEquals(MIKE.getAge(), personFound.getAge());

    }

    @Test
    public void isDeclarativeFindPersonOnListFailed() {

        expectedException.expectMessage(Person.NOT_FOUND_MESSAGE);
        expectedException.expect(RuntimeException.class);

        declarativeProgramming.findPersonByNameOnList(MIKE.getName(), PERSON_LIST_WITHOUT_MIKE);

    }

}
