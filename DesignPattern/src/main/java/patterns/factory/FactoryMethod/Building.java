package patterns.factory.FactoryMethod;

import patterns.factory.model.Person;

public abstract class Building {

    public void activity(){
        Person person = createPerson();
        System.out.println(person.toString());
    }

    protected abstract Person createPerson();
}
