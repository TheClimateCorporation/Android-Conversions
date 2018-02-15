package com.climate.android.conversions;


public class LengthUnit {

    private LengthUnit() {}

    public static final Unit MILLIMETERS = new Millimeters();
    public static final Unit CENTIMETERS = new Multiplier(MILLIMETERS, 10);
    public static final Unit METERS = new Multiplier(MILLIMETERS, 1000f);
    public static final Unit KILOMETERS = new Multiplier(MILLIMETERS, 1e+6D);

    public static final Unit INCHES = new Inches();
    public static final Unit FEET = new Multiplier(INCHES, 12);
    public static final Unit YARDS = new Multiplier(INCHES, 36);
    public static final Unit MILES = new Multiplier(INCHES, 63360f) {
        @Override
        public double toMeters(double value) {
            return value * 1609.344; // floating precision errors. do this one directly
        }
    };

    public interface Unit {
        double toMillis(double value);
        double toCentis(double value);
        double toMeters(double value);
        double toKilometers(double value);
        double toInches(double value);
        double toFeet(double value);
        double toYards(double value);
        double toMiles(double value);
    }

    private static class Millimeters implements Unit {

        @Override
        public double toMillis(double value) {
            return value;
        }

        @Override
        public double toCentis(double value) {
            return value/10;
        }

        @Override
        public double toMeters(double value) {
            return value/1000;
        }

        @Override
        public double toKilometers(double value) {
            return value/1000000;
        }

        @Override
        public double toInches(double value) {
            return toCentis(value)/2.54;
        }

        @Override
        public double toFeet(double value) {
            return toInches(value)/12;
        }

        @Override
        public double toYards(double value) {
            return toFeet(value)/3f;
        }

        @Override
        public double toMiles(double value) {
            return toFeet(value)/5280f;
        }
    }

    private static class Inches implements Unit {

        @Override
        public double toMillis(double value) {
            return value * 25.4;
        }

        @Override
        public double toCentis(double value) {
            return value * 2.54;
        }

        @Override
        public double toMeters(double value) {
            return value * 0.0254;
        }

        @Override
        public double toKilometers(double value) {
            return value * 0.0000254;
        }

        @Override
        public double toInches(double value) {
            return value;
        }

        @Override
        public double toFeet(double value) {
            return value / 12f;
        }

        @Override
        public double toYards(double value) {
            return value / 36f;
        }

        @Override
        public double toMiles(double value) {
            return value / 63360f;
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
        public double toMillis(double value) {
            return unit.toMillis(value*multiplier);
        }

        @Override
        public double toCentis(double value) {
            return unit.toCentis(value*multiplier);
        }

        @Override
        public double toMeters(double value) {
            return unit.toMeters(value*multiplier);
        }

        @Override
        public double toKilometers(double value) {
            return unit.toKilometers(value*multiplier);
        }

        @Override
        public double toInches(double value) {
            return unit.toInches(value*multiplier);
        }

        @Override
        public double toFeet(double value) {
            return unit.toFeet(value*multiplier);
        }

        @Override
        public double toYards(double value) {
            return unit.toYards(value*multiplier);
        }

        @Override
        public double toMiles(double value) {
            return unit.toMiles(value*multiplier);
        }
    }



}
