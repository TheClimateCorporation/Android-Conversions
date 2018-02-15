package com.climate.android.conversions;

// TODO: implement this at some point when needed
public class VolumeUnit {

    private static final double LITER_TO_GALLON = 0.26417205235815;


    private VolumeUnit() {}

    public static final Unit LITERS = new Liters();
    public static final Unit US_GALLONS = new USGallons();


    public interface Unit {
        double toLiters(double value);
        double toUSGallons(double value);
    }

    public static class Liters implements Unit {

        @Override
        public double toLiters(double value) {
            return value;
        }

        @Override
        public double toUSGallons(double value) {
            return value * LITER_TO_GALLON;
        }
    }

    public static class USGallons implements Unit {

        @Override
        public double toLiters(double value) {
            return value / LITER_TO_GALLON;
        }

        @Override
        public double toUSGallons(double value) {
            return value;
        }
    }


}