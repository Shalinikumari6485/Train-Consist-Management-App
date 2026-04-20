package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class UseCase13TrainConsistTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    @Test
    void testLoopFilteringLogic() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 56)
        );

        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 56)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {

        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC", 56)
        );

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
        }

        long start = System.nanoTime();
        bogies.stream().filter(b -> b.capacity > 60).toList();
        long end = System.nanoTime();

        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
        }

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(10000, result.size());
    }
}