package generics;


import java.util.ArrayList;
import java.util.List;

public class Test2 {

    private static class People {

        public String getSelf() {
            return this.getClass().toString();
        }
    }

    private static class Student extends People {

    }

    private static class Teacher extends People {

    }

    public static void printArray(List<? extends People> inputArray) {
        for(People element: inputArray) {
            System.out.printf("%s\n", element.getSelf());
        }
    }

    public static void main(String[] args) {
        printArray(new ArrayList<Student>() {{
            add(new Student());
            add(new Student());
            add(new Student());
            add(new Student());
        }});

        printArray(new ArrayList<Teacher>() {{
            add(new Teacher());
            add(new Teacher());
            add(new Teacher());
            add(new Teacher());
        }});

    }
}
