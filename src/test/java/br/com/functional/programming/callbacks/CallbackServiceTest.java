package br.com.functional.programming.callbacks;

import br.com.functional.programming.dto.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static br.com.functional.programming.mock.PersonMock.PERSON_LIST_WITH_MIKE;

public class CallbackServiceTest {

    private CallbackService callbackService;

    private static final String JEFFREY_NAME = "Jeffrey";
    private static final String NICK_NAME = "Jeff";
    private static final Integer TEN = 10;
    private static final Integer TWENTY = 20;

    @Before
    public void init() {
        callbackService = new CallbackService();
    }

    @Test
    public void increasePersonAgeSuccess() {

        Person jeffrey = new Person(JEFFREY_NAME, TEN);
        List<Person> personList = new ArrayList<>(PERSON_LIST_WITH_MIKE);
        personList.add(jeffrey);

        callbackService.filterPersonByNameAndDoSomethingWithIt(JEFFREY_NAME, personList,
                jeff -> jeff.setAge(TWENTY));

        Assert.assertNotEquals(jeffrey.getAge(), TEN);
        Assert.assertEquals(jeffrey.getAge(), TWENTY);

    }

    @Test
    public void renamePersonSuccess() {

        Person jeffrey = new Person(JEFFREY_NAME, TEN);
        List<Person> personList = new ArrayList<>(PERSON_LIST_WITH_MIKE);
        personList.add(jeffrey);

        callbackService.filterPersonByNameAndDoSomethingWithIt(JEFFREY_NAME, personList,
                jeff -> jeff.setName(NICK_NAME));

        Assert.assertNotEquals(jeffrey.getName(), JEFFREY_NAME);
        Assert.assertEquals(jeffrey.getName(), NICK_NAME);

    }

}
