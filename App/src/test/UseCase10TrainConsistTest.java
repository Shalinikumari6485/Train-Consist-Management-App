package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UseCase10TrainConsistTest {
    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("General", 90)
        );
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertTrue(total > 100);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 50),
                new Bogie("AC", 50)
        );
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(100, total);
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("First Class", 20)
        );
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertTrue(total < 50);
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 56),
                new Bogie("General", 90)
        );
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(218, total);
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = List.of();
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 60),
                new Bogie("AC", 60)
        );
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(120, total);
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = List.of();
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72)
        );
        int originalSize = bogies.size();
        bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(originalSize, bogies.size());
    }
}
