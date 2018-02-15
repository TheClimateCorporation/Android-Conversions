package com.climate.android.conversions;


import junit.framework.Assert;

import org.junit.Test;

public class SpeedUnitTest {


    @Test
    public void testFeetPerSecond() {
        Assert.assertEquals(20D, SpeedUnit.FEET_PER_SECOND.toFeetPerSecond(20));
        Assert.assertEquals(13.636363636363637, SpeedUnit.FEET_PER_SECOND.toMilesPerHour(20),
                .0000000000001);
        Assert.assertEquals(6.096, SpeedUnit.FEET_PER_SECOND.toMetersPerSecond(20));
        Assert.assertEquals(21.9456, SpeedUnit.FEET_PER_SECOND.toKilometersPerHour(20));
        Assert.assertEquals(11.849676025917926, SpeedUnit.FEET_PER_SECOND.toKnots(20),
                .0000000000001);
    }

    @Test
    public void testMetersPerSecond() {
        Assert.assertEquals(65.61679790026247, SpeedUnit.METERS_PER_SECOND.toFeetPerSecond(20),
                .000000000001);
        Assert.assertEquals(44.73872584108805, SpeedUnit.METERS_PER_SECOND.toMilesPerHour(20),
                .0000000000001);
        Assert.assertEquals(20D, SpeedUnit.METERS_PER_SECOND.toMetersPerSecond(20));
        Assert.assertEquals(72D, SpeedUnit.METERS_PER_SECOND.toKilometersPerHour(20));
        Assert.assertEquals(38.87688984881209, SpeedUnit.METERS_PER_SECOND.toKnots(20),
                .0000000000001);
    }

    @Test
    public void testMilesPerHour() {
        Assert.assertEquals(23.466666666666665, SpeedUnit.MILES_PER_HOUR.toFeetPerSecond(16),
                .00000000000001);
        Assert.assertEquals(16D, SpeedUnit.MILES_PER_HOUR.toMilesPerHour(16),
                .0000000000001);
        Assert.assertEquals(16.0015D, SpeedUnit.MILES_PER_HOUR.toMilesPerHour(16.0015),
                .0000000000001);
        Assert.assertEquals(3.2186879999999998, SpeedUnit.MILES_PER_HOUR.toMetersPerSecond(7.2));
        Assert.assertEquals(96.56064, SpeedUnit.MILES_PER_HOUR.toKilometersPerHour(60));
        Assert.assertEquals(13.03464362850972, SpeedUnit.MILES_PER_HOUR.toKnots(15),
                .0000000000001);
    }

    @Test
    public void testKilometersPerHour() {
        Assert.assertEquals(32.808398950131235, SpeedUnit.KILOMETERS_PER_HOUR.toFeetPerSecond(36),
                .00000000000001);
        Assert.assertEquals(12.427423844746679, SpeedUnit.KILOMETERS_PER_HOUR.toMilesPerHour(20),
                .0000000000001);
        Assert.assertEquals(2D, SpeedUnit.KILOMETERS_PER_HOUR.toMetersPerSecond(7.2));
        Assert.assertEquals(7.2, SpeedUnit.KILOMETERS_PER_HOUR.toKilometersPerHour(7.2));
        Assert.assertEquals(2D, SpeedUnit.KILOMETERS_PER_HOUR.toKnots(3.704),
                .0000000000001);
    }

    @Test
    public void testKnotsPerHour() {
        Assert.assertEquals(60.76115485564304, SpeedUnit.KNOTS.toFeetPerSecond(36),
                .00000000000001);
        Assert.assertEquals(23.01558896047085, SpeedUnit.KNOTS.toMilesPerHour(20),
                .0000000000001);
        Assert.assertEquals(3.704, SpeedUnit.KNOTS.toMetersPerSecond(7.2));
        Assert.assertEquals(5.556, SpeedUnit.KNOTS.toKilometersPerHour(3));
        Assert.assertEquals(3D, SpeedUnit.KNOTS.toKnots(3));
    }


}