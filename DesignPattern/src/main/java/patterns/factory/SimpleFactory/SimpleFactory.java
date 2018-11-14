package patterns.factory.SimpleFactory;

import patterns.factory.model.Person;

public class SimpleFactory {

    public static Person createPerson() {
        return new Person("male", "vincent", 24);
    }

    public static Person createPerson(String type) {
        if(type.equalsIgnoreCase("child")) {
            return createChild();
        }else if(type.equalsIgnoreCase("male")) {
            return createMale();
        }else if(type.equalsIgnoreCase("female")) {
            return createFemale();
        }else{
            return null;
        }
    }

    private static Person createChild() {
        return new Person("child", "david", 12);
    }

    private static Person createMale() {
        return new Person("male", "vincent", 24);
    }

    private static Person createFemale() {
        return new Person("female", "isabelle", 20);
    }
}
