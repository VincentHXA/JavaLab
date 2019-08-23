package generics;

public class Test0 {

    public static <T> void printArray(T[] inputArray) {
        for(T element: inputArray) {
            System.out.printf("%s", element);
        }
    }

    public static void main(String[] args) {
        printArray(new String[]{"a", "b", "c"});
        printArray(new Integer[] {1, 2, 3});
    }
}
