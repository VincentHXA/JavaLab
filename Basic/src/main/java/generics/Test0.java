package generics;

public class Test0 {

    public static <E> void printArray(E[] inputArray) {
        for(E element: inputArray) {
            System.out.printf("%s", element);
        }
    }

    public static void main(String[] args) {
        printArray(new String[]{"a", "b", "c"});
        printArray(new Integer[] {1, 2, 3});
    }
}
