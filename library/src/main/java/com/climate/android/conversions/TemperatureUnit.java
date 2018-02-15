package com.climate.android.conversions;


public class TemperatureUnit {

    private TemperatureUnit() {}

    private static final double K_OFFSET = 273.15;

    public static final Unit F = new F();
    public static final Unit C = new C();
    public static final Unit K = new K();


    public interface Unit {
        double toF(double value);
        double toC(double value);
        double toK(double value);
    }

    private static class F implements Unit {

        @Override
        public double toF(double value) {
            return value;
        }

        @Override
        public double toC(double value) {
            return (value - 32) * 5/9f;
        }

        @Override
        public double toK(double value) {
            return toC(value) + K_OFFSET;
        }
    }

    private static class C implements Unit {

        @Override
        public double toF(double value) {
            return value * 9/5 + 32;
        }

        @Override
        public double toC(double value) {
            return value;
        }

        @Override
        public double toK(double value) {
            return value + K_OFFSET;
        }
    }

    private static class K implements Unit {

        @Override
        public double toF(double value) {
            return (value - K_OFFSET) * 9/5 + 32;
        }

        @Override
        public double toC(double value) {
            return value - K_OFFSET;
        }

        @Override
        public double toK(double value) {
            return value;
        }
    }

}
