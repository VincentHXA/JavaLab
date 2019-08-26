package sorting;

import org.junit.Before;
import org.junit.Test;
import searching.BinarySearch;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private int[] inputs;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void binarySearch() {
        inputs = new int[]{-7, 0, 1, 2, 2, 3, 5, 11, 333};
        assertEquals(5, BinarySearch.binarySearch(inputs, 3));
        assertEquals(4, BinarySearch.binarySearch(inputs, 2));
        assertEquals(8, BinarySearch.binarySearch(inputs, 333));
        assertEquals(0, BinarySearch.binarySearch(inputs, -7));
    }


}