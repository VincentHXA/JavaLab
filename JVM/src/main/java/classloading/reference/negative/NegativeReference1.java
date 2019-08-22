package classloading.reference.negative;

//被动引用2 – 定义类的数组引用而不赋值，不会触发此类的初始化

public class NegativeReference1 {
    public static class Child {
        static {
            System.out.println(Child.class.getSimpleName() + " is referred!");
        }
    }

    public static void main(String[] args) {
        Child[] childs = new Child[10];
    }
}

