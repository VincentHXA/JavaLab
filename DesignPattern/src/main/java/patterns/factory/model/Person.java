package patterns.factory.model;

public class Person {

    private String type;
    private String name;
    private Integer age;

    public Person(String type, String name, Integer age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
