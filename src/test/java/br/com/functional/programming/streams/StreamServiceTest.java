package br.com.functional.programming.streams;

import br.com.functional.programming.dto.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static br.com.functional.programming.mock.PersonMock.*;

public class StreamServiceTest {

    private StreamService streamService;

    @Before
    public void init() {
        streamService = new StreamService();
    }

    @Test
    public void newerPersonSuccess() {

        Person personFound = streamService.getNewestPerson(PERSON_LIST_WITH_MIKE);

        Assert.assertNotNull(personFound);
        Assert.assertEquals(JOHN.getName(), personFound.getName());
        Assert.assertEquals(JOHN.getAge(), personFound.getAge());

    }

    @Test
    public void olderPersonSuccess() {

        Person personFound = streamService.getOlderPerson(PERSON_LIST_WITH_MIKE);

        Assert.assertNotNull(personFound);
        Assert.assertEquals(JULIE.getName(), personFound.getName());
        Assert.assertEquals(JULIE.getAge(), personFound.getAge());

    }

    @Test
    public void lowestAgeSuccess() {

        Integer age = streamService.getLowestAge(PERSON_LIST_WITH_MIKE);

        Assert.assertNotNull(age);
        Assert.assertEquals(JOHN.getAge(), age);

    }

    @Test
    public void highestAgeSuccess() {

        Integer age = streamService.getHighestAge(PERSON_LIST_WITH_MIKE);

        Assert.assertNotNull(age);
        Assert.assertEquals(JULIE.getAge(), age);

    }

    @Test
    public void peopleWithAgeHigherThanSuccess() {

        List<Person> list = streamService.getPeopleAgeHigherThan(PERSON_LIST_WITH_MIKE, 25);

        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(list.get(0).getName(), JULIE.getName());

    }

    @Test
    public void diffPersonListsSuccess() {

        List<Person> list = streamService.diffBetween(PERSON_LIST_WITH_MIKE, PERSON_LIST_WITHOUT_MIKE);

        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(list.get(0).getName(), MIKE.getName());

    }

    @Test
    public void interceptionPersonListsSuccess() {

        List<Person> list = streamService.interceptionBetween(PERSON_LIST_WITH_MIKE, PERSON_LIST_WITHOUT_MIKE);

        Assert.assertNotNull(list);
        Assert.assertEquals(PERSON_LIST_WITHOUT_MIKE.size(), list.size());
        Assert.assertEquals(list.get(0).getName(), NANCY.getName());
        Assert.assertEquals(list.get(1).getName(), JOHN.getName());
        Assert.assertEquals(list.get(2).getName(), JULIE.getName());

    }

    @Test
    public void findByNameStartingWithJSuccess() {

        List<Person> list = streamService.findByNameStartingWith(PERSON_LIST_WITH_MIKE, "J");

        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(list.get(0).getName(), JOHN.getName());
        Assert.assertEquals(list.get(1).getName(), JULIE.getName());

    }

    @Test
    public void getNamesSuccess() {

        List<String> list = streamService.getNames(PERSON_LIST_WITH_MIKE);

        Assert.assertNotNull(list);
        Assert.assertEquals(list.get(0), MIKE.getName());
        Assert.assertEquals(list.get(1), NANCY.getName());
        Assert.assertEquals(list.get(2), JOHN.getName());
        Assert.assertEquals(list.get(3), JULIE.getName());

    }

}
