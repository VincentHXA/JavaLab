package classloading.reference.dynamic;

public class OptimisticReference3 {
    public static class Child {
        protected static String name;
        static {
            System.out.println(Child.class.getSimpleName() + " is referred!");
        }
    }

    public static void main(String[] args) {
        Child.name = "Child";
    }
}

