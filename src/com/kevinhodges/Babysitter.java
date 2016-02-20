package com.kevinhodges;

public class Babysitter {

    int dayRate = 12;
    int bedRate = 8;
    int lateRate = 16;
    int maxShiftLength = 11;
    int minimumShiftLength = 1;

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
}
