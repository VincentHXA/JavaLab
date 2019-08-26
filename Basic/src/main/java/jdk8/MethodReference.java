package jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 */
public class MethodReference {

    public static void main(String[] args) {
        Cat cat1 = new Cat("yy1", 1);
        Cat cat2 = new Cat("yy2", 2);
        Cat cat3 = new Cat("yy3", 3);
        Cat cat4 = new Cat("yy4", 4);

        List<Cat> cats = Arrays.asList(cat1, cat2, cat3, cat4);

        // lambda
        cats.sort(
                (catA, catB) -> Cat.compareByAge(catA, catB)
        );

        // 引用静态方法 ContainingClass::staticMethodName
        cats.forEach(System.out::println);

        //引用某个对象的实例方法
        cats.sort(CatComparator::compareByAge);
        cats.forEach(System.out::println);

        //引用某个类型的任意对象的实例方法
        cats.sort(Cat::compareAge);
        cats.forEach(System.out::println);

        //引用构造方法
        System.out.println(MethodReference.toString(String::new));
    }

    public static String toString(Supplier<String> supplier) {
        return supplier.get() + " test";
    }

    private static class Cat {
        private String name;
        private int age;

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public static int compareByAge(Cat cat1, Cat cat2) {
            return cat1.age - cat2.age;
        }

        public int compareAge(Cat cat) {
            return this.age - cat.age;
        }
    }

    private static class CatComparator {

        public static int compareByAge(Cat cat, Cat other) {
            return Cat.compareByAge(cat, other);
        }
    }
}
