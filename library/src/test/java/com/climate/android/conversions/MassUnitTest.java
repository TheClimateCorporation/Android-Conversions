package com.climate.android.conversions;


import junit.framework.Assert;

import org.junit.Test;

public class MassUnitTest {

    @Test
    public void testPounds() {
        Assert.assertEquals(32D, MassUnit.POUNDS.toOunces(2));
        Assert.assertEquals(2D, MassUnit.POUNDS.toPounds(2));
        Assert.assertEquals(2D, MassUnit.POUNDS.toUsTons(4000));
        Assert.assertEquals(1D, MassUnit.POUNDS.toImperialTons(2240));

        Assert.assertEquals(11339.80925, MassUnit.POUNDS.toGrams(25));
        Assert.assertEquals(680388.555, MassUnit.POUNDS.toMilligrams(1.5));
        Assert.assertEquals(9.0718474, MassUnit.POUNDS.toKilograms(20), .0000001);
        Assert.assertEquals(.453592369999, MassUnit.POUNDS.toMetricTons(1000), .00000000001);
    }

    @Test
    public void testOunces() {
        Assert.assertEquals(16D, MassUnit.OUNCES.toOunces(16));
        Assert.assertEquals(0.125, MassUnit.OUNCES.toPounds(2));
        Assert.assertEquals(0.0625, MassUnit.OUNCES.toUsTons(2000));
        Assert.assertEquals(1D, MassUnit.OUNCES.toImperialTons(35840));

        Assert.assertEquals(12927.382545, MassUnit.OUNCES.toGrams(456));
        Assert.assertEquals(113398.0925, MassUnit.OUNCES.toMilligrams(4));
        Assert.assertEquals(17.009713875, MassUnit.OUNCES.toKilograms(600), .0000001);
        Assert.assertEquals(1.7009713874999, MassUnit.OUNCES.toMetricTons(60000), .00000000001);
    }

    @Test
    public void testGrams() {
        Assert.assertEquals(1.4109584779832165, MassUnit.GRAMS.toOunces(40));
        Assert.assertEquals(5.511556554621939, MassUnit.GRAMS.toPounds(2500));
        Assert.assertEquals(.06613867865546327, MassUnit.GRAMS.toUsTons(60000));
        Assert.assertEquals(.05905239165666363, MassUnit.GRAMS.toImperialTons(60000));

        Assert.assertEquals(400D, MassUnit.GRAMS.toGrams(400));
        Assert.assertEquals(400000D, MassUnit.GRAMS.toMilligrams(400));
        Assert.assertEquals(.4, MassUnit.GRAMS.toKilograms(400));
        Assert.assertEquals(0.0004, MassUnit.GRAMS.toMetricTons(400), .00001);
    }

    @Test
    public void testKilograms() {
        Assert.assertEquals(1410.9584779832164, MassUnit.KILOGRAMS.toOunces(40));
        Assert.assertEquals(88.18490487395103, MassUnit.KILOGRAMS.toPounds(40));
        Assert.assertEquals(66.13867865546327, MassUnit.KILOGRAMS.toUsTons(60000));
        Assert.assertEquals(59.05239165666363, MassUnit.KILOGRAMS.toImperialTons(60000));

        Assert.assertEquals(400000D, MassUnit.KILOGRAMS.toGrams(400));
        Assert.assertEquals(4000000D, MassUnit.KILOGRAMS.toMilligrams(4));
        Assert.assertEquals(400D, MassUnit.KILOGRAMS.toKilograms(400));
        Assert.assertEquals(0.4, MassUnit.KILOGRAMS.toMetricTons(400), .00001);
        Assert.assertEquals(1.5, MassUnit.KILOGRAMS.toSacas(90), .00001);
    }

    @Test
    public void testSacas() {
        Assert.assertEquals(60D, MassUnit.SACAS.toKilograms(1));
        Assert.assertEquals(150D, MassUnit.SACAS.toKilograms(2.5));
        Assert.assertEquals(1D, MassUnit.SACAS.toSacas(1));
    }

