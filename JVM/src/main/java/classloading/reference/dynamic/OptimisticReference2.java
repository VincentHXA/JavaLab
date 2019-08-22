package classloading.reference.dynamic;

public class OptimisticReference2 {
    public static class Child {
        protected static String name;
        static {
            System.out.println(Child.class.getSimpleName() + " is referred!");
            name = "Child";
        }
    }

    public static void main(String[] args) {
        System.out.println(Child.name);
    }
}

