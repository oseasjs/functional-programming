package br.com.functional.programming.optionals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static br.com.functional.programming.mock.PersonMock.MIKE;

public class OptionalServiceTest {

    private OptionalService optionalService;

    @Before
    public void init() {
        optionalService = new OptionalService();
    }

    @Test
    public void getPersonNameSuccess() {

        String name = optionalService.getPersonName(Optional.of(MIKE));

        Assert.assertNotNull(name);
        Assert.assertEquals(MIKE.getName(), name);

    }

    @Test(expected = RuntimeException.class)
    public void getPersonNameEmptyFailed() {

        optionalService.getPersonName(Optional.empty());
        Assert.fail("Test success is not expected");

    }

    @Test
    public void getPersonNameNullableSuccess() {

        String name = optionalService.getPersonNameOrEmptyString(Optional.of(MIKE));

        Assert.assertNotNull(name);
        Assert.assertEquals(MIKE.getName(), name);

    }

    @Test
    public void getPersonNameNullableNullSuccess() {

        String name = optionalService.getPersonNameOrEmptyString(Optional.empty());
        Assert.assertNull(name);

    }

}
