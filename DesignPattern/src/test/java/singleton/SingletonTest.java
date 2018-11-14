package singleton;

import org.junit.Assert;
import org.junit.Test;
import patterns.singleton.Singleton;

public class SingletonTest {

    @Test
    public void test() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Assert.assertEquals(singleton1, singleton2);
    }
}
