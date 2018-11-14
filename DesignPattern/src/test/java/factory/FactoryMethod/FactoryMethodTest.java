package factory.FactoryMethod;

import org.junit.Test;
import patterns.factory.FactoryMethod.Building;
import patterns.factory.FactoryMethod.Hospital;
import patterns.factory.FactoryMethod.School;

public class FactoryMethodTest {

    @Test
    public void test() {
        Building school = new School();
        school.activity();

        Building hospital = new Hospital();
        hospital.activity();
    }
}
