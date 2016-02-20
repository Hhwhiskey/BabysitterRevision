package com.kevinhodges;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Babysitter {

    public static int dayRate = 12;
    public static int bedRate = 8;
    public static int lateRate = 16;
    public static int maxShiftLength = 11;
    public static int minimumShiftLength = 1;

    public static void main(String[] args) {
    }

    public int getDayRate() {
        return dayRate;
    }

    public int getBedRate() {
        return bedRate;
    }

    public int getLateRate() {
        return lateRate;
    }

    public int getMaxShiftLength() {
        return maxShiftLength;
    }

    public int getMinimumShiftLength() {
        return minimumShiftLength;
    }

    // Get max possible payout assuming a full shift with no bedtime(Meddling kids!)
    public int getMaximumPayout() {
        int maxDayHours = 7;
        int maxLateHours = 4;

        int maxDayPay = maxDayHours * dayRate;
        int maxLatePay = maxLateHours * lateRate;

        return maxDayPay + maxLatePay;

    }

    // Get minimum possible payout assuming 1 hour during bedtime
    // Payout should never be below this value
    public int getMinimumPayout() {
        int minBedHours = 1;

        return minBedHours * bedRate;
    }

    // This method will return the length of shift in rounded hours
    // after receiving two Calendar objects, shiftStartDate and shiftEndDate
    public int calculateShiftLength(Calendar shiftStartDate, Calendar shiftEndDate) {

        // Create calendar date with time of 1700 on feb 19th
        shiftStartDate.set(Calendar.YEAR, 2016);
        shiftStartDate.set(Calendar.MONTH, 2);
        shiftStartDate.set(Calendar.DATE, 19);
        shiftStartDate.set(Calendar.HOUR_OF_DAY, 17);

        // Convert shiftStartDate to millis
        long startingTime = shiftStartDate.getTimeInMillis();

        // Create calendar date with time of 0300 on feb 20th
        shiftEndDate.set(Calendar.YEAR, 2016);
        shiftEndDate.set(Calendar.MONTH, 2);
        shiftEndDate.set(Calendar.DATE, 20);
        shiftEndDate.set(Calendar.HOUR_OF_DAY, 3);

        // Convert shiftEndDate to millis
        long quittingTime = shiftEndDate.getTimeInMillis();

        // Subtract the starting time from quitting time to get the
        // length of the shift in millis
        long shiftLength = quittingTime - startingTime;

        // Convert the millis time to hours, rounded up to the hour.
        int shiftLengthHours = (int) TimeUnit.MILLISECONDS.toHours(shiftLength);

        return shiftLengthHours;
    }
}
