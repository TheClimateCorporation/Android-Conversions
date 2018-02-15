package com.climate.android.conversions;


public class CropAreaDensityUnit {

    private CropAreaDensityUnit() {}

    private static final double BAGS_PER_HA_TO_KG_PER_HA = 60; // 60 bags in 1 hectare
    private static final double LBS_PER_AC_TO_KG_PER_HA = 1.12085D;
    private static final double LBS_PER_AC_TO_METRIC_TON_AC = 0.00045359290944;



    public static final Unit KILOGRAMS_PER_HA = new KgPerHa();
    public static final Unit POUNDS_PER_AC = new PoundsPerAc();
    public static final Unit METRIC_TONS_PER_AC = new Multiplier(POUNDS_PER_AC, 1/LBS_PER_AC_TO_METRIC_TON_AC);
    public static final Unit METRIC_TONS_PER_HA = new Multiplier(METRIC_TONS_PER_AC, 1/2.47105D);
    public static final Unit BAGS_PER_HA = new Multiplier(KILOGRAMS_PER_HA, BAGS_PER_HA_TO_KG_PER_HA);
    // -- Do not create a constant FOR BUSHELS. Client must create it's own using nominal weight --- //


    public interface Unit {
        double toMetricTonsPerAc(double value);
        double toMetricTonsPerHa(double value);
        double toPoundsPerAc(double value);
        double toKilogramsPerHa(double value);
        double toBagsPerHa(double value);
        double toBushelsPerAc(double value, double nominalWeight);
    }

    private static class Multiplier implements Unit {
        private Unit unit;
        private double multiplier;
        private Multiplier(Unit unit, double multiplier) {
            this.unit = unit;
            this.multiplier = multiplier;
        }

        @Override
        public double toMetricTonsPerAc(double value) {
            return unit.toMetricTonsPerAc(value * multiplier);
        }

        @Override
        public double toMetricTonsPerHa(double value) {
            return unit.toMetricTonsPerHa(value * multiplier);
        }

        @Override
        public double toPoundsPerAc(double value) {
            return unit.toPoundsPerAc(value * multiplier);
        }

        @Override
        public double toKilogramsPerHa(double value) {
            return unit.toKilogramsPerHa(value * multiplier);
        }

        @Override
        public double toBagsPerHa(double value) {
            return unit.toBagsPerHa(value * multiplier);
        }

        @Override
        public double toBushelsPerAc(double value, double nominalWeight) {
            return unit.toBushelsPerAc(value * multiplier, nominalWeight);
        }
    }

    private static class KgPerHa implements Unit {
        @Override
        public double toMetricTonsPerAc(double value) {
            return toPoundsPerAc(value) * LBS_PER_AC_TO_METRIC_TON_AC;
        }

        @Override
        public double toMetricTonsPerHa(double value) {
            return value * 0.001;
        }

        @Override
        public double toPoundsPerAc(double value) {
            return value * 1/LBS_PER_AC_TO_KG_PER_HA;
        }

        @Override
        public double toKilogramsPerHa(double value) {
            return value;
        }

        @Override
        public double toBagsPerHa(double value) {
            return value / BAGS_PER_HA_TO_KG_PER_HA;
        }

        @Override
        public double toBushelsPerAc(double value, double nominalWeight) {
            return toPoundsPerAc(value) / nominalWeight;
        }
    }

    private static class PoundsPerAc implements Unit {

        @Override
        public double toMetricTonsPerAc(double value) {
            return value * LBS_PER_AC_TO_METRIC_TON_AC;
        }

        @Override
        public double toMetricTonsPerHa(double value) {
            return toKilogramsPerHa(value) * 0.001;
        }

        @Override
        public double toPoundsPerAc(double value) {
            return value;
        }

        @Override
        public double toKilogramsPerHa(double value) {
            return value * LBS_PER_AC_TO_KG_PER_HA;
        }

        @Override
        public double toBagsPerHa(double value) {
            return toKilogramsPerHa(value) / BAGS_PER_HA_TO_KG_PER_HA;
        }

        @Override
        public double toBushelsPerAc(double value, double nominalWeight) {
            return value / nominalWeight;
        }
    }


    /**
     * Bushels /ac are just Pounds / Ac with an offset on the Pounds.
     * That means bushels are lbs/ac divided by the nominal weight.
     * The offset varies by crop
     * and the farmer can even specific their own offset.
     */
    public static class Bushels implements Unit {
        private final double nominalWeight;
        public Bushels(double nominalWeight) {
            this.nominalWeight = nominalWeight;
        }

        @Override
        public double toMetricTonsPerAc(double value) {
            return POUNDS_PER_AC.toMetricTonsPerAc(toPoundsPerAc(value));
        }

        @Override
        public double toMetricTonsPerHa(double value) {
            throw new RuntimeException("Method not implemented yet");
        }

        @Override
        public double toKilogramsPerHa(double value) {
            return POUNDS_PER_AC.toKilogramsPerHa(toPoundsPerAc(value));
        }

        @Override
        public double toPoundsPerAc(double value) {
            return value * nominalWeight;
        }

        @Override
        public double toBagsPerHa(double value) {
            return POUNDS_PER_AC.toBagsPerHa(toPoundsPerAc(value));
        }


        @Override
        public double toBushelsPerAc(double value, double nominalWeight) {
            return value;
        }
    }
}
