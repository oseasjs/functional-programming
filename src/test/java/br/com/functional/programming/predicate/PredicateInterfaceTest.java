package br.com.functional.programming.predicate;

import br.com.functional.programming.dto.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.functional.programming.mock.PersonMock.*;
import static br.com.functional.programming.predicate.PredicateInterface.*;

public class PredicateInterfaceTest {

    @Test
    public void shouldPersonWithNameNameStartingWithJValidStaticSuccess() {

        List<Person> list = PERSON_LIST_WITH_MIKE
                .stream()
                .filter(p -> PredicateInterface.isNameStartWithJValid(p.getName()))
                .collect(Collectors.toList());;

        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(list.get(0).getName(), JULIE.getName());

    }

    @Test
    public void shouldPersonWithNameStartingWithJValidSuccess() {

        List<Person> list = PERSON_LIST_WITH_MIKE
                .stream()
                .filter(p -> isNameStartingWithJ
                    .and(isNameLengthHigherThan4)
                    .test(p.getName()))
                .collect(Collectors.toList());

        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(list.get(0).getName(), JULIE.getName());

    }

    @Test
    public void shouldPeopleAdultsByAgeSuccess() {

        List<Person> list = PERSON_LIST_WITH_MIKE
                .stream()
                .filter(p -> isAnAdult.test(p.getAge()))
                .collect(Collectors.toList());;

        Assert.assertNotNull(list);
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(list.get(0).getName(), MIKE.getName());
        Assert.assertEquals(list.get(1).getName(), NANCY.getName());
        Assert.assertEquals(list.get(2).getName(), JULIE.getName());

    }

    @Test
    public void shouldPeopleAdultsSuccess() {

        List<Person> list = PERSON_LIST_WITH_MIKE
                .stream()
                .filter(isPersonAnAdult)
                .collect(Collectors.toList());;

        Assert.assertNotNull(list);
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(list.get(0).getName(), MIKE.getName());
        Assert.assertEquals(list.get(1).getName(), NANCY.getName());
        Assert.assertEquals(list.get(2).getName(), JULIE.getName());

    }

    @Test
    public void shouldPeopleAdultsAndNameStartingWithJSuccess() {

        List<Person> list = PERSON_LIST_WITH_MIKE
                .stream()
                .filter(isPersonAnAdultAndNameStartingWithJ)
                .collect(Collectors.toList());;

        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(list.get(0).getName(), JULIE.getName());

    }

}
