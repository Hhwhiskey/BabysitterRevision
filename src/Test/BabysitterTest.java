package Test;
import com.kevinhodges.Babysitter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BabysitterTest {

    private Babysitter babysitter;

    @Before
    public void setUp() {
        babysitter = new Babysitter();
    }

    @Test
    public void testDayRate() {
        int result = babysitter.getDayRate();
        assertEquals(12, result);
    }

    @Test
    public void testBedRate() {
        int result = babysitter.getBedRate();
        assertEquals(8, result);
    }

    @Test
    public void testLateRate() {
        int result = babysitter.getLateRate();
        assertEquals(16, result);
    }

    @Test
    public void testMaxShiftLength() {
        int result = babysitter.getMaxShiftLength();
        assertEquals(11, result);
    }

    @Test public void testMinimumShiftLength() {
        int result = babysitter.getMinimumShiftLength();
        assertEquals(1, result);
    }

    @Test public void testMaximumPayout() {

        // Daily max payout should not exceed $148
        // Which is 7 hours of day rate + 4 hours of late rate
        // with no bed time
        
        int maxPayout = 148;

        int result = babysitter.getMaxPayout();
        assertTrue(result <= maxPayout);
    }
}


