package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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
    void testFilter_CapacityGreaterThanThreshold() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("General", 90)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 60),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity >= 60)
                .collect(Collectors.toList());

        assertEquals(1, result.size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {

        List<Bogie> bogies = List.of(
                new Bogie("First Class", 24),
                new Bogie("AC Chair", 56)
        );
        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity < 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("General", 90),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {

        List<Bogie> bogies = List.of(
                new Bogie("First Class", 24),
                new Bogie("AC Chair", 56)
        );
        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("General", 90)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {

        List<Bogie> bogies = List.of();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );

        int originalSize = bogies.size();

        bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(originalSize, bogies.size());
    }
}