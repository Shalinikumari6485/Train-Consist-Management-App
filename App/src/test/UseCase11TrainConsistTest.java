package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

public class UseCase11TrainConsistTest {

    String trainPattern = "TRN-\\d{4}";
    String cargoPattern = "[A-Z]{3}-[A-Z]{2}";

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Pattern.matches(trainPattern, "TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Pattern.matches(trainPattern, "TRN-123"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Pattern.matches(cargoPattern, "PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Pattern.matches(cargoPattern, "pet-ab"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Pattern.matches(trainPattern, "TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Pattern.matches(cargoPattern, "Pet-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Pattern.matches(trainPattern, ""));
        assertFalse(Pattern.matches(cargoPattern, ""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertTrue(Pattern.matches(trainPattern, "TRN-6524"));
        assertTrue(Pattern.matches(cargoPattern, "PET-FH"));
    }
}

