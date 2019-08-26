package sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortingTest {
    private int[] inputs;

    @Before
    public void setUp() throws Exception {
        inputs = new int[] {-4, 0, 2, 2, 3, 3, 78, 6, 123, -4444, 3231141};

    }

    @Test
    public void bubbleSort() {
        Sorting.bubbleSort(inputs);
        Arrays.stream(inputs).forEach(System.out::println);
    }

    @Test
    public void insertSort() {
        Sorting.insertSort(inputs);
        Arrays.stream(inputs).forEach(System.out::println);
    }

    @Test
    public void quickSort() {
        Sorting.quickSort(inputs, 0, inputs.length - 1);
        Arrays.stream(inputs).forEach(System.out::println);
    }

    @Test
    public void shellSort() {
        Sorting.shellSort(inputs);
        Arrays.stream(inputs).forEach(System.out::println);
    }
}