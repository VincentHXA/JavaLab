package patterns.factory.FactoryMethod;

import patterns.factory.model.Person;

public class Hospital extends Building{

    @Override
    protected Person createPerson() {
        return new Person("patient", "david", 40);
    }
}
