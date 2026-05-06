package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class UseCase17TrainConsistTest {

    String[] sort(String[] arr) {
        String[] a = arr.clone();
        Arrays.sort(a);
        return a;
    }

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        assertArrayEquals(expected, sort(input));
    }

    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        assertArrayEquals(expected, sort(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        assertArrayEquals(expected, sort(input));
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        assertArrayEquals(expected, sort(input));
    }

    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, sort(input));
    }
}
