package br.com.functional.programming.interfaces;

import br.com.functional.programming.dto.Person;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static br.com.functional.programming.mock.PersonMock.MIKE;

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
    public void isNickNameUpperCaseSuccess() {

        String nickNameUpperCase = PersonLambdaFunctionalInterface.nickPersonToUpperCase.get();
        Assert.assertNotNull(PersonLambdaFunctionalInterface.NICK.getName(), nickNameUpperCase);

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
    public void isMikeNameComplementSuccess() {
        String nameComplement = " Test";
        String mikeNameComplete = PersonLambdaFunctionalInterface.personNameComplement.apply(MIKE, nameComplement);
        Assert.assertNotEquals(MIKE.getName(), mikeNameComplete);
        Assert.assertNotNull(MIKE.getName().concat(nameComplement), mikeNameComplete);
    }

}
