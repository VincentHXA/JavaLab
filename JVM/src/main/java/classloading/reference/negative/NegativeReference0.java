package classloading.reference.negative;

//被动引用1 – 子类引用父类的的静态字段，不会导致子类初始化

public class NegativeReference0 {
    public static class Parent {
        public static String name = "Parent";
        static {
            System.out.println(Parent.class.getSimpleName() + " is referred!");
        }
    }

    public static class Child extends Parent {
        static {
            System.out.println(Child.class.getSimpleName() + " is referred!");
        }
    }

    public static void main(String[] args) {
        System.out.println(Child.name);
    }
}

