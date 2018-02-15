package com.climate.android.conversions;


public class SpeedUnit {

    private SpeedUnit() {}

    private static final double KNOTS_AS_KM_PER_HR = 1.852; // exact value
    private static final double CM_PER_IN = 2.54; // exact value
    private static final double FEET_PER_MI = 5280D; // exact value


    public static final Unit FEET_PER_SECOND = new FeetPerSecond();
    public static final Unit MILES_PER_HOUR = new Multiplier(FEET_PER_SECOND, FEET_PER_MI/60d/60d);
    public static final Unit METERS_PER_SECOND = new MetersPerSecond();
    public static final Unit KILOMETERS_PER_HOUR = new Multiplier(METERS_PER_SECOND, 1000d/60d/60d);
    public static final Unit KNOTS = new Knots();

    public interface Unit {
        double toFeetPerSecond(double value);
        double toMilesPerHour(double value);
        double toMetersPerSecond(double value);
        double toKilometersPerHour(double value);
        double toKnots(double value);
    }

    private static class FeetPerSecond implements Unit {
        @Override
        public double toMilesPerHour(double value) {
            return value * 60*60/FEET_PER_MI;
        }

        @Override
        public double toFeetPerSecond(double value) {
            return value;
        }

        @Override
        public double toMetersPerSecond(double value) {
            return value * 0.3048D; // exact
        }

        @Override
        public double toKilometersPerHour(double value) {
            return value * 1.09728;
        }

        @Override
        public double toKnots(double value) {
            return toKilometersPerHour(value) / KNOTS_AS_KM_PER_HR;
        }
    }

    private static class MetersPerSecond implements Unit {
        @Override
        public double toMilesPerHour(double value) {
            return toFeetPerSecond(value) * 60 * 60 / FEET_PER_MI;
        }

        @Override
        public double toFeetPerSecond(double value) {
            return value * 100 / CM_PER_IN / 12;
        }

        @Override
        public double toMetersPerSecond(double value) {
            return value;
        }

        @Override
        public double toKilometersPerHour(double value) {
            return value * 60 * 60 / 1000D;
        }

        @Override
        public double toKnots(double value) {
            return toKilometersPerHour(value) / KNOTS_AS_KM_PER_HR;
        }
    }

    private static class Knots implements Unit {
        @Override
        public double toMilesPerHour(double value) {
            return KILOMETERS_PER_HOUR.toMilesPerHour(toKilometersPerHour(value));
        }

        @Override
        public double toFeetPerSecond(double value) {
            return KILOMETERS_PER_HOUR.toFeetPerSecond(toKilometersPerHour(value));
        }

        @Override
        public double toMetersPerSecond(double value) {
            return value / 7.2D * 3.704D; // exact values. simplified math to avoid float errors
        }

        @Override
        public double toKilometersPerHour(double value) {
            return value * KNOTS_AS_KM_PER_HR;
        }

        @Override
        public double toKnots(double value) {
            return value;
        }
    }

    private static class Multiplier implements Unit {
        private Unit unit;
        private double multiplier;
        private Multiplier(Unit unit, double multiplier) {
            this.unit = unit;
            this.multiplier = multiplier;
        }


        @Override
        public double toFeetPerSecond(double value) {
            return unit.toFeetPerSecond(value * multiplier);
        }

        @Override
        public double toMilesPerHour(double value) {
            return unit.toMilesPerHour(value * multiplier);
        }

        @Override
        public double toMetersPerSecond(double value) {
            return unit.toMetersPerSecond(value * multiplier);
        }

        @Override
        public double toKilometersPerHour(double value) {
            return unit.toKilometersPerHour(value * multiplier);
        }

        @Override
        public double toKnots(double value) {
            return unit.toKnots(value * multiplier);
        }
    }

}