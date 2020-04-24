package br.com.functional.programming.suppliers;

import br.com.functional.programming.dto.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SupplierInterfaceTest {

    @Test
    public void isPersonListSupplierSuccess() {

        List<Person> list = SupplierInterface.adhocPersonList.get();

        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(list.get(0).getName(), SupplierInterface.MATT_NAME);
        Assert.assertNotEquals(list.get(1).getName(), SupplierInterface.MATT_NAME);

    }

    @Test
    public void isMattPersonListSupplierSuccess() {

        Person matt = SupplierInterface.mattFromAdhocPersonList.get();

        Assert.assertNotNull(matt);
        Assert.assertEquals(matt.getName(), SupplierInterface.MATT_NAME);

    }

}
