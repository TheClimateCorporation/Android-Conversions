package com.climate.android.conversions;


import com.climate.android.common.utils.ConversionUtils;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CropAreaDensityUnitTest {

    @Test
    public void testLbsPerAc() {
        Assert.assertEquals(150D, CropAreaDensityUnit.POUNDS_PER_AC.toPoundsPerAc(150));
        Assert.assertEquals(0.9071858188799999, CropAreaDensityUnit.POUNDS_PER_AC.toMetricTonsPerAc(2000), 1e-10);
        Assert.assertEquals(168.1275, CropAreaDensityUnit.POUNDS_PER_AC.toKilogramsPerHa(150));
        Assert.assertEquals(2.8021249999999998, CropAreaDensityUnit.POUNDS_PER_AC.toBagsPerHa(150), 1e-10);
        Assert.assertEquals(300.0, CropAreaDensityUnit.POUNDS_PER_AC.toBushelsPerAc(150, .5));
    }

    @Test
    public void testKgPerHa() {
        Assert.assertEquals(133.8270062898693, CropAreaDensityUnit.KILOGRAMS_PER_HA.toPoundsPerAc(150), 1e-10);
        Assert.assertEquals(0.8093730819288932, CropAreaDensityUnit.KILOGRAMS_PER_HA.toMetricTonsPerAc(2000), 1e-10);
        Assert.assertEquals(150D, CropAreaDensityUnit.KILOGRAMS_PER_HA.toKilogramsPerHa(150));
        Assert.assertEquals(2.5, CropAreaDensityUnit.KILOGRAMS_PER_HA.toBagsPerHa(150), 1e-10);
        Assert.assertEquals(267.6540125797386, CropAreaDensityUnit.KILOGRAMS_PER_HA.toBushelsPerAc(150, .5));
    }

    @Test
    public void testMetricTonsPerAc() {
        Assert.assertEquals(3306.9299999682107, CropAreaDensityUnit.METRIC_TONS_PER_AC.toPoundsPerAc(1.5), 1e-10);
        Assert.assertEquals(1.5, CropAreaDensityUnit.METRIC_TONS_PER_AC.toMetricTonsPerAc(1.5), 1e-10);
        Assert.assertEquals(3706.5724904643685, CropAreaDensityUnit.METRIC_TONS_PER_AC.toKilogramsPerHa(1.5));
        Assert.assertEquals(61.77620817440614, CropAreaDensityUnit.METRIC_TONS_PER_AC.toBagsPerHa(1.5), 1e-10);
        Assert.assertEquals(6613.859999936421, CropAreaDensityUnit.METRIC_TONS_PER_AC.toBushelsPerAc(1.5, .5));
    }

    @Test
    public void testBagsPerHa() {
        Assert.assertEquals(1070.6160503189544, CropAreaDensityUnit.BAGS_PER_HA.toPoundsPerAc(20), 1e-10);
        Assert.assertEquals(0.485623849157336, CropAreaDensityUnit.BAGS_PER_HA.toMetricTonsPerAc(20), 1e-10);
        Assert.assertEquals(1200D, CropAreaDensityUnit.BAGS_PER_HA.toKilogramsPerHa(20));
        Assert.assertEquals(20D, CropAreaDensityUnit.BAGS_PER_HA.toBagsPerHa(20), 1e-10);
        Assert.assertEquals(2141.232100637909, CropAreaDensityUnit.BAGS_PER_HA.toBushelsPerAc(20, .5));
    }

    @Test
    public void testBushels() {
        Assert.assertEquals(30.0, new CropAreaDensityUnit.Bushels(1.5).toPoundsPerAc(20), 1e-10);
        Assert.assertEquals(0.8300750242752, new CropAreaDensityUnit.Bushels(1.5).toMetricTonsPerAc(1220), 1e-10);
        Assert.assertEquals(33.625499999999995, new CropAreaDensityUnit.Bushels(1.5).toKilogramsPerHa(20));
        Assert.assertEquals(0.560425, new CropAreaDensityUnit.Bushels(1.5).toBagsPerHa(20), 1e-10);
        Assert.assertEquals(20D, new CropAreaDensityUnit.Bushels(1.5).toBushelsPerAc(20, 1));
        Assert.assertEquals(20D, new CropAreaDensityUnit.Bushels(1.5).toBushelsPerAc(20, .5));
    }

    @Test
    public void testValuesMatchOldUtil() {
        Assert.assertEquals(1.12085, CropAreaDensityUnit.POUNDS_PER_AC.toKilogramsPerHa(1));
        Assert.assertEquals(0.892180041932462, CropAreaDensityUnit.KILOGRAMS_PER_HA.toPoundsPerAc(1));
        // this one matches slightly less due to round offs in our precision. matches to 9 decimal points
        // remove the decorator/multiplier and write by hand if this precision isn't enough
        Assert.assertEquals(.00045359260233332444, CropAreaDensityUnit.POUNDS_PER_AC.toMetricTonsPerAc(1), 1e-9);
        Assert.assertEquals(60D, CropAreaDensityUnit.BAGS_PER_HA.toKilogramsPerHa(1));

        double yieldValue = 248.42765895; // bu/ac
        double nominalWeight = 60; // lbs/bu for soy
        double expected = 16707.008492046447; // kg/ha
        double results = new CropAreaDensityUnit.Bushels(nominalWeight).toKilogramsPerHa(yieldValue);
        assertEquals(expected, results, 0);

        double r = ConversionUtils.convertBushelsPerAcreToKilogramsPerHectare(yieldValue, nominalWeight);


        yieldValue = 16707.00161883865; // kg/ha
        nominalWeight = 60; // lbs/bu for soy
        expected = 248.4275567476863; // bu/ac

        results = CropAreaDensityUnit.KILOGRAMS_PER_HA.toBushelsPerAc(yieldValue, nominalWeight);
        assertEquals(expected, results, 0);


        r = ConversionUtils.convertKilogramsPerHectareToBushelsPerAcre(yieldValue, nominalWeight);
        r = ConversionUtils.convertKilogramsPerHectareToPoundsPerAcre(yieldValue);
    }

}