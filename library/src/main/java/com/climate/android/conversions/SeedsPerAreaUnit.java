package com.climate.android.conversions;


public class SeedsPerAreaUnit {

    private SeedsPerAreaUnit() {}

    private static final double SEEDS_PER_ACRE_TO_SEEDS_PER_HECTARE = 2.47105;

    public static final Unit SEEDS_PER_AC = new SeedsPerAc();
    public static final Unit SEEDS_PER_HA = new SeedsPerHa();


    public interface Unit {
        double toSeedsPerAc(double value);
        double toSeedsPerHa(double value);
    }

    private static class SeedsPerAc implements Unit {

        @Override
        public double toSeedsPerAc(double value) {
            return value;
        }

        @Override
        public double toSeedsPerHa(double value) {
            return value * SEEDS_PER_ACRE_TO_SEEDS_PER_HECTARE;
        }
    }

    private static class SeedsPerHa implements Unit {

        @Override
        public double toSeedsPerAc(double value) {
            return value * 1/SEEDS_PER_ACRE_TO_SEEDS_PER_HECTARE;
        }

        @Override
        public double toSeedsPerHa(double value) {
            return value;
        }
    }

}