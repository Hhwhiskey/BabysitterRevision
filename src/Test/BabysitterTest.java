package Test;
import com.kevinhodges.Babysitter;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

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

    @Test
    public void testMinimumShiftLength() {
        int result = babysitter.getMinimumShiftLength();
        assertEquals(1, result);
    }

    @Test
    public void testMaximumPayout() {

        // Daily max payout should not exceed $148
        // Which is 7 hours of day rate + 4 hours of late rate
        // with no bed time

        int maxPayout = 148;

        int result = babysitter.getMaximumPayout();
        assertTrue(result <= maxPayout);
    }

    @Test
    public void textMinimumPayout() {

        // Daily min payout
        // 1 hour of bedtime pay

        int minimumPayout = 8;

        int result = babysitter.getMinimumPayout();
        assertTrue(result >= minimumPayout);
    }

    @Test
    public void testCalculateShiftLength() {

        // This test should return a shift length of 10 hours

        // Set calendar object to time of 1700 on feb 19th
        Calendar shiftStartDate = Calendar.getInstance();
        shiftStartDate.set(Calendar.YEAR, 2016);
        shiftStartDate.set(Calendar.MONTH, 2);
        shiftStartDate.set(Calendar.DATE, 19);
        shiftStartDate.set(Calendar.HOUR_OF_DAY, 17);

        // Set calendar object to time of 0300 on feb 20th
        Calendar shiftEndDate = Calendar.getInstance();
        shiftEndDate.set(Calendar.YEAR, 2016);
        shiftEndDate.set(Calendar.MONTH, 2);
        shiftEndDate.set(Calendar.DATE, 20);
        shiftEndDate.set(Calendar.HOUR_OF_DAY, 3);

        int result = babysitter.calculateShiftLength(shiftStartDate, shiftEndDate);
        assertEquals(10, result);
    }
}


