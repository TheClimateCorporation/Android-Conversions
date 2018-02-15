package com.climate.android.conversions;


public class AreaUnit {

    private AreaUnit() {}

    public static final Unit SQ_INCHES = new SqInches();
    public static final Unit SQ_FEET = new Multiplier(SQ_INCHES, 144);
    public static final Unit SQ_YARDS = new Multiplier(SQ_INCHES, 1296);
    public static final Unit SQ_MILES = new SqMiles();
    public static final Unit ACRES = new Multiplier(SQ_MILES, 1/640D);
    public static final Unit SQ_METERS = new SqMeters();
    public static final Unit SQ_KILOMETERS = new Multiplier(SQ_METERS, 1e+6);
    public static final Unit HECTARES = new Multiplier(SQ_METERS, 1e+4);

    private static final double ACRES_TO_HECTARES = 0.404686; // constant from climate


    public interface Unit {
        double toAcres(double value);
        double toHectares(double value);
        double toSquareInches(double value);
        double toSquareFeet(double value);
        double toSquareYards(double value);
        double toSquareMiles(double value);
        double toSquareMeters(double value);
        double toSquareKilometers(double value);
    }

    private static class SqInches implements Unit {
        @Override
        public double toAcres(double value) { return toSquareFeet(value) / 43560D; }

        @Override
        public double toHectares(double value) {
            return toSquareFeet(value) / 107639;
        }

        @Override
        public double toSquareInches(double value) { return value; }

        @Override
        public double toSquareFeet(double value) { return value / 144f; }

        @Override
        public double toSquareYards(double value) { return value / 1296f; }

        @Override
        public double toSquareMiles(double value) { return toSquareFeet(value) / 27878400; }

        @Override
        public double toSquareMeters(double value) { return value / 1550; }

        @Override
        public double toSquareKilometers(double value) { return value / (10000000000L / 6.4516D); }
    }

    private static class SqMiles implements Unit {
        @Override
        public double toAcres(double value) { return value * 640; }

        @Override
        public double toHectares(double value) {
            return toAcres(value) * ACRES_TO_HECTARES;
        }

        @Override
        public double toSquareInches(double value) { return Math.pow(5280*12, 2) * value; }

        @Override
        public double toSquareFeet(double value) { return Math.pow(5280, 2) * value; }

        @Override
        public double toSquareYards(double value) { return Math.pow(1760, 2) * value; }

        @Override
        public double toSquareMiles(double value) { return value; }

        @Override
        public double toSquareMeters(double value) { return toSquareKilometers(value) * 1e+6;  }

        @Override
        public double toSquareKilometers(double value) { return Math.pow(1.609344, 2) * value; }
    }

    private static class SqMeters implements Unit {
        @Override
        public double toAcres(double value) { return toHectares(value) / ACRES_TO_HECTARES; }

        @Override
        public double toHectares(double value) {
            return value * 1e-4;
        }

        @Override
        public double toSquareInches(double value) { return toSquareFeet(value) * 144D; }

        @Override
        public double toSquareFeet(double value) { return value / Math.pow(0.3048, 2); }

        @Override
        public double toSquareYards(double value) { return toSquareFeet(value) / 9D; }

        @Override
        public double toSquareMiles(double value) { return toAcres(value) / 640D; }

        @Override
        public double toSquareMeters(double value) { return value; }

        @Override
        public double toSquareKilometers(double value) { return value * 1e-6; }
    }

    private static class Multiplier implements Unit {
        private Unit unit;
        private double multiplier;
        private Multiplier(Unit unit, double multiplier) {
            this.unit = unit;
            this.multiplier = multiplier;
        }

        @Override
        public double toAcres(double value) {
            return unit.toAcres(value * multiplier);
        }

        @Override
        public double toHectares(double value) {
            return unit.toHectares(value * multiplier);
        }

        @Override
        public double toSquareInches(double value) {
            return unit.toSquareInches(value * multiplier);
        }

        @Override
        public double toSquareFeet(double value) {
            return unit.toSquareFeet(value * multiplier);
        }

        @Override
        public double toSquareYards(double value) {
            return unit.toSquareYards(value * multiplier);
        }

        @Override
        public double toSquareMiles(double value) {
            return unit.toSquareMiles(value * multiplier);
        }

        @Override
        public double toSquareMeters(double value) {
            return unit.toSquareMeters(value * multiplier);
        }

        @Override
        public double toSquareKilometers(double value) {
            return unit.toSquareKilometers(value * multiplier);
        }
    }

}