    @Test
    public void testMilligrams() {
        Assert.assertEquals(14.109584779832165, MassUnit.MILLIGRAMS.toOunces(400000), 1e-10);
        Assert.assertEquals(0.8818490487395103, MassUnit.MILLIGRAMS.toPounds(400000), 1e-10);
        Assert.assertEquals(0.9920801798319491, MassUnit.MILLIGRAMS.toUsTons(9e8), 1e-10);
        Assert.assertEquals(0.88578587485, MassUnit.MILLIGRAMS.toImperialTons(9e8), 1e-10);

        Assert.assertEquals(0.4, MassUnit.MILLIGRAMS.toGrams(400));
        Assert.assertEquals(400D, MassUnit.MILLIGRAMS.toMilligrams(400));
        Assert.assertEquals(0.0004, MassUnit.MILLIGRAMS.toKilograms(400));
        Assert.assertEquals(0.0004, MassUnit.MILLIGRAMS.toMetricTons(400000), .0000001);
    }

    @Test
    public void testMetricTon() {
        Assert.assertEquals(.8818490487395103, MassUnit.METRIC_TONS.toOunces(2.5e-5), 1e-10);
        Assert.assertEquals(0.055115565546219394, MassUnit.METRIC_TONS.toPounds(2.5e-5), 1e-10);
        Assert.assertEquals(2.75577827731097, MassUnit.METRIC_TONS.toUsTons(2.5), 1e-10);
        Assert.assertEquals(2.4605163190276516, MassUnit.METRIC_TONS.toImperialTons(2.5), 1e-10);

        Assert.assertEquals(25D, MassUnit.METRIC_TONS.toGrams(2.5e-5));
        Assert.assertEquals(25000D, MassUnit.METRIC_TONS.toMilligrams(2.5e-5));
        Assert.assertEquals(0.025, MassUnit.METRIC_TONS.toKilograms(2.5e-5));
        Assert.assertEquals(2.5e-5, MassUnit.METRIC_TONS.toMetricTons(2.5e-5));
    }

    @Test
    public void testUsTon() {
        Assert.assertEquals(0.8, MassUnit.US_TONS.toOunces(2.5e-5), 1e-10);
        Assert.assertEquals(5000D, MassUnit.US_TONS.toPounds(2.5), 1e-10);
        Assert.assertEquals(2.5, MassUnit.US_TONS.toUsTons(2.5), 1e-10);
        Assert.assertEquals(2.232142857142857, MassUnit.US_TONS.toImperialTons(2.5), 1e-10);

        Assert.assertEquals(22.6796185, MassUnit.US_TONS.toGrams(2.5e-5), 1e-10);
        Assert.assertEquals(22679.6185, MassUnit.US_TONS.toMilligrams(2.5e-5), 1e-10);
        Assert.assertEquals(0.0226796185, MassUnit.US_TONS.toKilograms(2.5e-5), 1e-10);
        Assert.assertEquals(2.26796185, MassUnit.US_TONS.toMetricTons(2.5));
    }

    @Test
    public void testImperialTon() {
        Assert.assertEquals(0.896, MassUnit.IMPERIAL_TONS.toOunces(2.5e-5), 1e-10);
        Assert.assertEquals(5600D, MassUnit.IMPERIAL_TONS.toPounds(2.5), 1e-10);
        Assert.assertEquals(5600, MassUnit.IMPERIAL_TONS.toUsTons(5000), 1e-10);
        Assert.assertEquals(2.5, MassUnit.IMPERIAL_TONS.toImperialTons(2.5), 1e-10);

        Assert.assertEquals(25.40117272, MassUnit.IMPERIAL_TONS.toGrams(2.5e-5), 1e-10);
        Assert.assertEquals(25401.17272, MassUnit.IMPERIAL_TONS.toMilligrams(2.5e-5), 1e-10);
        Assert.assertEquals(0.02540117272, MassUnit.IMPERIAL_TONS.toKilograms(2.5e-5), 1e-10);
        Assert.assertEquals(2.540117272, MassUnit.IMPERIAL_TONS.toMetricTons(2.5));
    }

    @Test
    public void testPounds_legal_definition() {
        Assert.assertEquals(0.45359237, MassUnit.POUNDS.toKilograms(1));
    }

    @Test
    public void testBushels() {
        Assert.assertEquals(2, new MassUnit.Bushels(.5).toPounds(4), 1e-10);
    }

}