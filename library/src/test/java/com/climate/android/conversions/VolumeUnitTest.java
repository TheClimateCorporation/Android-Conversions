package com.climate.android.conversions;


import junit.framework.Assert;

import org.junit.Test;

public class VolumeUnitTest {

    @Test
    public void testLiters() {
        Assert.assertEquals(123D, VolumeUnit.LITERS.toLiters(123));
        Assert.assertEquals(465.6056494319972, VolumeUnit.US_GALLONS.toLiters(123), 1e-10);
    }


    @Test
    public void testGallons() {
        Assert.assertEquals(32.49316244005245, VolumeUnit.LITERS.toUSGallons(123), 1e-10);
        Assert.assertEquals(123D, VolumeUnit.US_GALLONS.toUSGallons(123));
    }
}