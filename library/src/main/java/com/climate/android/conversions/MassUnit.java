package com.climate.android.conversions;


public class MassUnit {

    private MassUnit() {}

    public static final Unit POUNDS = new Pounds();
    public static final Unit OUNCES = new Multiplier(POUNDS, 0.0625);
    public static final Unit US_TONS = new Multiplier(POUNDS, 2000);
    public static final Unit IMPERIAL_TONS = new Multiplier(POUNDS, 2240);
    public static final Unit GRAMS = new Grams();
    public static final Unit MILLIGRAMS = new Multiplier(GRAMS, .001);
    public static final Unit KILOGRAMS = new Multiplier(GRAMS, 1000) {
        @Override
        public double toMetricTons(double value) {
            return value * .001; // override due to float errors
        }
    };
    public static final Unit SACAS = new Multiplier(KILOGRAMS, 60D); // 60kg = 1 saca
    public static final Unit METRIC_TONS = new Multiplier(GRAMS, 1e+6) {
        @Override
        public double toMetricTons(double value) {
            return value; // override due to float errors
        }
    };


    public interface Unit {
        double toOunces(double value);
        double toPounds(double value);
        double toUsTons(double value);
        double toImperialTons(double value);
        double toMetricTons(double value);
        double toMilligrams(double value);
        double toGrams(double value);
        double toKilograms(double value);
        double toBushels(double value, double nominalWeight);
        double toSacas(double value);
    }

    private static class Multiplier implements Unit {
        private Unit unit;
        private double multiplier;

        private Multiplier(Unit unit, double multiplier) {
            this.unit = unit;
            this.multiplier = multiplier;
        }

        @Override
        public double toOunces(double value) { return unit.toOunces(value * multiplier); }

        @Override
        public double toPounds(double value) { return unit.toPounds(value * multiplier); }

        @Override
        public double toUsTons(double value) { return unit.toUsTons(value * multiplier);}

        @Override
        public double toImperialTons(double value) { return unit.toImperialTons(value * multiplier); }

        @Override
        public double toMetricTons(double value) { return unit.toMetricTons(value * multiplier); }

        @Override
        public double toMilligrams(double value) { return unit.toMilligrams(value * multiplier); }

        @Override
        public double toGrams(double value) { return unit.toGrams(value * multiplier); }

        @Override
        public double toKilograms(double value) { return unit.toKilograms(value * multiplier);}

        @Override
        public double toBushels(double value, double nominalWeight) {
            return unit.toBushels(value * multiplier, nominalWeight);
        }

        @Override
        public double toSacas(double value) { return unit.toSacas(value * multiplier); }
    }

    private static class Pounds implements Unit {
        @Override
        public double toOunces(double value) {
            return value * 16;
        }

        @Override
        public double toPounds(double value) {
            return value;
        }

        @Override
        public double toBushels(double value, double nominalWeight) {
            return value / nominalWeight;
        }

        @Override
        public double toUsTons(double value) {
            return value * 0.0005;
        }

        @Override
        public double toImperialTons(double value) {
            return value * (1/2240D);
        }

        @Override
        public double toMetricTons(double value) {
            return toGrams(value) * 1e-6;
        }

        @Override
        public double toMilligrams(double value) {
            return toGrams(value) * 1000;
        }

        @Override
        public double toGrams(double value) {
            return value * 16 * 28.349523125; // 28.349523125 exact value
        }

        @Override
        public double toKilograms(double value) {
            return toGrams(value) * 0.001;
        }

        @Override
        public double toSacas(double value) {
            return toKilograms(value) / 60D; // 60 kg = 1 saca
        }
    }

    private static class Grams implements Unit {

        @Override
        public double toOunces(double value) {
            return value / 28.349523125D;
        }

        @Override
        public double toPounds(double value) {
            return toOunces(value) / 16D;
        }

        @Override
        public double toBushels(double value, double nominalWeight) {
            return toPounds(value) / nominalWeight;
        }

        @Override
        public double toUsTons(double value) {
            return toPounds(value) * 0.0005;
        }

        @Override
        public double toImperialTons(double value) {
            return toPounds(value) * (1/2240D);
        }

        @Override
        public double toMetricTons(double value) {
            return value * .000001D;
        }

        @Override
        public double toMilligrams(double value) {
            return value * 1000;
        }

        @Override
        public double toGrams(double value) {
            return value;
        }

        @Override
        public double toKilograms(double value) {
            return value * .001;
        }

        @Override
        public double toSacas(double value) {
            return toKilograms(value) / 60D; // 60 kg = 1 saca
        }
    }

    /**
     * Bushels are just Pounds with an offset value.
     * The offset varies by crop
     * and the farmer can even specific their own offset.
     */
    public static class Bushels implements Unit {
        private final double nominalWeight;

        public Bushels(double nominalWeight) {
            this.nominalWeight = nominalWeight;
        }

        @Override
        public double toOunces(double value) {
            return POUNDS.toOunces(toPounds(value));
        }

        @Override
        public double toPounds(double value) {
            return value * nominalWeight;
        }

        @Override
        public double toUsTons(double value) {
            return POUNDS.toUsTons(toPounds(value));
        }

        @Override
        public double toImperialTons(double value) {
            return POUNDS.toImperialTons(toPounds(value));
        }

        @Override
        public double toMetricTons(double value) {
            return POUNDS.toMetricTons(toPounds(value));
        }

        @Override
        public double toMilligrams(double value) {
            return POUNDS.toMilligrams(toPounds(value));
        }

        @Override
        public double toGrams(double value) {
            return POUNDS.toGrams(toPounds(value));
        }

        @Override
        public double toKilograms(double value) {
            return POUNDS.toKilograms(toPounds(value));
        }

        @Override
        public double toBushels(double value, double nominalWeight) {
            return value;
        }

        @Override
        public double toSacas(double value) {
            return toKilograms(value) / 60D; // 60 kg = 1 saca
        }
    }
}
