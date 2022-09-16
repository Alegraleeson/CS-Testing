
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

public class MissingNumberTest {
    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSix = { 1, 2, 3, 4, 5, 7, 8, 9, 10 };
    private int[] missingOne = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private MissingNumber mn = new MissingNumber();

    @Test
    public void testMissingNumber_MissingMax() {
        assertEquals(10, mn.missingNumber(missingMax, 10));
    }

    @Test
    public void testMissingNumber_NoneMissing() {
        assertEquals(0, mn.missingNumber(missingNone, 10));
    }

    @Test
    public void testMissingNumber_MissingSix() {
        assertEquals(6, mn.missingNumber(missingSix, 10));
    }

    @Test
    public void testMissingNumber_MissingOne() {
        assertEquals(1, mn.missingNumber(missingOne, 10));
    }


}