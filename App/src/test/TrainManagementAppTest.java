package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

public class TrainManagementAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    void testGroupingSize() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 56)
        );
        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertEquals(2, grouped.size());
    }

    @Test
    void testSleeperGrouping() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );
        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testSingleType() {

        List<Bogie> bogies = List.of(
                new Bogie("First Class", 24)
        );
        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertEquals(1, grouped.size());
    }

    @Test
    void testEmptyList() {
        List<Bogie> bogies = List.of();
        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.isEmpty());
    }

    @Test
    void testMultipleTypes() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("Cargo", 120)
        );
        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertEquals(3, grouped.size());
    }

    @Test
    void testValuesExist() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72)
        );
        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.containsKey("Sleeper"));
    }

    @Test
    void testCapacityValues() {
        List<Bogie> bogies = List.of(
                new Bogie("AC Chair", 56),
                new Bogie("AC Chair", 60)
        );
        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testOriginalListUnchanged() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72)
        );
        int originalSize = bogies.size();
        bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertEquals(originalSize, bogies.size());
    }
}