package com.climate.android.conversions;


import junit.framework.Assert;

import org.junit.Test;

public class TemperatureUnitTest {

    @Test
    public void testF() {
        Assert.assertEquals(80D, TemperatureUnit.F.toF(80));
        Assert.assertEquals(26.6667, TemperatureUnit.F.toC(80), .0001);
        Assert.assertEquals(299.8167, TemperatureUnit.F.toK(80), .0001);
    }

    @Test
    public void testC() {
        Assert.assertEquals(176D, TemperatureUnit.C.toF(80), .0001);
        Assert.assertEquals(80D, TemperatureUnit.C.toC(80));
        Assert.assertEquals(353.15, TemperatureUnit.C.toK(80), .0001);
    }

    @Test
    public void testK() {
        Assert.assertEquals(-315.67, TemperatureUnit.K.toF(80), .0001);
        Assert.assertEquals(-193.15, TemperatureUnit.K.toC(80), .0001);
        Assert.assertEquals(80D, TemperatureUnit.K.toK(80));
    }

}