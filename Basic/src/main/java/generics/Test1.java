package generics;

public class Test1 {

    public static void main(String[] args) {
        Box<String> box = new Box<String>();
        box.add("hello");
        System.out.println(box.get());

        Box<Integer> box1 = new Box<Integer>();
        box1.add(123);
        System.out.println(box1.get());
    }

}
