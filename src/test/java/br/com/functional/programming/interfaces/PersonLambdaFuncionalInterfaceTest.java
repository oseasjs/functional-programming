package br.com.functional.programming.interfaces;

import br.com.functional.programming.dto.Person;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.functional.programming.mock.PersonMock.MIKE;
import static br.com.functional.programming.mock.PersonMock.PERSON_LIST_WITH_MIKE;

public class PersonLambdaFuncionalInterfaceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void isPersonNameUpperCaseSuccess() {

        String mikeNameInUpperCase = new PersonLambdaFunctionalInterface() {
            public String getPersonName(Person person) {
                return person.getName().toUpperCase();
            }
        }.getPersonName(MIKE);

        Assert.assertNotNull(mikeNameInUpperCase);
        Assert.assertEquals(MIKE.getName().toUpperCase(), mikeNameInUpperCase);

    }

    @Test
    public void isPersonNameLowerCaseSuccess() {

        String mikeNameInLowerCase = new PersonLambdaFunctionalInterface() {
            public String getPersonName(Person person) {
                return person.getName().toLowerCase();
            }
        }.getPersonName(MIKE);

        Assert.assertNotNull(mikeNameInLowerCase);
        Assert.assertEquals(MIKE.getName().toLowerCase(), mikeNameInLowerCase);

    }

    @Test
    public void isPersonNameUpperCaseLambdaSuccess() {

        PersonLambdaFunctionalInterface funcPersonNameUpperCase = (person) -> person.getName().toUpperCase();
        String mikeName = funcPersonNameUpperCase.getPersonName(MIKE);

        Assert.assertNotNull(mikeName);
        Assert.assertEquals(MIKE.getName().toUpperCase(), mikeName);

    }

    @Test
    public void isPersonNameLowerCaseLambdaSuccess() {

        PersonLambdaFunctionalInterface funcPersonNameUpperCase = (person) -> person.getName().toLowerCase();
        String mikeName = funcPersonNameUpperCase.getPersonName(MIKE);

        Assert.assertNotNull(mikeName);
        Assert.assertEquals(MIKE.getName().toLowerCase(), mikeName);

    }

    @Test
    public void isPersonNameUpperCaseFromListSuccess() {

        PersonLambdaFunctionalInterface funcPersonNameUpperCase = (person) -> person.getName().toUpperCase();

        List<String> personNameList = PERSON_LIST_WITH_MIKE
                .stream()
                .map(p -> funcPersonNameUpperCase.getPersonName(p))
                .collect(Collectors.toList());

        Assert.assertEquals(personNameList.get(0), PERSON_LIST_WITH_MIKE.get(0).getName().toUpperCase());
        Assert.assertEquals(personNameList.get(1), PERSON_LIST_WITH_MIKE.get(1).getName().toUpperCase());
        Assert.assertEquals(personNameList.get(2), PERSON_LIST_WITH_MIKE.get(2).getName().toUpperCase());
        Assert.assertEquals(personNameList.get(3), PERSON_LIST_WITH_MIKE.get(3).getName().toUpperCase());

    }

    @Test
    public void isPersonNameLowerCaseFromListSuccess() {

        PersonLambdaFunctionalInterface funcPersonNameUpperCase = (person) -> person.getName().toLowerCase();

        List<String> personNameList = PERSON_LIST_WITH_MIKE
                .stream()
                .map(p -> funcPersonNameUpperCase.getPersonName(p))
                .collect(Collectors.toList());

        Assert.assertEquals(personNameList.get(0), PERSON_LIST_WITH_MIKE.get(0).getName().toLowerCase());
        Assert.assertEquals(personNameList.get(1), PERSON_LIST_WITH_MIKE.get(1).getName().toLowerCase());
        Assert.assertEquals(personNameList.get(2), PERSON_LIST_WITH_MIKE.get(2).getName().toLowerCase());
        Assert.assertEquals(personNameList.get(3), PERSON_LIST_WITH_MIKE.get(3).getName().toLowerCase());

    }

    @Test
    public void isNickNameUpperCaseSuccess() {

        String nickNameUpperCase = PersonLambdaFunctionalInterface.nickPersonToUpperCase.get();
        Assert.assertNotNull(PersonLambdaFunctionalInterface.ADHOC_NICK.getName(), nickNameUpperCase);

    }

    @Test
    public void isCheckPersonSuccess() {
        PersonLambdaFunctionalInterface.checkPerson.accept(MIKE);
        Assert.assertTrue(Boolean.TRUE);
    }

    @Test
    public void isCheckPersonNullSuccess() {
        expectedException.expectMessage(Person.NOT_FOUND_MESSAGE);
        expectedException.expect(RuntimeException.class);

        PersonLambdaFunctionalInterface.checkPerson.accept(null);
        Assert.fail("Check person null accept not expected");
    }

    @Test
    public void isMikeNameUpperCaseSuccess() {
        String mikeNameUpperCase = PersonLambdaFunctionalInterface.personNameUpperCase.apply(MIKE);
        Assert.assertNotNull(MIKE.getName(), mikeNameUpperCase);
    }

    @Test
    public void isMikeNameComplementedSuccess() {
        String nameComplement = " Test";
        String mikeNameComplete = PersonLambdaFunctionalInterface.personNameComplement.apply(MIKE, nameComplement);
        Assert.assertNotEquals(MIKE.getName(), mikeNameComplete);
        Assert.assertNotNull(MIKE.getName().concat(nameComplement), mikeNameComplete);
    }

}
