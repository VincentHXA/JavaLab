package classloading.reference.negative;

//被动引用3 – 访问类定义的常量，不会触发此类的初始化

public class NegativeReference2 {
    public static class Child {
        public static final String name = "Child";
        static {
            System.out.println(Child.class.getSimpleName() + " is referred!");
        }
    }

    public static void main(String[] args) {
        System.out.println(Child.name);
    }
}

