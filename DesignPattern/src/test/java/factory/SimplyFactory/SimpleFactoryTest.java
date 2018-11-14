package factory.SimplyFactory;

import org.junit.Assert;
import org.junit.Test;
import patterns.factory.SimpleFactory.SimpleFactory;

public class SimpleFactoryTest {

    @Test
    public void test() {
        Assert.assertEquals(SimpleFactory.createPerson().getType(), "male");

        Assert.assertEquals(SimpleFactory.createPerson("child").getType(), "child");
        Assert.assertEquals(SimpleFactory.createPerson("male").getType(), "male");
        Assert.assertEquals(SimpleFactory.createPerson("female").getType(), "female");
    }
}
