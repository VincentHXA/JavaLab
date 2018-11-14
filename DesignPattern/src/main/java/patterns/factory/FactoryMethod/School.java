package patterns.factory.FactoryMethod;

import patterns.factory.model.Person;

public class School extends Building {

    @Override
    protected Person createPerson() {
        return new Person("student", "xiao ming", 15);
    }
}
