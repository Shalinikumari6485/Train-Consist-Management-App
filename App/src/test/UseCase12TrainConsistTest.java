package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UseCase12TrainConsistTest {
    static class GoodsBogie {
        String type;
        String cargo;
        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Grain")
        );
        boolean isSafe = bogies.stream()
                .allMatch(g ->
                        !(g.type.equals("Cylindrical") && !g.cargo.equals("Petroleum"))
                );
        assertTrue(isSafe);
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {

        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );
        boolean isSafe = bogies.stream()
                .allMatch(g ->
                        !(g.type.equals("Cylindrical") && !g.cargo.equals("Petroleum"))
                );
        assertFalse(isSafe);
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {

        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        boolean isSafe = bogies.stream()
                .allMatch(g ->
                        !(g.type.equals("Cylindrical") && !g.cargo.equals("Petroleum"))
                );
        assertTrue(isSafe);
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal") // invalid
        );
        boolean isSafe = bogies.stream()
                .allMatch(g ->
                        !(g.type.equals("Cylindrical") && !g.cargo.equals("Petroleum"))
                );
        assertFalse(isSafe);
    }

    @Test
    void testSafety_EmptyBogieList() {

        List<GoodsBogie> bogies = List.of();
        boolean isSafe = bogies.stream().allMatch(g -> !(g.type.equals("Cylindrical") && !g.cargo.equals("Petroleum")));

        assertTrue(isSafe);
    }
}

